package transaction;

import java.beans.Transient;

/**
 * 增加雇员
 * @author cheyantao
 */
public abstract class AddEmployeeTransaction extends Transaction{
    private Integer itsEmpid;
    private String itsName;
    private String itsAddress;
    public AddEmployeeTransaction(int empId, String name, String address) {
        this.itsAddress=address;
        this.itsEmpid=empId;
        this.itsName=name;
    }

    @Override
    public void execute() {
        PaymentClassification pc=getClassification();
        PaymentSchedule ps=getSchedule();
        PaymentMethod pm=new HoldMethod();
        Employee e=new Employee(itsEmpid,itsName,itsAddress);
        e.setClassification(pc);
        e.setSchedule(ps);
        e.setMethod(pm);
        PayrollDatabase.GPayrollDatabase.addEmployee(itsEmpid,e);
    }
    public abstract PaymentClassification getClassification();
    public abstract PaymentSchedule getSchedule();
}
