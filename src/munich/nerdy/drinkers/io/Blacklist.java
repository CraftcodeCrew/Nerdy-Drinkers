package munich.nerdy.drinkers.io;

import java.io.*;

/**
 * Created by leong on 14.05.2016.
 */
public class Blacklist {
    private final String BLACKLIST_FILE = "blacklist/blacklist.txt";
    private String blacklistWord;

    public Blacklist() {
    }

    public Blacklist(String blacklistWord) {
        this.blacklistWord = blacklistWord;
    }

    public boolean addWordToBlacklist(String blacklistWord) {
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

    public String getBlacklist() {
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
            return "could not read File!";
        }

    }

    public String getBlacklistWord() {
        return blacklistWord;
    }

    public void setBlacklistWord(String blacklistWord) {
        this.blacklistWord = blacklistWord;
    }


    public static void main(String[] args) {
        Blacklist blacklist = new Blacklist();
        System.out.println(blacklist.addWordToBlacklist("aqfqa"));
        System.out.println(blacklist.getBlacklist());
    }
}