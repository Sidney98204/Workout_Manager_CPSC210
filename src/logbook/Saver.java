package logbook;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Saver {
    private Logbook logbook;

    public Saver(Logbook logbook) {
        this.logbook = logbook;
    }

    // EFFECTS: saves inputted information into a file
    public void save() throws IOException {

        // THIS METHOD IS HEAVILY DEPENDENT ON RETURNSTRINGLIST, LOAD, W.RETURNSTRING() AND OTHERS (?)

        List<String> lines = logbook.returnStringList();
        PrintWriter writer = new PrintWriter("savefile.text", "UTF-8");
        for (String line: lines) {
            writer.println(line);
        }
        writer.close();

    }

    // EFFECTS: splits up given string by its spaces
    public static ArrayList<String> splitOnSpace(String line) {
        String[] splits = line.split(" ");
        return new ArrayList<>(Arrays.asList(splits));
    }
}
