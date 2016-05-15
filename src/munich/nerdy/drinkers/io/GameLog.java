package munich.nerdy.drinkers.io;


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

    private static void log(String message) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd 'at' HH:mm:ss ");
        Date currentTime = new Date();
        try (PrintWriter logFileWriter = new PrintWriter(new FileWriter(LOGFILE, true))) {
            logFileWriter.println(formatter.format(currentTime) + ": ");
            logFileWriter.print(message);
        } catch (IOException e) {
            System.out.println("Something went wrong while logging!");
        }
    }
}
