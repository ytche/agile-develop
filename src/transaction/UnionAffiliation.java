package transaction;

public class UnionAffiliation implements Affiliation{
    private double dues;
    private int memberId;
    private  ServiceCharge serviceCharge;

    public UnionAffiliation( int memberId,double dues) {
        this.dues = dues;
        this.memberId = memberId;
    }

    public void AddServiceCharge(Date itsDate, double itsCharge) {
        this.serviceCharge=new ServiceCharge(itsCharge,itsDate);
    }

    public ServiceCharge getServiceCharge() {
        return serviceCharge;
    }

    public double getDues() {
        return this.dues;
    }

    public int getMemberId() {
        return memberId;
    }
}
