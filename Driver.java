package loggr;
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
    private String type;
    private int lastViewed, dateStarted, dateAdded;
    private boolean finished, dropped;

    public Element() {
        type = null;
        lastViewed = -1;
        dateStarted = -1;
        dateAdded = -1;
        finished = false;
        dropped = false;
    }

    public Element(String type, int lastViewed, int dateStarted) {
        type = type;
        lastViewed = lastViewed;
        dateStarted = dateStarted;
        finished = false;
        dropped = false;
    }

    public int compareTo(Element x) {
        return 0;
    }

	/**
	* Returns value of type
	* @return
	*/
	public String getType() {
		return type;
	}

	/**
	* Sets new value of type
	* @param
	*/
	public void setType(String type) {
		this.type = type;
	}

	/**
	* Returns value of lastViewed
	* @return
	*/
	public int getLastViewed() {
		return lastViewed;
	}

	/**
	* Sets new value of lastViewed
	* @param
	*/
	public void setLastViewed(int lastViewed) {
		this.lastViewed = lastViewed;
	}

	/**
	* Returns value of dateStarted
	* @return
	*/
	public int getDateStarted() {
		return dateStarted;
	}

	/**
	* Sets new value of dateStarted
	* @param
	*/
	public void setDateStarted(int dateStarted) {
		this.dateStarted = dateStarted;
	}

	/**
	* Returns value of dateAdded
	* @return
	*/
	public int getDateAdded() {
		return dateAdded;
	}

	/**
	* Sets new value of dateAdded
	* @param
	*/
	public void setDateAdded(int dateAdded) {
		this.dateAdded = dateAdded;
	}

	/**
	* Returns value of finished
	* @return
	*/
	public boolean isFinished() {
		return finished;
	}

	/**
	* Sets new value of finished
	* @param
	*/
	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	/**
	* Returns value of dropped
	* @return
	*/
	public boolean isDropped() {
		return dropped;
	}

	/**
	* Sets new value of dropped
	* @param
	*/
	public void setDropped(boolean dropped) {
		this.dropped = dropped;
	}
}
