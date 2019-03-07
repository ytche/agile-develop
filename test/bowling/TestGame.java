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
    public void testOneThrow(){
        g.add(5);
        assert 5==g.score();
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
    }
}
