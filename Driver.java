//package loggr;
import java.util.*;
// import java.util.ArrayList;
// import java.util.Comparator;
// import java.util.List;
// import java.util.Collections;

public class Driver {
    public static void main(String[] args) {
        CLI ui = new CLI();
        ui.run();
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

    public boolean remove(Element elm) {
        return db.remove(elm);
    }

    public Element remove(String elm) {
        int counter = 0;
        int index = -1;
        for (Element x : db) {
            if (x.getName().equals(elm)) {
                index = counter;
            }
            counter++;
        }
        if (index > -1) {
            return db.remove(index);
        }
        else {
            return null;
        }
    }

    public void sortBy(String comparator) {

        if (comparator.equalsIgnoreCase("name")) {
            Collections.sort(db, new Comparator<Element>() {
                @Override
                public int compare(Element e1, Element e2) {
                    return e1.getName().compareToIgnoreCase(e2.getName());
                }
            });
        }

        else if (comparator.equalsIgnoreCase("type")) {
            Collections.sort(db, new Comparator<Element>() {
                @Override
                public int compare(Element e1, Element e2) {
                    return e1.getName().compareToIgnoreCase(e2.getName());
                }
            });
        }

        else if (comparator.equalsIgnoreCase("lastViewed")) {
            Collections.sort(db, new Comparator<Element>() {
                @Override
                public int compare(Element e1, Element e2) {
                    return e1.getLastViewed().compareTo(e2.getLastViewed());
                }
            });
        }

        else if (comparator.equalsIgnoreCase("dateStarted")) {
            Collections.sort(db, new Comparator<Element>() {
                @Override
                public int compare(Element e1, Element e2) {
                    return e1.getDateStarted().compareTo(e2.getDateStarted());
                }
            });
        }

        else if (comparator.equalsIgnoreCase("dateAdded")) {
            Collections.sort(db, new Comparator<Element>() {
                @Override
                public int compare(Element e1, Element e2) {
                    return e1.getDateAdded().compareTo(e2.getDateAdded());
                }
            });
        }

        else if (comparator.equalsIgnoreCase("finished")) {
            Collections.sort(db, new Comparator<Element>() {
                @Override
                public int compare(Element e1, Element e2) {
                    return (e1.isFinished() == e2.isFinished() ? 0 : (e2.isFinished() ? 1 : -1));
                }
            });
        }

        else if (comparator.equalsIgnoreCase("dropped")) {
            Collections.sort(db, new Comparator<Element>() {
                @Override
                public int compare(Element e1, Element e2) {
                    return (e1.isDropped() == e2.isDropped() ? 0 : (e2.isDropped() ? 1 : -1));
                }
            });
        }

        else {
            System.out.println("Invalid choice of sorting");
        }

    }

    public void printAll() {
        for (Element x : db) {
            System.out.println(x.getName());
        }
    }
}

class Element implements Comparable<Element> {
    private String type, name;
    private Date dateStarted, dateAdded, lastViewed;
    private boolean finished, dropped;

    public Element() {
        name = null;
        type = null;
        lastViewed = null;
        dateStarted = null;
        dateAdded = null;
        finished = false;
        dropped = false;
    }

    public Element(String name, Date lastViewed, Date dateStarted) {
        this.name = name;
        this.type = type;
        this.lastViewed = lastViewed;
        this.dateStarted = dateStarted;
        finished = false;
        dropped = false;
    }



    public int compareTo(Element x) {
        return 0;
    }

    /**
    * Returns value of name
    * @return
    */
    public String getName() {
        return name;
    }

    /**
	* Sets new value of name
	* @param
	*/
	public void setName(String name) {
		this.name = name;
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
	public Date getLastViewed() {
		return lastViewed;
	}

	/**
	* Sets new value of lastViewed
	* @param
	*/
	public void setLastViewed(Date lastViewed) {
		this.lastViewed = lastViewed;
	}

	/**
	* Returns value of dateStarted
	* @return
	*/
	public Date getDateStarted() {
		return dateStarted;
	}

	/**
	* Sets new value of dateStarted
	* @param
	*/
	public void setDateStarted(Date dateStarted) {
		this.dateStarted = dateStarted;
	}

	/**
	* Returns value of dateAdded
	* @return
	*/
	public Date getDateAdded() {
		return dateAdded;
	}

	/**
	* Sets new value of dateAdded
	* @param
	*/
	public void setDateAdded(Date dateAdded) {
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
