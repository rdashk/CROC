package dz_5;

public class CharThread extends Thread{

    // input line
    private String INPUT_STRING;
    // input template
    private String TEMPLATE;

    // calculating entering template to input line
    private static int cou = 0;

    /**
     * @param input_string input line
     * @param template input template
     */
    public CharThread(String input_string, String template) {
        this.INPUT_STRING = input_string;
        this.TEMPLATE = template;
    }

    // for correct work
    private static final Object lock = new Object();

    @Override
    public void run() {

        for (int i = 0; i < this.INPUT_STRING.length(); i++) {
            // search for a template in a input line
            if (Matcher.match(String.valueOf(INPUT_STRING.charAt(i)), TEMPLATE)) {
                synchronized (lock) {
                    cou++;
                }
            }
        }
    }

    /**
     * @return amount templates in input line
     */
    public static int getCou() {
        return cou;
    }
}
