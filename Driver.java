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

}

class Element implements Comparable<Element> {

    public Element() {
    	self.mode = "";
    	self.mediaType = "";
    }
    public int compareTo(Element x) {
        return 0;
    }
}
