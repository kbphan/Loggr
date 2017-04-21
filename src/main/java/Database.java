import java.util.*;

public class Database {
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
        for (Element x : db) {
            if (x.getName().equals(elm)) {
                return db.remove(counter);
            }
            counter++;
        }
        return null;
    }

    public Element get(String elm)
    {
        for(Element e : db)
        {
            if(e.getName().equals(elm))
            {
                return e;
            }
        }
        return null;
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
