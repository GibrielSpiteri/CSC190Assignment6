package emp;

import com.google.gson.Gson;
import emp.model.Emp;
import emp.model.EmpList;
import emp.model.Schedule;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.net.URLEncoder;
import java.util.Base64;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author csc190
 */
public class Client {
    
    
    protected static EmpList buildEmpList(){
        // Create Schedules
        String[] DrE = {"M", "W", "F"};
        int[] DrE2 = {9, 10, 11, 12, 19, 20}; 
        String[] MM = {"T", "W", "F"};
        int[] MM2 = {9, 10, 12, 14, 15, 16, 17, 18};
        String[] NT = {"M", "F"};
        int[] NT2 = {12, 13, 14, 15, 16, 17, 18};
        String[] AP = {"T", "R"};
        int[] AP2 = {8, 9, 10, 11, 12, 13, 14};
        Schedule[] arrSchedule = new Schedule[]{
            new Schedule(DrE, DrE2),
            new Schedule(MM, MM2),
            new Schedule(NT, NT2),
            new Schedule(AP, AP2)
        };
        
        // Create Skills
        String[] evilSkill = {"Butcher", "Saucier", "Baker"};
        String[] miniSkill = {"Saucier", "Baker"};
        String[] twoSkill = {"Butcher", "Dishwasher"};
        String[] powerSkill = {"Baker", "Saucier"};
        
        //Create Employees
        Emp[] arrEmps = {
            new Emp(101, "Dr. Evil", evilSkill, arrSchedule[0]),
            new Emp(102, "Mini Me", miniSkill, arrSchedule[1]),
            new Emp(103, "Number Two", twoSkill, arrSchedule[2]),
            new Emp(104, "Austin Powers", powerSkill, arrSchedule[3])
        };
        EmpList emplist = new EmpList(arrEmps);
        return emplist;
    }

    public static void main(String[] args) throws Exception {
        String op = args[0];
 //       System.out.print(args[0]+ " "+args[1]+ " "+args[2] +" "+args[3]);
        //System.out.println(op);
        EmpList emps = buildEmpList();
        String url = "http://localhost/datasel.php";
        String empContent = Utils.toStr(emps);
        //System.out.println(empContent);
        String datastr;
        if (op.equals("1")){
            //System.out.println("here1");
            datastr = "op=uploadEmps&emplist=" + empContent;
        } else {
            //System.out.println("here2");
            datastr = "op=getAvailEmps&skill="+args[1]+"&day=" +args[2]+"&hour=" +args[3];
            System.out.println("Searching for a: " + args[1] + " Who can work at: " + args[2] + args[3]);
        }   
            

            String response = Utils.httpsPost(url, datastr);
            System.out.println(response);

    }
}
