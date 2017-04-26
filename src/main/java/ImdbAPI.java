import java.io.*;
import java.net.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class ImdbAPI {
    
    private String rawText, filmRating, releaseYear, genres, posterFilePath;
    public ImdbAPI(String title)
    {
        this.rawText = omdbGet(title);
        this.filmRating = this.parseFilmRating();
        this.releaseYear = this.parseReleaseYear();
        this.genres = this.parseGenres();
        this.posterFilePath = this.fetchPosterImage();
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
    
    public String getPosterFilePath()
    {
        return this.posterFilePath;
    }
    
    public BufferedImage getPoster()
    {
        try
        {
        return ImageIO.read(new File(this.posterFilePath));
        }
        catch(IOException e)
        {
            System.out.println(e.toString());
            return null;
        }
    }
    
    private String fetchPosterImage()
    {
        if(!this.rawText.contains("\"Poster\":\""))
        {
            return null;
        }
        int a = this.rawText.indexOf("\"Poster\":\"") + 10;
        int b = this.rawText.indexOf("\",\"Ratings\":[");
        String url = this.rawText.substring(a,b);
        if(a == -1 || b == -1 || url.equalsIgnoreCase("n/a"))
        {
            return null;
        }
        BufferedImage img = null;
        try
        {
            img = ImageIO.read(new URL(url));
            File imgFile = new File("posters/" + url.substring(url.lastIndexOf("/") + 1));
            ImageIO.write(img, url.substring(url.lastIndexOf(".") + 1), imgFile);
            
        }
        catch(MalformedURLException e)
        {
            System.out.println(e.toString());
            return null;
        }
        catch(IOException e)
        {
            System.out.println(e.toString());
            return null;
        }
        
        return "poster/" + url;
    }
    
    private String parseGenres()
    {
        if(this.rawText.contains("\"Response\":\"False\""))
        {
            return null;
        }
        int a = this.rawText.indexOf("\"Genre\":\"") + 9;
        int b = this.rawText.indexOf("\",\"Director\":\"");
        if(a == -1 || b == -1)
        {
            return null;
        }
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
        if(a == -1 || b == -1)
        {
            return null;
        }
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
        if(a == -1 || b == -1)
        {
            return null;
        }
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
