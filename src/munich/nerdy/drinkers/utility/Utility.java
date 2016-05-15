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

}
