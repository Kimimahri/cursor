package helpers;

import java.util.Random;


public class Helper {

    private static final String characters =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";

    public static String getRandomString(Integer len) {
        Random random = new Random();
        char[] text = new char[len];
        for (int i = 0; i < len; i++) {
            text[i] = characters.charAt(random.nextInt(characters.length()));
        }
        return new String(text);
    }
}