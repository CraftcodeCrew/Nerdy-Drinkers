package munich.nerdy.drinkers.plots;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;


public class YanexTranslate {
    private final static String REQ_BASE_URL = "https://translate.yandex.net/api/v1.5/tr.json/translate?";
    private final static String REQ_CONNECTOR = "&";
    private final static String REQ_TEXT = "text=";
    private final static String REQ_LANGUAGE = "lang=";
    private static String PERSONAL_API = "empty";

    public static void Instance(String key) {
        PERSONAL_API = key;
    }

    private static String REQ_API_KEY() {
        return "key=" + PERSONAL_API;
    }

    public static String translate(String original, Language from, Language to) throws IOException {
        URL obj = new URL(buildURL(original, from, to));
        //----------------------------------------------------------------------------
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();


        //----------------------------------------------------------------------------
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(response.toString(), JsonObject.class);


        return jsonObject.get("text").getAsString();
    }


    private static String buildURL(String original, Language from, Language to) {
        StringBuffer buffer = new StringBuffer(REQ_BASE_URL);
        buffer.append(REQ_API_KEY()).append(REQ_CONNECTOR)
                .append(REQ_TEXT).append(URLEncoder.encode(original)).append(REQ_CONNECTOR)
                .append(REQ_LANGUAGE).append(from).append("-").append(to);


        return buffer.toString();
    }


}
