package pl.polsl.andrzej.kowol.sort.exception;

/**
 * Exception which is thrown if there are no data to sort.
 * 
 * @author Andrzej Kowol
 * @version 2.0
 */
public class NothingToSortException extends Exception{
    
    /**
     *  Non-parameter constructor.
     * 
     */
    public NothingToSortException(){
    }
    
    /**
     * Constructor with parameter.
     * 
     * @param msg Message with information about error.
     */
    public NothingToSortException(String msg){
        super(msg);
    }

    /**
     * Overrided method which return information about exception.
     * 
     * @return String with information about exception.
     */
    @Override
    public String toString(){
        return "There are not enough elements to sort";  
    }
}
