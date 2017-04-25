//package loggr;
import java.util.*;
public class MediaElement extends Element {
    private ImdbAPI omdbData;
    MediaElement() {
        super();
        setType("media");
    }
    MediaElement(String name, Date lastViewed, Date dateStarted) {
        super(name, lastViewed, dateStarted);
        setType("media");
        this.omdbData = new ImdbAPI(name);
    }
    
    public ImdbAPI getOmdbData()
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
}
