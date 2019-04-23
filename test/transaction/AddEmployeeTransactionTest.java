package transaction;

import org.junit.Test;

public class AddEmployeeTransactionTest {

    @Test
    public void payRollSalariedTest() {
        int empId = 1;
        AddSalariedEmployee t = new AddSalariedEmployee(empId, "Bob", "Home", 1000.00);
        t.execute();

        Employee e = PayrollDatabase.GPayrollDatabase.getEmployee(empId);
        assert "Bob".equals(e.getName());
        PaymentClassification pc = e.getPaymentClassification();
        SalariedClassification sc = (SalariedClassification) pc;
        assert sc != null;

        assert 1000.00 == sc.getSalary();

        PaymentSchedule ps = e.getSchedule();
        MonthlySchedule ms = (MonthlySchedule) ps;
        assert ms != null;

        PaymentMethod pm = e.getMethod();
        HoldMethod hm = (HoldMethod) pm;
        assert hm != null;
    }

    @Test
    public void payRollHourlyTest() {
        int hourlyEmpId = 2;
        AddHourlyEmployee ahe = new AddHourlyEmployee(hourlyEmpId, "ytche", "home", 100.00);
        ahe.execute();

        Employee hourlyEmployee = PayrollDatabase.GPayrollDatabase.getEmployee(hourlyEmpId);
        assert "ytche".equals(hourlyEmployee.getName());
        HourlyClassification hpc = (HourlyClassification) ahe.getClassification();
        assert hpc != null : "hpc is null";

        assert 100.00 == hpc.getHourlyRate() : "hourlyRate wrong";

        WeeklySchedule weeklySchedule = (WeeklySchedule) hourlyEmployee.getSchedule();
        assert weeklySchedule != null : "weekSchedule is null";

        HoldMethod hm = (HoldMethod) hourlyEmployee.getMethod();
        assert hm != null : "paymentMethod is null";
    }

    @Test
    public void payRollCommissionedTest() {
        int commissionedEmpId = 3;
        AddCommissionedEmployee ace = new AddCommissionedEmployee(commissionedEmpId, "jy", "home", 500.00, 500.00);
        ace.execute();

        Employee biweeklyEmployee=PayrollDatabase.GPayrollDatabase.getEmployee(commissionedEmpId);
        assert "jy".equals(biweeklyEmployee.getName());

        BiWeeklySchedule bc= (BiWeeklySchedule) ace.getSchedule();
        assert bc!=null:"biWeeklySchedule is null";

        CommissionedClassification cc= (CommissionedClassification) biweeklyEmployee.getPaymentClassification();
        assert 1000.00==cc.getCommissionRate()+cc.getSalary():"salary wrong";

        HoldMethod holdMethod= (HoldMethod) biweeklyEmployee.getMethod();
        assert  holdMethod!=null:"paymentMethod is null";

    }
}
