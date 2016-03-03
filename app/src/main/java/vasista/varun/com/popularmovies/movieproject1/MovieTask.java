package vasista.varun.com.popularmovies.movieproject1;
import org.json.JSONException;
import org.json.JSONObject;
import android.os.AsyncTask;
import android.util.Log;
import vasista.varun.com.popularmovies.http.Connect;
/**
 * Created by varunvasistakusuma on 03/03/16.
 */
public class MovieTask extends AsyncTask<String, Void, JSONObject> {

    public interface OnTaskStatusListener {
        void onTaskStart();

        void onResponseReceived(JSONObject response);

        void onTaskEnd();
    }

    public static final String TAG = MovieTask.class.getSimpleName();

    private OnTaskStatusListener mTaskStatusListener;

    public MovieTask(OnTaskStatusListener listener) {
        mTaskStatusListener = listener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if (mTaskStatusListener != null) {
            mTaskStatusListener.onTaskStart();
        }
    }

    @Override
    protected JSONObject doInBackground(String... params) {
        if (params.length == 0) {
            return null;
        }

        JSONObject responseObject = null;

        String response = Connect.doNetworkRequest(params[0]);
        if (response != null) {
            Log.d(TAG, response);
            try {
                responseObject = new JSONObject(response);
            } catch (JSONException e) {
                e.printStackTrace();
                responseObject = null;
            }
        } else {
            Log.d(TAG, "Error Occured while requesting data.");
        }
        return responseObject;
    }

    @Override
    protected void onPostExecute(JSONObject response) {
        super.onPostExecute(response);

        if (mTaskStatusListener != null) {
            mTaskStatusListener.onResponseReceived(response);
            mTaskStatusListener.onTaskEnd();
        }
    }
}