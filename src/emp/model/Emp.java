/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emp.model;

/**
 *
 * @author csc190
 */
public class Emp implements java.io.Serializable{
    protected int id;
    protected String name;
    protected String[] skills;
    protected Schedule schedule;
    public Emp(int id, String name, String[] skills, Schedule schedule){
        this.id = id;
        this.name = name;
        this.skills = skills;
        this.schedule = schedule;
    }

}
