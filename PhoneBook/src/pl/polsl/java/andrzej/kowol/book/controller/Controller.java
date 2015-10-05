package pl.polsl.java.andrzej.kowol.book.controller;

import pl.polsl.java.andrzej.kowol.book.view.AddressBookPanel;

/**
 * Main class of application.
 * 
 * @author Andrzej Kowol
 * @version 1.0
 */
public class Controller {
    
    
    public static void main(String[] args){

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            
            /**
             * Method which load window.
             */
            @Override
            public void run() {
                new AddressBookPanel();
            }
        });
    }      
}
