package final_dz;

import java.util.HashSet;
import java.util.Set;

/**
 * Class for save the set with their amount
 */
public class Pair {

    private Set<Integer> set;
    private int second;

    public Pair(int x, int second) {
        this.set = new HashSet<>();
        this.set.add(x);
        this.second = second;
    }

    public Set<Integer> getSet() {
        return set;
    }

    public void add(int val) {
        this.set.add(val);
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public void addToSecond(int val) {
        this.second += val;
    }
}
