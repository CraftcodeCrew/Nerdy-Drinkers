package munich.nerdy.plots;

/**
 * Created by cem on 14.05.16.
 */
public class TranslateSetting {

    private final String secretKey;
    private final String clientID;

    public TranslateSetting(String secretKey, String clientID) {
        this.secretKey = secretKey;
        this.clientID = clientID;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public String getClientID() {
        return clientID;
    }
}
