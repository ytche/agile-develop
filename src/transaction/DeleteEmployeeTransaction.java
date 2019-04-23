package transaction;

/**
 * 删除雇员操作
 */
public class DeleteEmployeeTransaction {
    private int empId;

    public DeleteEmployeeTransaction(int empId) {
        this.empId = empId;
    }
    public void execute(){
        PayrollDatabase.GPayrollDatabase.deleteEmployee(this.empId);
    }
}
