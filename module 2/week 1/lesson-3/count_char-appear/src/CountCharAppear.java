public class CountCharAppear {
    public static void main(String[] args) {
        String str = "hello every one, hello";
        char value = 'l';
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == value) {
                count ++;
            }
        }

        System.out.print("Count " + value + " appear in" + str + " is " + count);
    }
}
