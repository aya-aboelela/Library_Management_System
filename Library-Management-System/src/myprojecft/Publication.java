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
import java.util.Date;
public abstract class Publication {
    private String title;
    private String firstname;
    private String lastname;
    private int nupages;
    private int price;
    private boolean borrowed;
    private Date issueDate;
    private Date returnDate;
    private Student s1;
   public Publication()
   {
     title ="java";
     firstname ="Ahmed";
     lastname="Ali";
     nupages=0;
     price=0;
     borrowed=false;
     issueDate=new Date();
     returnDate=new Date();
     s1=new Student();
   }

    public Publication( int price,int nupages,String firstname,String lastname,String title) {
        this.title=title;
        this.firstname=firstname;
        this.lastname=lastname;
        this.price=price;
        this.nupages=nupages;
        borrowed=false;
        issueDate=new Date();
        returnDate=new Date();
        s1=new Student();
    }
    
   
    //setter function
    public void setTitle(String title) {
        this.title = title;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setNupages(int nupages) {
        this.nupages = nupages;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
  
    //getter function
    public String getTitle() {
        return title;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getNupages() {
        return nupages;
    }

    public int getPrice() {
        return price;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }
    
    //function used to borrow abook
    public void borrow(Date issue,String name,int id,int stage)throws ExceptionNotfound
    {
        if(borrowed==true)
            throw new ExceptionNotfound();
        else{     
              s1.setId(id);
              s1.setName(name);
              s1.setStage(stage);
              borrowed=true;
              issueDate=issue;
        }
    }
    
    //function used to return abook
    public void Return(Date d )
    {
        borrowed=false;
        returnDate=d;
        
    }
    
    //function get the borroeing priod
    public long getPriod()
    {
        long i1=issueDate.getTime();
        long i2=returnDate.getTime();
        long t=i2-i1;
        long time=t/24/60/60/1000;
        return time;
    }
    
    //function
    public abstract boolean isOverPriod();
 
    //toString function
    @Override
    public String toString()
    {
        return "title is "+title+" "+"Auther name is "+firstname+" "+lastname+" "+"Number of pages is "+nupages+" "
               +"Price is "+price+" "+"is borrowed "+borrowed+" "+"issueDate is "+issueDate+" "+"returnDate is "+returnDate;
    }
   
}
