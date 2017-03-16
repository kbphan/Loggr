public class CLI {
    CLI() {

    }

    public void run() {
        Database db = new Database();
        boolean running = true;
        Scanner in = new Scanner(System.in);
        while (running) {
            String input = in.next();
            if (input.equals("add")) {
                db.add(new MediaElement(in.next(), new Date(), new Date()));
                db.printAll();
            }
            if (input.equals("show")) {

            }
        }
    }
}
