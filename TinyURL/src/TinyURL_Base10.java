/**
 * Created by lujianyu on 5/29/17.
 */
public class TinyURL_Base10 extends TinyURL {
    @Override
    public String generateShortURL(String longURL) {
        return String.valueOf(shortToLongMap.size());
    }
}
