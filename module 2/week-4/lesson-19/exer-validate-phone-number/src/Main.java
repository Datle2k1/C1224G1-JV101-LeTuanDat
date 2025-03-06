import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final String regex = "^\\([0-9]{2}\\)-\\(0[0-9]{9}\\)$";
    private static final String[] valid = {"(84)-(0978489648)"};
    private static final String[] inValid = {"(a8)-(22222222)", "(84)-(22b22222)", "(84)-(9978489648)"};

    public static boolean isValidPhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    public static void main(String[] args) {
        for (String phone: valid) System.out.println(phone + " : " + isValidPhoneNumber(phone));
        for (String phone: inValid) System.out.println(phone + " : " + isValidPhoneNumber(phone));
    }
}