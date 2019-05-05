package transaction;

/**
 * @author cheyantao
 */
public class ServiceChargeTransaction extends Transaction{
    private int itsMemberId;
    private Date itsDate;
    private double itsCharge;

    public ServiceChargeTransaction(int itsMemberId, Date itsDate, double itsCharge) {
        this.itsMemberId = itsMemberId;
        this.itsDate = itsDate;
        this.itsCharge = itsCharge;
    }

    @Override
    public void execute() {
        Employee e=PayrollDatabase.GPayrollDatabase.getUnionMember(itsMemberId);
        Affiliation af=e.getAffiliation();
        UnionAffiliation uaf= (UnionAffiliation) af;
        uaf.AddServiceCharge(itsDate,itsCharge);
    }
}
