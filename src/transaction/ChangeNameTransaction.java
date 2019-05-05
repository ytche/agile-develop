package transaction;

/**
 * @author cheyantao
 */
public class ChangeNameTransaction extends ChangeEmployeeTransaction {
    private String name;
    public ChangeNameTransaction(int empId, String bob) {
        super(empId);
        this.name=name;
    }

    @Override
    public void change(Employee employee) {
        employee.setName(this.name);
    }
}
