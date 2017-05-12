package emp;

import emp.model.EmpList;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author csc190
 */
public class Server {
    // Takes the serialized EmpList data and updates the database
    protected static void updateEmp(String val){
        try{
        String qry = "UPDATE employees SET emplist='" + val +"' WHERE name='name'";
        //System.out.println("preupload");
        Utils.execNonQuery(qry);
        System.out.println("Uploaded!");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    // Given a skill, day, and time (i.e. "Butcher", "M", "12")
    // It will return all available employees for that time
    protected static String getAvailEmps(String skill, String day, String hour){
        //1. retrieve all emps
        String qry = "SELECT emplist FROM employees WHERE name='name'";
        String empObjStr = Utils.execQuery(qry);
        
        //String day = time.substring(0,1);
        int time = Integer.parseInt(hour);
        if(empObjStr==null) return "Failure 1";
        EmpList emps = (EmpList) Utils.toObj(empObjStr);
        if(emps==null) return "Failure 2";
        ArrayList<Integer> empSkills = emps.getEmpBySkill(skill);
        ArrayList<Integer> empSchedule = emps.getEmpBySchedule(day, time);
        
        // Search for employees that match the skill and availablity
        String names = "";
        for (int i=0; i<empSkills.size(); i++){
            for(int j=0; j<empSchedule.size(); j++){
                if (empSkills.get(i).equals(empSchedule.get(j))){
                    //availEmps.add(empSchedule.get(j));
                    names = emps.getEmpByID(empSchedule.get(j));
                    System.out.println(names);
                }
            }
            
        }
        
        
        return "";
    }
    public static void main(String [] args){
        String op = args[0];
        if(op.equals("uploadEmps")){
            updateEmp(args[1]);
        }else{
            String available = getAvailEmps(args[1], args[2], args[3]);
            //String available = getAvailEmps("Butcher", "M12");
            System.out.println(available);
        }
    }
}
