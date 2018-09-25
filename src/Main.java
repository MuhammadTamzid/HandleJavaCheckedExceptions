import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    private static <T extends Exception> RuntimeException chuck(Exception e) throws T {
        throw (T) e;
    }

    private static <T extends Throwable> void chucks(Class<T> clazz) throws T {}

    public static Date convertStringToDate(String strDate, String dateFormat) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        simpleDateFormat.setLenient(false);
        try {
            return simpleDateFormat.parse(strDate);
        } catch (ParseException e) {
            throw chuck(new ParseException("ParseException", 0));
        }
    }

    public static Date convertStringToDate() {
        return convertStringToDate("2018-01-01 00:00:00", "XYZ");
    }

    public static void main(String[] args) {
        try {
            chucks(ParseException.class);
            convertStringToDate();
        } catch (ParseException e) {
            System.out.println("String Date format is not valid, cannot parse string to date!!");
        }
    }
}
