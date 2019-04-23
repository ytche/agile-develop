package transaction;

/**
 * 时间卡处理类
 *
 * @author cheyantao
 */
public class TimeCardTransaction extends Transaction {
    private int itsEmpid;
    private Date itsDate;
    private double itHours;

    public TimeCardTransaction(Date date, double hours, int empId) {
        this.itsEmpid = empId;
        this.itsDate = date;
        this.itHours = hours;
    }

    @Override
    public void execute() {
        Employee e = PayrollDatabase.GPayrollDatabase.getEmployee(itsEmpid);
        if (e != null) {
            PaymentClassification pc = e.getPaymentClassification();
            if (pc instanceof HourlyClassification) {
               HourlyClassification hc= (HourlyClassification) pc;
               hc.addTimeCard(new TimeCard(itsDate,itHours));
            }else {
                throw new RuntimeException("Tried to add timeCard to non-hourly employee");
            }
        }else {
            throw new RuntimeException("NO such employee");
        }
    }
}
