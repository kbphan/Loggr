import java.io.*;
import java.net.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
public class MoviePoster
{
    private String filePath;
    public MoviePoster(String title, String url)
    {
        this.filePath = fetchPosterImage(title, url);
    }
    
    public String getFilePath()
    {
        return this.filePath;
    }
    
    public BufferedImage getPoster()
    {
        
        try
        {
        return ImageIO.read(new File(this.filePath));
        }
        catch(IOException e)
        {
            return null;
        }
    }
    
    private String fetchPosterImage(String title, String url)
    {
        if(url.equalsIgnoreCase("n/a"))
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
        
        return "poster/" + titleToFileName(title) + url.substring(url.lastIndexOf("."));
    }
    
    private String titleToFileName(String title)
    {
        return title.replaceAll("[^A-Za-z0-9 ]", "").replaceAll(" ", "_");
    }
}