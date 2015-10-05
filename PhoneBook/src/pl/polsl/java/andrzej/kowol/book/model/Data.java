package pl.polsl.java.andrzej.kowol.book.model;

/**
 * Data which is inserted into DataList. It contains name, last name and phone number
 * 
 * @author Andrzej Kowol
 * @version 1.0
 */
public class Data {
    private String name;
    private String lastName;
    private int number;
    
    /**
     * Constructor of application.
     * 
     * @param name Name which is inserted
     * @param lastName Last name which is inserted
     * @param number  Phone number
     */
    public Data(String name, String lastName, int number){
        this.name = name;
        this.lastName = lastName;
        this.number = number;
    }
    
    /**
     * This method return name.
     * 
     * @return String First name from address
     */
    public String getName(){
        return name;
    }
    
    /**
     * This method return last name.
     * 
     * @return lastName Last name from address
     */
    public String getLastName(){
        return lastName;
    }
    
    /**
     * This method return phone number.
     * 
     * @return number Phone number
     */
    public int getNumber(){
        return number;
    }
    
}
