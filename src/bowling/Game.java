package bowling;

/**
 * @author cheyantao
 */
public class Game {
    private int insScore=0;
    private  int[] itsThrows= new int[21];
    private int itsCurrentThrow=0;
    public int score(){
        return insScore;
    }
    public void add(int pins){
        itsThrows[itsCurrentThrow++]=pins;
        this.insScore+=pins;
    }
//    被重构的第一版
//    public int scoreForFrame(int frame) {
//        int score=0;
//        for (int ball=0;frame>0&&(ball<itsCurrentThrow);ball+=2,frame--){
//            score += itsThrows[ball]+itsThrows[ball+1];
//        }
//        return score;
//    }

    public int scoreForFrame(int theFrame) {
        int ball=0;
        int score=0;
        for (int currentFrame=0;currentFrame<theFrame;currentFrame++){
            //  score+=itsThrows[ball++]+itsThrows[ball++];
            int firstThrow=itsThrows[ball++];
            int secondThrow=itsThrows[ball++];
            int frameScore=firstThrow+secondThrow;
            if (frameScore==10){
                score+=frameScore+itsThrows[ball];
            }else {
                score+=frameScore;
            }
        }
        return score;
    }
}
