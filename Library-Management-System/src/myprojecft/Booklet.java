/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myprojecft;

import java.util.Date;

/**
 *
 * @author all in one
 */
public class Booklet extends Publication {

    public Booklet()
    {
        
    }

    public Booklet(int price, int nupages, String firstname, String lastname, String title) {
        super(price, nupages, firstname, lastname, title);
    }

    
    
  
 
    public boolean isOverPriod()
    {
        if(getPriod()>12)
            return true;
        else
            return false;
    }
    @Override
    public String toString()
    {
        return "Booklet: "+super.toString();

    }
}
