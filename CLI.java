import java.util.*;
public class CLI {
    CLI() {

    }

    public void run() {
        Database db = new Database();
        boolean running = true;
        try(Scanner in = new Scanner(System.in))
        {
            while (running) {
                System.out.print("Enter a command: ");
                String input = in.next();
                if(input.equals("exit") || input.equals("quit"))
                {
                    running = false;
                }
                else if (input.equals("add")) {
                    db.add(new MediaElement(in.next(), new Date(), new Date()));
                }
                else if (input.equals("remove")) {
                    db.remove(in.next());
                }
                else if (input.equals("details")) {
                    String info = db.get(in.next()).toString();
                    System.out.println(info);
                }
                else if (input.equals("show")) {
                    db.printAll();
                }
            }
        }
    }
}
