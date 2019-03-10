package bowling;

public class Scorer {
    private int ball;
    private int[] itsThrows=new int[21];
    private int itsCurrentThrow=0;
    public void addThrow(int pins){
        itsThrows[itsCurrentThrow++]=pins;
    }
    public int scoreForFrame(int theFrame) {
        ball=0;
        int score=0;
        for (int currentFrame=0;currentFrame<theFrame;currentFrame++){
            if (this.strick()){
                score+= 10 + nextTwoBallsForStrike();
                ball++;
            }else if (spare()){
                score+=10+ nextBallForSpare();
                ball+=2;
            }else {
                score+= towBallInFrame();
                ball+=2;
            }
        }
        return score;
    }
    private int nextTwoBallsForStrike() {
        return itsThrows[ball+1] + itsThrows[ball + 2];
    }

    private int towBallInFrame() {
        return itsThrows[ball]+itsThrows[ball+1];
    }

    private int nextBallForSpare() {
        return itsThrows[ball+2];
    }

    private boolean spare() {
        return (itsThrows[ball]+itsThrows[ball+1])== 10;
    }

    private boolean strick(){
        return this.itsThrows[ball]==10;
    }
}
