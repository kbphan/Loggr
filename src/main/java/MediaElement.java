//package loggr;
import java.util.*;
import java.awt.image.BufferedImage;
public class MediaElement extends Element {
    private ImdbAPI_old omdbData;
    MediaElement() {
        super();
        setType("media");
    }
    MediaElement(String name, Date lastViewed, Date dateStarted) {
        super(name, lastViewed, dateStarted);
        setType("media");
        this.omdbData = new ImdbAPI_old(name);
    }
    
    public ImdbAPI_old getOmdbData()
    {
            return this.omdbData;
    }
    
    public String getRawOmdbData()
    {
        return this.omdbData.getRawText();
    }
    
    public String getFilmRating()
    {
        return this.omdbData.getFilmRating();
    }
    
    public String getReleaseYear()
    {
        return this.omdbData.getReleaseYear();
    }
    
    public String getGenres()
    {
        return this.omdbData.getGenres();
    }
    
    public BufferedImage getPoster()
    {
        return this.omdbData.getPoster();
    }
}
