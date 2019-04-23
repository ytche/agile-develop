package command.active.object;

import java.util.LinkedList;

/**
 * @author cheyantao
 */
public class ActiveObjectEngine {
    LinkedList itsCommand=new LinkedList();
    public void  addCommand(Command c){
        itsCommand.add(c);
    }
    public void  run(){
        while (!itsCommand.isEmpty()){
            Command c= (Command) itsCommand.getFirst();
            itsCommand.removeFirst();
            c.execute();
        }
    }
}
