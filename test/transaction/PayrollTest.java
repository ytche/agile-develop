package transaction;

import org.junit.Test;

public class PayrollTest {
    @Test
    public void TestDeleteEmployee() {
        int empId = 3;
        AddCommissionedEmployee t = new AddCommissionedEmployee(empId, "Lance", "home", 1500, 3.2);
        t.execute();
        Employee e = PayrollDatabase.GPayrollDatabase.getEmployee(empId);
        assert e != null;
        DeleteEmployeeTransaction det = new DeleteEmployeeTransaction(empId);
        det.execute();
        e = PayrollDatabase.GPayrollDatabase.getEmployee(empId);
        assert e == null;
    }

    @Test
    public void testTimeCardTransaction() {
        int empId = 2;
        AddHourlyEmployee t = new AddHourlyEmployee(empId, "bill", "home", 15.25);
        t.execute();
        TimeCardTransaction tct = new TimeCardTransaction(new Date(10, 31, 2001), 8.0, empId);
        tct.execute();
        Employee e = PayrollDatabase.GPayrollDatabase.getEmployee(empId);
        assert e != null;
        PaymentClassification pc = e.getPaymentClassification();
        HourlyClassification hc = (HourlyClassification) pc;
        assert hc != null;
        TimeCard tc = hc.getTimeCard(new Date(10, 21, 2001));
        assert tc != null;
        assert (8.0 == tc.getHours());
    }

    @Test
    public void testSalesReceiptTransaction() {
        int empId = 3;
        AddCommissionedEmployee employee = new AddCommissionedEmployee(empId, "bob", "home", 1500.00, 100.00);
        employee.execute();
        SalesReceiptTransaction srt = new SalesReceiptTransaction(new Date(10, 31, 2001), 100.00, empId);
        srt.execute();
        Employee e=PayrollDatabase.GPayrollDatabase.getEmployee(empId);
        assert e!=null;
        CommissionedClassification cc= (CommissionedClassification) e.getPaymentClassification();
        assert  cc!=null;
        SalesReceipt salesReceipt=cc.getSalesReceipt();
        assert salesReceipt!=null;
        assert 100.00==salesReceipt.getAmount();

    }

    @Test
    public void testAddServiceCharge(){
        int empId=2;
        AddHourlyEmployee addHourlyEmployee=new AddHourlyEmployee(empId,"bill","home",15.25);
        addHourlyEmployee.execute();
        Employee e=PayrollDatabase.GPayrollDatabase.getEmployee(empId);
        assert e!=null;
        int memberId=86;
        UnionAffiliation af=new UnionAffiliation(memberId,12.5);
        e.setAffiliation(af);
        PayrollDatabase.GPayrollDatabase.addUnionMember(memberId,e);
        ServiceChargeTransaction sct=new ServiceChargeTransaction(memberId,new Date(11,01,2001),12.95);
        sct.execute();
        ServiceCharge sc=af.getServiceCharge();
        assert  sc!=null;
        assert sc.getAmount()==12.95;

    }

    @Test
    public void  testChagenNameTransaction(){
        int empId=2;
        AddHourlyEmployee t=new AddHourlyEmployee(empId,"bill","home",15.25);
        t.execute();
        ChangeNameTransaction cnt=new ChangeNameTransaction(empId,"bob");
        cnt.execute();
        Employee e=PayrollDatabase.GPayrollDatabase.getEmployee(empId);
        assert "bob".equals(e.getName());
    }
    @Test
    public void testChangeHourlyTransaction(){
        int empId=3;
        AddCommissionedEmployee t=new AddCommissionedEmployee(empId,"Lance","home",2500,3.2);
        t.execute();
        ChangeHourlyTransaction cht=new ChangeHourlyTransaction(empId,27.52);
        cht.execute();
        Employee e=PayrollDatabase.GPayrollDatabase.getEmployee(empId);
        assert  e!=null;
        PaymentClassification pc=e.getPaymentClassification();
        assert pc!=null;
        assert pc instanceof HourlyClassification;
        HourlyClassification hc= (HourlyClassification) pc;
        assert hc.getHourlyRate()==27.52;
        PaymentSchedule ps=e.getSchedule();
        assert ps instanceof WeeklySchedule;
    }

    @Test
    public void testChangeMemberTransaction(){
        int empId=2;
        int memberId=7734;
        AddHourlyEmployee t=new AddHourlyEmployee(empId,"Bill","Home",15.25);
        t.execute();
        ChangeMemberTransaction cmt =new ChangeMemberTransaction(empId,memberId,99.42);
        cmt.execute();
        Employee e=PayrollDatabase.GPayrollDatabase.getEmployee(empId);
        assert e!=null;
        Affiliation af=e.getAffiliation();
        assert  af!=null;
        assert af instanceof UnionAffiliation;
        UnionAffiliation uf= (UnionAffiliation) af;
        assert 99.42==uf.getDues();
        Employee member=PayrollDatabase.GPayrollDatabase.getUnionMember(memberId);
        assert member!=null;
        assert e.equals(member);
    }
    //todo 19.34
}
