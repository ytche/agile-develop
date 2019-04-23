package command.active.object;

/**
 * @author cheyantao
 */
public class SleepCommand implements Command{
    private Command wakeupCommand=null;
    private ActiveObjectEngine engine=null;
    private long sleepTime=0L;
    private long startTime=0;
    private boolean started=false;

    public SleepCommand(long milliseconds,ActiveObjectEngine e,Command wakeupCommand){
        this.sleepTime=milliseconds;
        this.engine=e;
        this.wakeupCommand=wakeupCommand;
    }

    @Override
    public void execute() {
        long currentTime=System.currentTimeMillis();
        if (!started){
            started=true;
            startTime=currentTime;
            engine.addCommand(this);
        }else if((currentTime-startTime)<sleepTime){
            engine.addCommand(this);
        }else {
            engine.addCommand(wakeupCommand);
        }
    }
}
