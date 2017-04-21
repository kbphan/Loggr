import java.util.*;
import java.net.*;
import java.io.*;


public class Driver {
    public static void main(String[] args) {
        LoggrGUI gui = new LoggrGUI();
        gui.launch();
        CLI ui = new CLI();
        ui.run();
    }
}
