import java.io.*;
import java.net.*;

public class ImdbAPI {
    
    private String rawText, filmRating, releaseYear, genres;
    public ImdbAPI(String title)
    {
        this.rawText = omdbGet(title);
        this.filmRating = this.parseFilmRating();
        this.releaseYear = this.parseReleaseYear();
        this.genres = this.parseGenres();
    }
    
    public String getRawText()
    {
        return this.rawText;
    }
    
    public String getFilmRating()
    {
        return this.filmRating;
    }
    
    public String getReleaseYear()
    {
        return this.releaseYear;
    }
    
    public String getGenres()
    {
        return this.genres;
    }
    
    private String parseGenres()
    {
        if(this.rawText.contains("\"Response\":\"False\""))
        {
            return null;
        }
        int a = this.rawText.indexOf("\"Genre\":\"") + 9;
        int b = this.rawText.indexOf("\",\"Director\":\"");
        return this.rawText.substring(a,b);
    }
    
    private String parseFilmRating()
    {
        if(this.rawText.contains("\"Response\":\"False\""))
        {
            return null;
        }
        int a = this.rawText.indexOf("\"Rated\":\"") + 9;
        int b = this.rawText.indexOf("\",\"Released\":\"");
        return this.rawText.substring(a,b);
    }
    
    private String parseReleaseYear()
    {
        if(this.rawText.contains("\"Response\":\"False\""))
        {
            return null;
        }
        int a = this.rawText.indexOf("\"Year\":\"") + 8;
        int b = this.rawText.indexOf("\",\"Rated\":\"");
        return this.rawText.substring(a,b);
    }
    
    private String omdbGet(String title)
    {
        StringBuilder result = new StringBuilder();
        title = title.replaceAll(" ", "_");
        URL url;
        try
        {
            url = new URL("http://www.omdbapi.com/?t=" + title);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            try (BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream())))
            {
                String line;
                while((line = rd.readLine()) != null)
                {
                    result.append(line);
                }
            }
        }
        catch(MalformedURLException e)
        {
            return e.toString();
        }
        catch(IOException e)
        {
            return e.toString();
        }
        return result.toString();
    }
}
