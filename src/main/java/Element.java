import java.util.*;

public class Element implements Comparable<Element> {
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

    @Override
    public String toString()
    {
        String droppedStr = "no";
        if(dropped)
        {
            droppedStr = "yes";
        }
        String finishedStr = "no";
        if(finished)
        {
            finishedStr = "yes";
        }
        return "Name: \"" + this.name + "\", Type: " + this.type + ", Date started: " + this.dateStarted + ", Date last viewed: "
                + this.lastViewed + ", Dropped: " + droppedStr + ", Finished: " + finishedStr;
    }



    public int compareTo(Element x) {
        return 0;
    }

    /**
    * Returns value of name
    * @return the object's name
    */
    public String getName() {
        return name;
    }

    /**
	* Sets new value of name
	* @param new name
	*/
	public void setName(String name) {
		this.name = name;
	}

	/**
	* Returns value of type
	* @return the object's type
	*/
	public String getType() {
		return type;
	}

	/**
	* Sets new value of type
	* @param new type
	*/
	public void setType(String type) {
                if(type.equals("media") || type.equals("text"))
                {
                    this.type = type;
                }
	}

	/**
	* Returns value of lastViewed
	* @return the Date last viewed
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
