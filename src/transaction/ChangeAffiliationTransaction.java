package transaction;

public abstract class ChangeAffiliationTransaction extends ChangeEmployeeTransaction{
    public ChangeAffiliationTransaction(int empId) {
        super(empId);
    }
    public abstract Affiliation getAffiliation();
    public  abstract void  recordMemberShip(Employee e);

    @Override
    public void change(Employee employee) {
        recordMemberShip(employee);
        employee.setAffiliation(getAffiliation());
    }
}
