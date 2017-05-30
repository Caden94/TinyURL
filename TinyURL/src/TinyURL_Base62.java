/**
 * Created by lujianyu on 5/29/17.
 */
public class TinyURL_Base62 extends TinyURL {
    public static final char[] encode = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    @Override
    public String generateShortURL(String longURL) {
        return convertTo62(shortToLongMap.size());
    }

    private String convertTo62(int size) {
        // '0' ~ '9', 'a' ~ 'z', 'A' ~ 'Z'
        String shortURL = "";
        while (size > 0) {
            shortURL = encode[size % 62] + shortURL;
            size /= 62;
        }
        return shortURL;
    }
}
