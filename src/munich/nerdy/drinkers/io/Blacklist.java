package munich.nerdy.drinkers.io;

import java.io.*;

/**
 * Created by leong on 14.05.2016.
 */
public class Blacklist {
    private static final String BLACKLIST_FILE = "blacklist/blacklist.txt";

    public static boolean addWordToBlacklist(String blacklistWord) {
        File blacklist = new File("blacklist");
        blacklist.mkdir();
        try(PrintWriter blacklistFileWriter = new PrintWriter(new FileWriter(BLACKLIST_FILE,true))) {
            blacklistFileWriter.println(blacklistWord);
            blacklistFileWriter.close();
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
            return false;
        }
        return true;
    }

    public static String getBlacklist() {
        try(BufferedReader br = new BufferedReader(new FileReader(BLACKLIST_FILE))) {
            StringBuilder blacklist = new StringBuilder();
            while (br.ready()) {
                blacklist.append(", ");
                blacklist.append(br.readLine());
            }
            br.close();
            return blacklist.toString();
        }
        catch (IOException ioe) {
            return "Die Blacklist ist leer.";
        }
    }

    public static boolean clearBlacklist(){
        try {
            File blacklist = new File(BLACKLIST_FILE);
            blacklist.delete();
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }
}
