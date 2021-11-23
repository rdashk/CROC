package dz_5;

import java.util.ArrayList;
import java.util.List;

/**
 * Стартовый класс.
 */
public class Main {

    /**
     * Пример входной строки.
     */
    public static final String INPUT_STRING = "Невежество есть мать промышленности, как и суеверий." +
            " Сила размышления и воображения подвержена ошибкам; но привычка двигать рукой или ногой" +
            " не зависит ни от того, ни от другого. Поэтому мануфактуры лучше всего процветают там, где" +
            " наиболее подавлена духовная жизнь, так что мастерская может рассматриваться как машина," +
            " части которой составляют люди.";

    /**
     * Шаблон поиска символов в строке.
     */
    public static final String TEMPLATE = " ";

    /**
     * Amount of threads
     */
    public static final int AMOUNT_THREADS = 15;
    /**
     * Точка входа в приложение.
     *
     * @param args аргументы командной строки.
     */
    public static void main(String[] args) throws InterruptedException {

        long current = System.currentTimeMillis();

        // list of threads
        List<Thread> threads = new ArrayList<Thread>();

        // calculating length of string's part
        int len_part = INPUT_STRING.length()/AMOUNT_THREADS;

        // amount of ready threads
        int ready_threads = 0;

        // add new thread to list (dividing input line)
        for(int i=0;i<INPUT_STRING.length();i+=len_part){

            ready_threads++;

            // if it is the last thread
            if (ready_threads == AMOUNT_THREADS) {
                threads.add(new CharThread(INPUT_STRING.substring(i), TEMPLATE));
                break;
            }
            else {
                threads.add(new CharThread(INPUT_STRING.substring(i, i+len_part), TEMPLATE));
            }
        }

        // start all threads
        for (Thread thread: threads) {
            thread.start();
        }

        // start one after the other
        for (Thread thread: threads) {
            thread.join();
        }

        System.out.println("Count of " + TEMPLATE + ": " + CharThread.getCou());

        System.out.println("Time: " + (System.currentTimeMillis() - current) / 1000 + " c.");
    }
}
