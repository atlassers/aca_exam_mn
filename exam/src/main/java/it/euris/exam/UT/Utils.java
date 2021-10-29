package it.euris.exam.UT;

import java.time.LocalDate;

public class Utils {

    public static LocalDate getLocalDate(String date){
        if (date==null){
            return null;
        }
        return LocalDate.parse(date);
    }

    public static Double getDouble(String num){
        if (num==null){
            return null;
        }
        return Double.parseDouble(num);
    }

    public static Integer getInteger(String num){
        if (num==null){
            return null;
        }
        return Integer.parseInt(num);
    }

    public static Long getLong(String num){
        if (num==null){
            return null;
        }
        return Long.parseLong(num);
    }


}
