//package loggr;
import java.util.*;
public class TextElement extends Element {
    TextElement() {
        super();
        setType("text");
    }
    TextElement(String name, Date lastViewed, Date dateStarted) {
        super(name, lastViewed, dateStarted);
        setType("text");
    }
}
