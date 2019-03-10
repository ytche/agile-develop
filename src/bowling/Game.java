package bowling;

/**
 * @author cheyantao
 */
public class Game {
    private int itsCurrentFrame=1;
    private boolean firstThrowInFrame =true;
    private Scorer itsScorer =new Scorer();


    public int score(){
        return this.scoreForFrame(itsCurrentFrame);
    }

    public void add(int pins){
        itsScorer.addThrow(pins);
        adJustCurrentFrame(pins);
    }

    private void adJustCurrentFrame(int pins) {
        if (this.firstThrowInFrame){
            if (lastBallInFrame(pins)) {
                advanceFrame();
            }else {
                firstThrowInFrame=false;
            }
        }else {
            this.firstThrowInFrame =true;
            this.advanceFrame();
        }

    }

    private boolean lastBallInFrame(int pins) {
        return strick(pins)||(!firstThrowInFrame);
    }

    private boolean strick(int pins) {
        return firstThrowInFrame&&pins==10;
    }

    private boolean adjustFrameForStrike(int pins) {
        if (pins==10){
            advanceFrame();
            return true;
        }
        return false;
    }

    public int scoreForFrame(int theFrame) {
        return itsScorer.scoreForFrame(theFrame);
    }
    private void advanceFrame(){
        itsCurrentFrame=Math.min(10,itsCurrentFrame+1);
    }
}
