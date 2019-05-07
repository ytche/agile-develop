package transaction;

/**
 * @author cheyantao
 */
public class ChangeUnaffiliatedTransaction extends ChangeAffiliationTransaction{
    public ChangeUnaffiliatedTransaction(int empId) {
        super(empId);
    }

    @Override
    public Affiliation getAffiliation() {
        return new NoAffiliation();
    }

    @Override
    public void recordMemberShip(Employee e) {
        Affiliation af=e.getAffiliation();
        if(af instanceof UnionAffiliation){
            int memberId=((UnionAffiliation)af).getMemberId();
            PayrollDatabase.GPayrollDatabase.removeUnionMember(memberId);
        }
    }
}
