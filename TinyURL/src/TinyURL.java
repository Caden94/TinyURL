import java.util.HashMap;
import java.util.Map;

/**
 * Created by lujianyu on 5/29/17.
 */
public abstract class TinyURL {
    /**
     * fields
     */
    // map<longURL, shortURL>
    protected Map<String, String> longToShortMap;
    // map<shortURL, longURL>
    protected Map<String, String> shortToLongMap;

    /**
     * methods
     */
    // constructor
    public TinyURL() {
        this.longToShortMap = new HashMap<>();
        this.shortToLongMap = new HashMap<>();
    }

    // write
    public String write(String longURL) {
        // corner case
        if (longURL == null) {
            return null;
        }
        // to do
        if (longToShortMap.containsKey(longURL)) {
            return longToShortMap.get(longURL);
        }
        String shortURL = generateShortURL(longURL);
        longToShortMap.put(longURL, shortURL);
        shortToLongMap.put(shortURL, longURL);
        return shortURL;
    }

    // read
    public String read(String shortURL) {
        return shortToLongMap.get(shortURL);
    }

    // generateShortURL
    public abstract String generateShortURL(String longURL);
}
