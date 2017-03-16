//package loggr;
import java.util.*;
public class MediaElement extends Element {
    MediaElement() {
        super();
        setType("media");
    }
    MediaElement(String name, Date lastViewed, Date dateStarted) {
        super(name, lastViewed, dateStarted);
        setType("media");
    }
}
