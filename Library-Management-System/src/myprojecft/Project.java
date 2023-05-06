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
import java.util.*;
import java.util.Date;
import java.io.*;

public class Project {

    public static ArrayList<Publication> list;

    //function used to read from the file
    public static void ReadFile(String file) {
        list = new ArrayList<Publication>();
        try {
            File f = new File(file);
            Scanner input = new Scanner(f);
            while (input.hasNext()) {
                String type = input.next();
                int nupages = input.nextInt();
                int price = input.nextInt();
                String firstname = input.next();
                String lastname = input.next();
                String title = input.nextLine();
                if (type.equals("Book")) {
                    list.add(new Book(price, nupages, firstname, lastname, title));
                } else if (type.equals("Booklet")) {
                    list.add(new Booklet(price, nupages, firstname, lastname, title));
                } else {
                    list.add(new Magazine(price, nupages, firstname, lastname, title));
                }
            }
            input.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //function used to write in a file
    public static void WriteFile(String file) {
        try {
            File f = new File(file);
            Scanner input = new Scanner(System.in);
            PrintWriter pw = new PrintWriter(f);
            for (int i = 0; i < list.size(); i++) {
                Publication p = list.get(i);
                if (p instanceof Book) {
                    pw.print("Book ");
                    pw.println(p.getNupages() + " " + p.getPrice() + " " + p.getFirstname() + " " + p.getLastname() + " " + p.getTitle());
                } else if (p instanceof Booklet) {
                    pw.print("Booklet ");
                    pw.println(p.getNupages() + " " + p.getPrice() + " " + p.getFirstname() + " " + p.getLastname() + " " + p.getTitle());
                } else if (p instanceof Magazine) {
                    pw.print("Magazine ");
                    pw.println(p.getNupages() + " " + p.getPrice() + " " + p.getFirstname() + " " + p.getLastname() + " " + p.getTitle());
                }
            }
            pw.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //function used to add apublication
    public static void add(String type, int pages, int price, String firstname, String lastname, String title) {
        if (type.trim().equals("Book")) {
            list.add(new Book(price, pages, firstname, lastname, title));
        } else if (type.trim().equals("Booklet")) {
            list.add(new Book(price, pages, firstname, lastname, title));
        } else if (type.trim().equals("Magazene")) {
            list.add(new Book(price, pages, firstname, lastname, title));
        }
        System.out.println("Successfully Done");
    }

    //function used to delete apublication
    public static void delete(String title) {
        boolean f = false;
        for (int i = 0; i < list.size(); i++) {
            Publication p = list.get(i);
            if (p.getTitle().trim().equals(title)) {
                f = true;
                list.remove(i);
                System.out.println("Successfully Done");
                break;
            }
        }
        if (f == false) {
            System.out.println("Sorry there is noPublication with this title");
        }
    }

    //function used to modify apublication
    public static void modify(String type, int pages, int price, String firstname, String lastname, String title) {
        boolean f = false;
        for (int i = 0; i < list.size(); i++) {
            Publication p = list.get(i);
            if (p.getTitle().trim().equals(title)) {
                f = true;
                p.setTitle(title);
                p.setPrice(price);
                p.setFirstname(firstname);
                p.setLastname(lastname);
                System.out.println("Successfully Done");
                break;
            }
        }
        if (f == false) {
            System.out.println("Sorry there is noPublication with this Details");
        }
    }

    //function used to search for a publication
    public static void search(String s) {
        boolean f = false;
        for (int i = 0; i < list.size(); i++) {
            Publication p = list.get(i);
            if (p.getTitle().trim().equals(s)) {
                if (p instanceof Book) {
                    System.out.println((Book) p);
                } else if (p instanceof Booklet) {
                    System.out.println((Booklet) p);
                } else {
                    System.out.println((Magazine) p);
                }
                f = true;
            }
        }
        if (f == false) {
            System.out.println(" Sorry There is no aPublication with this title");
        }
    }

    //function used to display list of all available publication
    public static void displayAvailable(){
        int c=0;
        for (int i = 0; i < list.size(); i++) {
            Publication p = list.get(i);
            if (!p.isBorrowed()) {
                 c++;
                if (p instanceof Book) {
                    System.out.println((Book) p);
                } else if (p instanceof Booklet) {
                    System.out.println((Booklet) p);
                } else if (p instanceof Magazine) {
                    System.out.println((Magazine) p);
                }
            }
        }
        if(c==0)
            System.out.println("There is no avalibale publication");
    }

    //functio used to borrow apublictio
    public static void borrowedpublication(String title, Date d1, String name, int id, int stage) throws ExceptionNotfound {
        boolean f = false;
        for (int i = 0; i < list.size(); i++) {
            Publication p = list.get(i);
            if (p.getTitle().trim().equals(title)) {
                f = true;
                p.borrow(d1, name, id, stage);
                System.out.println("The Borrowing Process Completed Succassfully");
                break;
            }
        }
        if (f == false) {
            System.out.println("Sorry there is no Publication with this Title");
        }
    }

    //function used to display list of aborrowed publication
    public static void displayaborrowedpublication() {
        int c=0;
        for (int i = 0; i < list.size(); i++) {
            Publication p = list.get(i);
            if (p.isBorrowed()) {
                c++;
                if (p instanceof Book) {
                    System.out.println((Book) p);
                } else if (p instanceof Booklet) {
                    System.out.println((Booklet) p);
                } else if (p instanceof Magazine) {
                    System.out.println((Magazine) p);
                }
            }
        }
        if(c==0)
        {
            System.out.println("There is no aborrowed publication");
        }
    }

    //function used to display list of overpriod publicatio
    public static void overpriod() {
        int c=0;
        for (int i = 0; i < list.size(); i++) {
            Publication p = list.get(i);
            if (p.isOverPriod()) {
                c++;
                if (p instanceof Book) {
                    System.out.println((Book) p);
                } else if (p instanceof Booklet) {
                    System.out.println((Booklet) p);
                } else if (p instanceof Magazine) {
                    System.out.println((Magazine) p);
                }
            }
        }
         if(c==0)
             System.out.println("There is no a over_priod borrowed publication");
    }

    //function used to return apublication
    public static void returnPublicatuin(String title, Date d) {
        for (int i = 0; i < list.size(); i++) {
            Publication p = list.get(i);
            if (p.getTitle().trim().equals(title)) {
                if (p instanceof Book) {
                    p.Return(d);
                    if (p.isOverPriod()) {
                        System.out.println("You Must Pay apaument = " + p.getPrice() * 0.1);
                    }
                    else
                    {
                        System.out.println("The Return Operation Completed Successfully and you dont have apayment");
                    }
                }
                if (p instanceof Booklet) {
                    p.Return(d);
                    if (p.isOverPriod()) {
                        System.out.println("You Must Pay apaument = " + p.getPrice() * 0.1);
                    }
                    else
                    {
                        System.out.println("The Return Operation Completed Successfully and you dont have apayment");                        
                    }
                }
                if (p instanceof Magazine) {
                    p.Return(d);
                    if (p.isOverPriod()) {
                        System.out.println("You Must Pay apaument = " + p.getPrice() * 0.1);
                    }
                    else
                    {
                        System.out.println("The Return Operation Completed Successfully and you dont have apayment");                        
                    }
                }

            }
        }
    }

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        ReadFile("file.txt");
        Scanner input = new Scanner(System.in);
        int x = 0, q=0 , y = 0;

        do {
            System.out.println("If you are astudent Enter 1,If You are aManeger Enter 2,To Exit Enter 0");
            try {
                q = input.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Please Enter Avalid Number");
                input.next();
            }
            catch(Exception e)
            {
               System.out.println("ERROR ..."+e.getMessage());               
               input.next();
            }
            if (q == 1) {
                do {
                    System.out.println("To View The Menu Press Number 1 ,To Exit Press Number 0");
                    try {
                        x = input.nextInt();
                    } catch (InputMismatchException ex) {
                        System.out.println("Please Enter Avalid Number");
                        input.next();
                    }
                    catch(Exception e)
                    {
                      System.out.println("ERROR ..."+e.getMessage());
                      input.next();
                    }

                    if (x == 1) {

                        System.out.println("To Borrowa Publication Enter 1");
                        System.out.println("To search for aPublicatio Enter 2");
                        System.out.println("To Return a Publication Enter 3");
                        System.out.println("To Display List Of Available publications Enter 4");
                        try {
                            y = input.nextInt();
                        } catch (InputMismatchException ex) {
                            System.out.println("Please Enter Avalid Number");
                            input.next();
                        }
                        catch(Exception e)
                        {
                                 System.out.println("ERROR ..."+e.getMessage()); 
                                 input.next();
                        }
                        if (y == 1) {
                            System.out.println("Please Enter your name & Your ID and your stage");
                            int id=0,stage=0;
                            String name = input.next();
                            try{
                             id = input.nextInt();
                            }catch(InputMismatchException ex)
                            {
                                System.out.println("Please Enter avalid Number");
                                input.next();
                            }
                            catch(Exception e)
                            {
                                System.out.println("ERROR ..."+e.getMessage());
                                 input.next();
                            }
                            try{
                             stage = input.nextInt();
                            }catch(InputMismatchException ex)
                            {
                                System.out.println("Please Enter avalid Number");
                                input.next();
                            }
                            catch(Exception e)
                            {
                                 System.out.println("ERROR ..."+e.getMessage());  
                                 input.next();
                            }
                            System.out.println("Enter the Publication Title ");
                            String title = input.next();
                            System.out.println("Please Enter The Issue Date");
                            int dd = 1, m1 = 1, y1 = 1;
                            try {
                                dd = input.nextInt();
                                m1 = input.nextInt();
                                y1 = input.nextInt();
                            } catch (InputMismatchException ex) {
                                System.out.println("Plaese Enter avalid Numbers");
                                input.next();
                            }
                            catch(Exception e)
                            {
                                 System.out.println("ERROR ..."+e.getMessage());
                                 input.next();
                            }
                            Date d1 = new Date(y1, m1, dd);
                            try {
                                borrowedpublication(title, d1, name, id, stage);
                            } catch (ExceptionNotfound ex) {
                                System.out.println("This Publication is not available now for borrowed");
                            }
                            catch(Exception e){
                                System.out.println("ERROR ..."+e.getMessage());
                                input.next();
                            }
                        }
                         else if (y == 2) {
                            System.out.println("Please Enter apublication Title");
                            String title = input.next();
                            search(title);
                        } else if (y == 3) {
                            System.out.println("Please Enter The Publication Title");
                            String title = input.next();
                            System.out.println("Please Enter The Return Dete");
                            int d = 1, m = 1, y1 = 1;
                            try {
                                d = input.nextInt();
                                m = input.nextInt();
                                y1 = input.nextInt();
                            } catch (InputMismatchException ex) {
                                System.out.println("Please Enter avalid Number");
                                input.next();
                            }
                            catch(Exception e)
                            {
                                System.out.println("ERROR ..."+e.getMessage());    
                                input.next();
                            }
                            Date d1 = new Date(y1, m, d);
                            returnPublicatuin(title, d1);
                        }
                        else if(y==4)
                        {
                            displayAvailable();                            
                        }
                    }
                    else if(x==0)
                    {
                        break;
                    }
                }while (x != 0);
            }
            else if (q == 2) {
                do {
                    System.out.println("To View The Menu Press Number 1 ,To Exit Press Number 0");
                    try {
                        x = input.nextInt();
                    } catch (InputMismatchException ex) {
                        System.out.println("Please Enter Avalid Number");
                        input.next();
                    }
                    catch(Exception e)
                    {
                         System.out.println("ERROR ..."+e.getMessage());      
                         input.next();
                    }
                    if (x == 1) {
                        System.out.println("To Add Publication Details Enter 1");
                        System.out.println("To Modify Publication Details Enter 2");
                        System.out.println("To Delete Publication Details Enter 3");
                        System.out.println("To Search For a Publicatio Enter 4");
                        System.out.println("To Display List Of Available publications Enter 5");
                        System.out.println("To Display List Of Borrowed Publications Enter 6");
                        System.out.println("To Display List Of Over-priod Borrowed Publications Enter 7");
                        try {
                            y = input.nextInt();
                        } catch (InputMismatchException ex) {
                            System.out.println("Please Enter Avalid Number");
                            input.next();
                        }
                        catch(Exception e)
                        {
                                System.out.println("ERROR ..."+e.getMessage());    
                                input.next();
                        }

                        if (y == 1) {
                            try {
                                System.out.println("Please Enter the Publication Details:The Type Of Publication:");
                                String type = input.next();
                                System.out.println("Please Enter the Number of Pages of the Publication:");
                                int nupages = input.nextInt();
                                System.out.println("Please Enter the Price of the Publication:");
                                int price = input.nextInt();
                                System.out.println("Please Enter the first name of the athor:");
                                String firstname = input.next();
                                System.out.println("Please Enter the last nae of the author:");
                                String lastname = input.next();
                                System.out.println("Please Enter the Title of the Publication:");
                                String title = input.next();
                                add(type, nupages, price, firstname, lastname, title);
                            } catch (InputMismatchException ex) {
                                System.out.println("Please Enter Avalid Information");
                                input.next();
                            }
                            catch(Exception e)
                            {
                                System.out.println("ERROR ..."+e.getMessage());    
                                input.next();
                            }
                        } else if (y == 2) {
                            int nupages=0,price=0;
                                System.out.println("Please Enter the Publication Title:");
                                String title = input.nextLine();
                                System.out.println("Please Enter the  New Publication Details:the type of Publication");
                                String type = input.next();
                                System.out.println("Enter The price ");
                                try{
                                price = input.nextInt();
                                }catch(InputMismatchException ex)
                                {
                                    System.out.println("Please Enter avalid Number");
                                    input.next();
                                }
                                catch(Exception e)
                                {
                                 System.out.println("ERROR ..."+e.getMessage());   
                                 input.next();
                                }
                                System.out.println("Enter The Number of pages ");  
                                try{
                                 nupages = input.nextInt();
                                }catch(InputMismatchException ex)
                                {
                                    System.out.println("Please Enter avalid Number");
                                    input.next();
                                }
                                catch(Exception e)
                                {
                                System.out.println("ERROR ..."+e.getMessage());       
                                input.next();
                                }
                                System.out.println("Enter The First name of the author ");                                
                                String first = input.next();
                                System.out.println("Enter The Last name of the author ");
                                String last = input.next();
                                System.out.println("Enter The title of publication ");
                                String title1 = input.next();
                                modify(type, nupages, price, first, last, title1);
                        } else if (y == 3) {
                            System.out.println("Please Enter the Publication Title:");
                            String title = input.next();
                            delete(title);
                        } else if (y == 4) {
                            System.out.println("Please Enter apublication Title");
                            String title = input.next();
                            search(title);
                        } else if (y == 5) {
                            displayAvailable();
                        } else if (y == 6) {
                            displayaborrowedpublication();
                        } else if (y == 7) {
                            overpriod();
                        }
                    }
                    else if(x==0){
                        break;
                    }
                  
                } while (x != 0);
            }
            else if (q == 0) {
                WriteFile("file.txt");
                System.out.println("Thank You For Using This App");
                break;
            }
            else {
                System.out.println("Please Enter Avalid Number");
            }
        } while (q != 0);
    }
}
