package be.mosterd.metrum.model;

/**
 * Created by jonas on 9/10/2017.
 */

public class TimeSignature {

    private int upper;
    private int lower;

    public TimeSignature(int upper, int lower) {
        setUpper(upper);
        setLower(lower);
    }

    public int getUpper(){
        return upper;
    }

    public int getLower() {
        return lower;
    }

    public void setLower(int lower) {
        this.lower = lower;
    }

    public void setUpper(int upper) {
        this.upper = upper;
    }


}
