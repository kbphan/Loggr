//package loggr;
import java.util.*;
public class MediaElement extends Element {
    ImdbAPI omdbData;
    MediaElement() {
        super();
        setType("media");
    }
    MediaElement(String name, Date lastViewed, Date dateStarted) {
        super(name, lastViewed, dateStarted);
        setType("media");
        omdbData = new ImdbAPI(name);
    }
    
    public ImdbAPI getOmdbData()
    {
            return this.omdbData;
    }
    
}
