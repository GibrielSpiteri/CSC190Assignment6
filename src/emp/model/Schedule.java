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
public class Schedule implements java.io.Serializable{
    protected String[] days;
    protected int[] hours;
    public Schedule(String[] days, int[] hours){
        this.days = days;
        this.hours = hours;
    }
}
