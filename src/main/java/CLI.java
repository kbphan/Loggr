import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


import java.io.IOException;
import java.util.*;
public class CLI {

    public static void main(String[] args) {
        CLI cli = new CLI();
        cli.run();
    }

    public void run() {
        Database db = new Database();
        MediaElement test1 = new MediaElement("Harry Potter and the Sorcerer's Stone", new Date(), new Date());
        boolean running = true;
        try(Scanner in = new Scanner(System.in)) {
            while (running) {
                System.out.print("Enter a command: ");
                String input = in.next();
                if(input.equals("exit") || input.equals("quit"))
                {
                    running = false;
                }
                else if (input.equals("add")) {
                    input = in.next();
                    if (input.equals("media")) {
                        db.add(new MediaElement(in.nextLine().trim(), new Date(), new Date()));
                    }
                    else if (input.equals("text")) {
                        db.add(new TextElement(in.nextLine().trim(), new Date(), new Date()));
                    }
                }
                else if (input.equals("remove")) {
                    db.remove(in.nextLine());
                }
                else if (input.equals("show")) {
                    db.printAll();
                }
                else if (input.equals("get")) {
                    System.out.println(db.get(in.nextLine().trim()).toString());
                }
                else {
                    System.out.println("Invalid command, please try again");
                }
            }
        }
    }
}
