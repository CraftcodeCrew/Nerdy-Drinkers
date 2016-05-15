package munich.nerdy.drinkers.utility;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class Utility {

    public static Properties readConfig() throws IOException {
        Properties properties = new Properties();
        String propName = "resources/config.properties";

        InputStream inputStream = Utility.class.getClassLoader().getResourceAsStream(propName);

        if (inputStream != null)
            properties.load(inputStream);
        else throw new FileNotFoundException("properties file " + propName + " not found in classpath");

        return properties;
    }

    public static String withNewLine(String original) {
        return original + System.lineSeparator();
    }

    public static String formatString(String story) {
        String withoutWhiteSpace = removeWitheSpace(story);
        String[] subStrings = withoutWhiteSpace.split(" ");
        StringBuffer buffer = new StringBuffer("       ");
        int count = 1;
        for (String string : subStrings) {
            if (count % 5 == 0) buffer.append(string).append(System.lineSeparator()).append("       ");
            else buffer.append(string).append(" ");
            count++;
        }
        return buffer.toString();

    }


    public static String removeWitheSpace(String text) {
        StringBuilder builder = new StringBuilder(text);
        for (int i = 1; i < text.length(); i++) {
            char now = text.charAt(i);
            char before = text.charAt(i - 1);

            if (before == ' ' && (now == '.' || now == ',')) builder.setCharAt(i - 1, Character.MIN_VALUE);
        }

        return builder.toString();
    }


}
