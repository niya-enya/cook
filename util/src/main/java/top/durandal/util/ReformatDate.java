package top.durandal.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author bianca-durandal-attagina
 */
public class ReformatDate {

    public static String getDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(new Date());
    }
}
