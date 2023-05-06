/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myprojecft;

/**
 *
 * @author all in one
 */
public class Student extends Person {
    private int stage;
    public Student() {
        stage=1;
    }

    public Student(String name, int id,int stage) {
        super(name, id);
       this.stage=stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public int getStage() {
        return stage;
    }
        
    
}
