package bowling;

import org.junit.Test;

/**
 * 测试Frame
 * @author cheyantao
 */
public class TestFrame {

    @Test
    public void testScoreNoThrow(){
        Frame frame=new Frame();
        assert frame.getScore()==0;
    }

    @Test
    public void testAddOneThrow(){
        Frame frame=new Frame();
        frame.add(5);
        assert frame.getScore()==5;
    }
}
