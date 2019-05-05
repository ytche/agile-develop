package transaction;

/**
 * @author cheyantao
 */
public abstract class ChangeEmployeeTransaction extends Transaction{
    private int empId;

    public ChangeEmployeeTransaction(int empId) {
        this.empId = empId;
    }
    @Override
    public void execute() {
        Employee e=PayrollDatabase.GPayrollDatabase.getEmployee(empId);
        if (e!=null){
            this.change(e);
        }
    }
    public abstract void change(Employee employee);

}
