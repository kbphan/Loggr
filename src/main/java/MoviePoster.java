import java.io.*;
import java.net.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
public class MoviePoster
{
    private String filePath;
    public MoviePoster(String title, String url)
    {
        fetchPosterImage(title, url);
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
    
    private void fetchPosterImage(String title, String url)
    {
        if(url.equalsIgnoreCase("n/a"))
        {
            this.filePath = null;
            return;
        }
        try
        {
            BufferedImage img = ImageIO.read(new URL(url));
            this.filePath = "posters/" + titleToFileName(title) + url.substring(url.lastIndexOf("."));
            File imgFile = new File(this.filePath);
            ImageIO.write(img, url.substring(url.lastIndexOf(".") + 1), imgFile);
        }
        catch(MalformedURLException e)
        {
            System.out.println(e.toString());
            this.filePath = null;
        }
        catch(IOException e)
        {
            System.out.println(e.toString());
            this.filePath = null;
        }
    }
    
    private String titleToFileName(String title)
    {
        return title.replaceAll("[^A-Za-z0-9 ]", "").replaceAll(" ", "_");
    }
}