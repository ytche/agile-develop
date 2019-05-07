package transaction;

public class ChangeMemberTransaction extends ChangeAffiliationTransaction {
    int itsMemberId;
    double itsDues;
    public ChangeMemberTransaction(int empId,int memberId,double dues) {
        super(empId);
        this.itsMemberId=memberId;
        this.itsDues=dues;
    }


    @Override
    public Affiliation getAffiliation() {
        return new UnionAffiliation(itsMemberId,itsDues);
    }

    @Override
    public void recordMemberShip(Employee e) {
        PayrollDatabase.GPayrollDatabase.addUnionMember(itsMemberId,e);
    }
}
