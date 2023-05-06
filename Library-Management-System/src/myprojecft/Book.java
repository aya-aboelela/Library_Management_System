/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myprojecft;

import java.util.Date;

    
public class Book extends Publication{

    public Book() 
    {
        
    }

    public Book(int price, int nupages, String firstname, String lastname, String title) {
        super(price, nupages, firstname, lastname, title);
    }
    
    
    public boolean isOverPriod()
    {
        if(getPriod()>20)
        return true;
        else
            return false;
    }
  
    public String toString()
    {
        return "Book: "+super.toString();

    }
}
