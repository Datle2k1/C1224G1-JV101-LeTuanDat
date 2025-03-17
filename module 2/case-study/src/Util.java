import java.util.Arrays;

public class Util {

    public static boolean isInvalidName(String name) {
        return name.isEmpty() || !name.matches("^[A-Za-z\\s]+$");
    }

    public static boolean isInvalidPhone(String phone) {
        return phone.isEmpty() || !phone.matches("^0[0-9\\s]{8,11}$");
    }

    public static boolean isValidEmail(String email) {
        return email.matches("^[A-Za-z]+[A-Za-z0-9]*@gmail.com$");
    }

    public static boolean isValidGender(String gender) {
        String[] arr = new String[]{"Male", "Female", "Other"};
        return Arrays.asList(arr).contains(gender);
    }

    public static boolean isValidBirthday(String birth) {
        String[] arr = birth.split("/");
        if (isNotNumber(arr[0]) || isNotNumber(arr[1]) || isNotNumber(arr[2]))
            return false;

        int day = Integer.parseInt(arr[0]);
        int month = Integer.parseInt(arr[1]);
        int year = Integer.parseInt(arr[2]);

        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (day < 1 || day > 31) return false;
                else break;
            case 4:
            case 6:
            case 9:
            case 11:
                if (day < 1 || day > 30) return false;
                else break;
            case 2:
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                    if (day < 1 || day > 29) return false;
                } else {
                    if (day < 1 || day > 28) return false;
                }
                break;
            default:
                return false;
        }

        return true;
    }

    public static String format(String birth) {
        String[] arr;

        if (birth.isEmpty()) return "";
        else arr = birth.split("/");

        String day = arr[0].length() == 2 ? arr[0] : "0" + arr[0];
        String month = arr[1].length() == 2 ? arr[1] : "0" + arr[1];
        String year = arr[2].length() == 4 ? arr[2] : "0" + arr[2];

        return day + "/" + month + "/" + year;
    }

    public static boolean isNotNumber(String data) {
        return !data.matches("^[0-9]+$");
    }
}
