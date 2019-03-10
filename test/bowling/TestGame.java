package bowling;

import org.junit.Before;
import org.junit.Test;

public class TestGame {

    private Game g;

    @Before
    public void  setUp(){
        g=new Game();
    }

    @Test
    public void testTwoThrowNoMark(){
        g.add(5);
        g.add(4);
        assert 9==g.score();
    }
    @Test
    public void testFourThrowNoMark(){
        g.add(5);
        g.add(4);
        g.add(7);
        g.add(2);
        assert  18==g.score();
        assert  9==g.scoreForFrame(1);
        assert 18==g.scoreForFrame(2);
    }
    @Test
    public void testSimpleSpare(){
        g.add(3);
        g.add(7);
        g.add(3);
        assert 13==g.scoreForFrame(1);
    }
    @Test
    public void testSimpleFrameAfterSpare(){
        g.add(3);
        g.add(7);
        g.add(3);
        g.add(2);
        assert 13==g.scoreForFrame(1);
        assert  18==g.scoreForFrame(2);
        assert 18==g.score();
    }
    @Test
    public void test(){
        g.add(10);
        g.add(3);
        g.add(6);
        assert 19==g.scoreForFrame(1);
        assert 28==g.scoreForFrame(2);
        assert 28==g.score();
    }
    @Test
    public void testPerfectGame(){
        for (int i=0;i<12;i++){
            g.add(10);
        }
        assert 300==g.score();
    }
    @Test
    public void testEndOfArray(){
        for (int i=0;i<9;i++){
            g.add(0);
            g.add(0);
        }
        g.add(2);
        g.add(8);
        g.add(10);
        assert 20==g.score();
    }
    @Test
    public void testSimpleGame(){
        g.add(1);
        g.add(4);
        g.add(4);
        g.add(5);
        g.add(6);
        g.add(4);
        g.add(5);
        g.add(5);
        g.add(10);
        g.add(0);
        g.add(1);
        g.add(7);
        g.add(3);
        g.add(6);g.add(4);g.add(10);g.add(2);g.add(8);g.add(6);
        assert 133==g.score();
    }
    @Test
    public void testHeartBreak(){
        for (int i=0;i<11;i++){
            g.add(10);
        }
        g.add(9);
        assert 299==g.score();
    }
    @Test
    public void testTenthFrameSpare(){
        for (int i=0;i<9;i++){
            g.add(10);
        }
        g.add(9);
        g.add(1);
        g.add(1);
        assert 270==g.score();
    }
}
