/**
 * Created by lujianyu on 5/29/17.
 */
public class TinyURLFactory {
    public TinyURL getTinyURL(String TinyURLType) {
        if (TinyURLType == null) {
            return null;
        }
        switch (TinyURLType.toLowerCase()) {
            case "crc32":
                return new TinyURL_CRC32();
            case "base10":
                return new TinyURL_Base10();
            case "base62":
                return new TinyURL_Base62();
            default:
                return null;
        }
    }
}
