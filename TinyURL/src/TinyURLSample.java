//import java.sql.Timestamp;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.zip.CRC32;
//
///**
// * Created by lujianyu on 5/28/17.
// */
//public class TinyURLSample {
//    /**
//     * fields
//     */
//    // map<longURL, shortURL>
//    private Map<String, String> longToShortMap;
//    // map<shortURL, longURL>
//    private Map<String, String> shortToLongMap;
//
//    /**
//     * methods
//     */
//    // constructor
//    public TinyURLSample() {
//        this.longToShortMap = new HashMap<>();
//        this.shortToLongMap = new HashMap<>();
//    }
//
//    // write
//    public String write(String longURL) {
//        // corner case
//        if (longURL == null) {
//            return null;
//        }
//        // to do
//        if (longToShortMap.containsKey(longURL)) {
//            return longToShortMap.get(longURL);
//        }
//        String shortURL = generateShortURL(longURL);
//        longToShortMap.put(longURL, shortURL);
//        shortToLongMap.put(shortURL, longURL);
//        return shortURL;
//    }
//
//    // read
//    public String read(String shortURL) {
//        return shortToLongMap.get(shortURL);
//    }
//
//    // generateShortURL
//    private String generateShortURL(String longURL) {
//        String shortURL = null;
//        if (longURL == null) {
//            return null;
//        }
//        CRC32 crc32 = new CRC32();
//        // avoid collision
//        while (true) {
//            Date date = new Date();
//            Timestamp timestamp = new Timestamp(date.getTime());
//            // generate hash code
//            crc32.update((longURL + timestamp.toString()).getBytes());
//            shortURL = Long.toHexString(crc32.getValue());
//            if (!shortToLongMap.containsKey(shortURL)) {
//                break;
//            }
//        }
//        return shortURL;
//    }
//}
