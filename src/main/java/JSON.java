import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class JSON {
    public static OkHttpClient client = new OkHttpClient();

    public static String getJSON(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public static String[] getBook(String bookName) {
        String json = null;
        bookName = bookName.replaceAll(" ", "_");
        try {
            json = getJSON("http://isbndb.com/api/v2/json/GSZ82QQ6/book/" + bookName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        Isbndb isbndb = gson.fromJson(json, Isbndb.class);
        List<Datum> dt = isbndb.getData();
        Datum book = dt.get(0);
        String title = book.getTitleLong();
        if (book.getTitleLong().equals("")) {
            title = book.getTitle();
        }
        List<AuthorDatum> authorList = book.getAuthorData();
        String author = "";
        for (AuthorDatum x : authorList) {
            author += x.getName() + "\n";
        }
        return new String[]{
                "Title: " + title,
                "Summary: " + book.getSummary(),
                "Language: " + book.getLanguage(),
                "Publisher: " + book.getPublisherName(),
                "Author(s): " + author
        };
    }

    public static String[] getData(String movieName) {
        String json = null;
        try {
            json = getJSON("http://www.omdbapi.com/?t=" + movieName + "&plot=full");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        OmdbAPI omdbAPI = gson.fromJson(json, OmdbAPI.class);

        // the return statement builds an array of strings from the API
        return new String[]{
                "Title: " + omdbAPI.getTitle(),
                "Plot: " + omdbAPI.getPlot(),
                "Imdb Rating - " + omdbAPI.getImdbRating(),
                "Release Date: " + omdbAPI.getReleased(),
                "Director: " + omdbAPI.getDirector(),
                "Actors: " + omdbAPI.getActors(),
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

    public static String getCover(String bookName) {
        String json = null;
        bookName = bookName.replaceAll(" ", "_");
        try {
            json = getJSON("http://isbndb.com/api/v2/json/GSZ82QQ6/book/" + bookName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        Isbndb isbndb = gson.fromJson(json, Isbndb.class);
        List<Datum> dt = isbndb.getData();
        Datum book = dt.get(0);
        String isbn = book.getIsbn13();
        return "http://covers.openlibrary.org/b/isbn/" + isbn + "-L.jpg";
    }

}
