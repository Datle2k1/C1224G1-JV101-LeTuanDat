import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final String regex = "^[CAP][0-9]{4}[GHIK]$";
    private static final String[] valid = {"C0223G", "A0323K"};
    private static final String[] inValid = {"M0318G","P0323A"};

    public static boolean isValid(String str) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher =   pattern.matcher(str);
        return matcher.matches();
    }

    public static void main(String[] args) {
        for (String str: valid) System.out.println(str + " : " + isValid(str));
        for (String str: inValid) System.out.println(str + " : " + isValid(str));
    }
}