package transaction;

public class UnionAffiliation implements Affiliation{
    private double amount;
    private int memberId;
    private  ServiceCharge serviceCharge;

    public UnionAffiliation( int memberId,double amount) {
        this.amount = amount;
        this.memberId = memberId;
    }

    public void AddServiceCharge(Date itsDate, double itsCharge) {
        this.serviceCharge=new ServiceCharge(itsCharge,itsDate);
    }

    public ServiceCharge getServiceCharge() {
        return serviceCharge;
    }
}
