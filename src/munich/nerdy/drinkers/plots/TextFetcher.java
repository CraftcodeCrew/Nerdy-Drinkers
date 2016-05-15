package munich.nerdy.drinkers.plots;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;


public class TextFetcher {

    public static final String PLOTSHORT_URL = "http://www.plotshot.com/index.php?shot-search=tags&shot-sort=relevance";

    public TextFetcher(TranslateSetting setting) {
        YanexTranslate.Instance(setting.getApiKey());

    }

    public  String getShortPlot() throws IOException {
        Document document = Jsoup.connect(PLOTSHORT_URL).get();
        return document.body().getElementById("content").child(1).child(0).text();
    }

    public  String translate(String original) throws Exception {
        return YanexTranslate.translate(original, Language.ENGLISH, Language.GERMAN);
    }

    public String getGermanPlot() throws Exception {
        return translate(getShortPlot());
    }
}
