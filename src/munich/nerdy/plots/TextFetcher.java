package munich.nerdy.plots;

import com.memetix.mst.language.Language;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;


public class TextFetcher {

    public static final String PLOTSHORT_URL = "http://www.plotshot.com/index.php?shot-search=tags&shot-sort=relevance";

    public TextFetcher(TranslateSetting setting) {
        com.memetix.mst.translate.Translate.setClientId(setting.getClientID());
        com.memetix.mst.translate.Translate.setClientSecret(setting.getSecretKey());
    }

    public static String getShortPlot() throws IOException {
        Document document = Jsoup.connect(PLOTSHORT_URL).get();
        return document.body().getElementById("content").child(1).child(0).text();
    }

    public static String translate(String original) throws Exception {
        return com.memetix.mst.translate.Translate.execute(original, Language.ENGLISH, Language.GERMAN);
    }

}
