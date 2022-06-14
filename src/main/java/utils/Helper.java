package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Helper {
    public static String getCurrentTime(String dateFormat) {
        return new SimpleDateFormat(dateFormat).format(new Date());
    }

}
