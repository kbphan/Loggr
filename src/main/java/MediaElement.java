//package loggr;
import java.util.*;
import java.awt.image.BufferedImage;
public class MediaElement extends Element {
    private MoviePoster poster;
    MediaElement() {
        super();
        setType("media");
    }
    MediaElement(String name, Date lastViewed, Date dateStarted) {
        super(name, lastViewed, dateStarted);
        setType("media");
        this.poster = new MoviePoster(name, JSON.getPoster(name));
    }

    public BufferedImage getPoster()
    {
        return poster.getPoster();
    }
    
}
