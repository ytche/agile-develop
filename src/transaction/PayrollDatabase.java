package transaction;

import java.util.HashMap;
import java.util.Map;

/**
 * 数据库访问
 *
 * @author cheyantao
 */
public class PayrollDatabase {
    public static PayrollDatabase GPayrollDatabase=new PayrollDatabase();
    private static Map<Integer, Employee> itsEmployees=new HashMap<>();

    public  Employee getEmployee(int empId) {
        return itsEmployees.get(empId);
    }

    public  void addEmployee(int empid, Employee e){
        itsEmployees.put(empid,e);
    }
    public void clear(){
        itsEmployees.clear();
    }

    public void deleteEmployee(int empId) {
        itsEmployees.remove(empId);
    }
}
