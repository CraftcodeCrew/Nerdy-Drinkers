package munich.nerdy.drinkers.io;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by leong on 15.05.2016.
 */
public class GameLog {

    private static final String LOGFILE = "log/gameLog.txt";

    public static void log(String message) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd 'at' HH:mm:ss ");
        Date currentTime = new Date();
        File log = new File("log");
        log.mkdir();
        try (PrintWriter logFileWriter = new PrintWriter(new FileWriter(LOGFILE, true))) {
            logFileWriter.print(formatter.format(currentTime) + ": ");
            logFileWriter.print(message);
            logFileWriter.println();
        } catch (IOException e) {
            System.out.println("Something went wrong while logging!");
        }
    }
}
