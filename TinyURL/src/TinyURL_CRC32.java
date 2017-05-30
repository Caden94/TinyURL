import java.sql.Timestamp;
import java.util.Date;
import java.util.zip.CRC32;

/**
 * Created by lujianyu on 5/29/17.
 */
public class TinyURL_CRC32 extends TinyURL {
    @Override
    public String generateShortURL(String longURL) {
        String shortURL = null;
        if (longURL == null) {
            return null;
        }
        CRC32 crc32 = new CRC32();
        // avoid collision
        while (true) {
            Date date = new Date();
            Timestamp timestamp = new Timestamp(date.getTime());
            // generate hash code
            crc32.update((longURL + timestamp.toString()).getBytes());
            shortURL = Long.toHexString(crc32.getValue());
            if (!shortToLongMap.containsKey(shortURL)) {
                break;
            }
        }
        return shortURL;
    }
}
