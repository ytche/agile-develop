package command.active.object;

import org.junit.Test;

public class TestSleepCommand {
    private boolean commandExecuted=false;
    @Test
    public void testSleep(){
        Command wakeup=new Command() {
            @Override
            public void execute() {
                commandExecuted=true;
            }
        };
        ActiveObjectEngine e=new ActiveObjectEngine();
        SleepCommand c=new SleepCommand(1000,e,wakeup);
        e.addCommand(c);
        long start=System.currentTimeMillis();
        e.run();
        long stop=System.currentTimeMillis();
        long sleepTime=(stop-start);
        assert sleepTime>1000:"SleepTime "+sleepTime +"expected>1000";
        assert sleepTime<1100:"SleepTIme "+sleepTime +"expected <1100";
        assert commandExecuted:"Command Executed";
    }


}
