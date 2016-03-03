package vasista.varun.com.popularmovies.movieproject1;
import android.net.Uri;
/**
 * Created by varunvasistakusuma on 03/03/16.
 */
public class Api {

    public static final String API_KEY = "YOUR_API_KEY";
    public static final String BASE_URL = "http://api.themoviedb.org/3/discover/movie?";
    public static final String IMAGE_BASE_URL = "http://image.tmdb.org/t/p/w185";
    public static final String NOT_AVAILABLE = "Not Available";

    public static final class JSON {
        public static final String ID = "id";
        public static final String ORIGINAL_TITLE = "original_title";
        public static final String TITLE = "title";
        public static final String POSTER_IMAGE = "poster_path";
        public static final String OVERVIEW = "overview";
        public static final String RATING = "vote_average";
        public static final String POPULARITY = "popularity";
        public static final String RELEASE_DATE = "release_date";
        public static final String RESULTS = "results";
        public static final String VOTE_COUNT = "vote_count";
        public static final String SORT_BY = "sort_by";

        public static final String POPULAR_MOVIE_URL =
                Uri.parse(Api.BASE_URL)
                        .buildUpon()
                        .appendQueryParameter(SORT_BY, POPULARITY + ".desc")
                        .appendQueryParameter("api_key", Api.API_KEY)
                        .build().toString();

        public static final String HIGH_RATED_MOVIE_URL = Uri.parse(Api.BASE_URL)
                .buildUpon()
                .appendQueryParameter(SORT_BY, RATING + ".desc")
                .appendQueryParameter(VOTE_COUNT + ".gte", "50")
                .appendQueryParameter("api_key", Api.API_KEY)
                .build().toString();
    }
}

