package munich.nerdy.drinkers.plots;

/**
 * Created by cem on 14.05.16.
 */
public class TranslateSetting {

    private final String apiKey;

    public TranslateSetting(String secretKey) {
        this.apiKey = secretKey;
    }

    public String getApiKey() {
        return apiKey;
    }


}
