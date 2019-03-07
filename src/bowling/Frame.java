package bowling;

/**
 * @author cheyantao
 */
public class Frame {

    private  int itsScore=0;
    public int getScore() {
        return itsScore;
    }

    public void add(int pins) {
        this.itsScore+=pins;
    }
}
