import java.util.*;
public class Driver {
    public static void main(String[] args) {

    }
}

class Database {
    private ArrayList<Element> db;
    Database() {
        db = new ArrayList<>();
    }
    public void add(Element elm) {
        db.add(elm);
    }
}

class Element implements Comparable<Element> {
    private String mode;
    private String mediaType;
    public Element() {
    	mode = "";
    	mediaType = "";
    }
    public int compareTo(Element x) {
        return 0;
    }
}
