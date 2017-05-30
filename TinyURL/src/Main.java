public class Main {

    public static void main(String[] args) {
        // test crc32
        test("www.google.com/abc/", "crc32", 124);
        test("www.google.com/abc/", "base10", 124);
        test("www.google.com/abc/", "base62", 124);
    }

    public static void test(String longURL, String URLType, int times) {
        System.out.println("test: " + URLType);
        TinyURL tinyURL = new TinyURLFactory().getTinyURL(URLType);
        for (int i = 0; i < times; i++) {
            String new_longURL = longURL + i;
            System.out.print("longURL: " + new_longURL + " ");
            String shortURL = tinyURL.write(new_longURL);
            System.out.print("shortURL: " + shortURL + " ");
//        System.out.println("longURL: " + tinyURL.read(shortURL));
            System.out.println(tinyURL.read(shortURL).equals(new_longURL) ? "Pass" : "Fail");
        }
        System.out.println("-----------------------");
    }
}
