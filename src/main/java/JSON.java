import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;

public class JSON {
    public static OkHttpClient client = new OkHttpClient();

    public static String getJSON(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }
    public static String[] getData(String movieName) {
        String json = null;
        try {
            json = getJSON("http://www.omdbapi.com/?t=" + movieName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        OmdbAPI omdbAPI = gson.fromJson(json, OmdbAPI.class);

        // the return statement builds an array of strings from the API
        return new String[]{
                "Name: " + omdbAPI.getTitle(),
                "Description: " + omdbAPI.getPlot(),
                "Imdb Rating - " + omdbAPI.getImdbRating(),
                "Imdb Release Date: " + omdbAPI.getReleased(),
                
        };
    }
    
    public static String getPoster(String movieName)
    {
        String json = null;
        try {
            json = getJSON("http://www.omdbapi.com/?t=" + movieName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        OmdbAPI imdbapi = gson.fromJson(json, OmdbAPI.class);

        return imdbapi.getPoster();
    }
}
