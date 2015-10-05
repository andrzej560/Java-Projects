package pl.polsl.java.andrzej.kowol.book.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import pl.polsl.java.andrzej.kowol.book.model.FileOperator;

/**
 * Class which are responsible for displaying data on the Window.
 * 
 * @author Andrzej Kowol
 * @version 1.0
 */
public class AddressBookPanel extends JPanel implements ActionListener, WindowListener{
    
    JToolBar toolBar = new JToolBar();
    JMenuBar jMenuBar = new JMenuBar();
    JFrame frame = new JFrame("Adress Book"); //main window of application
    private JTextField nameInput, lastNameInput, numberInput;
    private JLabel nameLabel, lastNameLabel, numberLabel; 
    AddressBookTable addressBookTable = new AddressBookTable();
    JTable table = new JTable(addressBookTable);
    FileOperator fo = new FileOperator();
    /**
     * Method which try insert address into list.
     */
    public void insertData(){
        
        if ( addressBookTable.getList().add( nameInput.getText(),lastNameInput.getText(), numberInput.getText())){
                JOptionPane.showMessageDialog(frame, "Address is inserted");
            } else{
                JOptionPane.showMessageDialog(frame, "You insert wrong value");
            }
        table.updateUI(); //refresh table which is displaying on the screen
    }
    
    
    /**
     * Generate components which are responsible for add addresses into list
     */
    public void addData(){
        
        nameInput = new JTextField(16);
        lastNameInput = new JTextField(15);
        numberInput = new JTextField(15);        
        nameLabel = new JLabel("Name:");
        lastNameLabel = new JLabel("Last Name:");
        numberLabel = new JLabel("Number:");
        
        add(nameLabel);
        add(nameInput);
        add(lastNameLabel);
        add(lastNameInput);
        add(numberLabel);
        add(numberInput);
    }
    
    /**
     * Generate components which are associated with created toolbar.
     */
    public void addToolBar(){
        JButton clear = new JButton("Clear"); 
        clear.addActionListener(this);
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(this);
        JButton addButton = new JButton("Add");
        addButton.addActionListener(this);
        toolBar.add(clear); 
        toolBar.add(saveButton);
        toolBar.add(addButton);
    }
    /**
     * Generate components which are related with created menu.
     */
    public void addMenu(){
        
        frame.setJMenuBar(jMenuBar);
        
        JMenu file = new JMenu("Action");
        
        jMenuBar.add(file);
        JMenu help = new JMenu("Help");
        
        jMenuBar.add(help);
        JMenuItem save = new JMenuItem("Save");
        save.addActionListener(this);
        file.add(save);
        
        JMenuItem add = new JMenuItem("Add");
        add.addActionListener(this);
        file.add(add);
        file.addSeparator();
        JMenuItem close = new JMenuItem("Close");
        close.addActionListener(this);
        file.add(close);
        
        JMenuItem about = new JMenuItem("About");
        about.addActionListener(this);
        help.add(about);
    }
    
    /**
     * Constructor. Generate window.
     */
    public AddressBookPanel() {
        
        super(new FlowLayout(FlowLayout.LEFT));
        JScrollPane scrollPane = new JScrollPane(table);
        frame.addWindowListener(this);
        addData();
        addMenu();
        add(scrollPane);
        addToolBar();
        add(toolBar);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setContentPane(this);
        frame.setVisible(true);
        frame.setSize(480,640);
        frame.setResizable(false); 
        if (fo.fileLoad(addressBookTable.getList())){
            JOptionPane.showMessageDialog(frame, "File was found!");
            table.updateUI();
        }
        
    }

    /**
     * Method which support Action Listener
     * 
     * @param e ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String text = null;
        
        if(e.getSource() instanceof JMenuItem){
            JMenuItem menu = (JMenuItem) e.getSource();
            text = menu.getText();
        }
       
        if(e.getSource() instanceof JButton){
            JButton button = (JButton) e.getSource();
            text = button.getText();
        }
        
        if (text != null){
            if (text.equals("Close")){
                JOptionPane.showMessageDialog(null,"Good Bye");
                System.exit(0);
            }else if (text.equals("Save")){
                if(fo.fileSave(addressBookTable.getList())){
                     JOptionPane.showMessageDialog(frame, "You save your data!");
                }
            }else if (text.equals("About")){
                JOptionPane.showMessageDialog(frame, "Save your contacts! \nAuthor: Andrzej Kowol");
            }else if (text.equals("Add")){
                insertData();  
             
            }else if (text.equals("Clear")){
                addressBookTable.getList().clear();
                JOptionPane.showMessageDialog(frame, "List is cleared!");
                table.updateUI();
            }
        }  
    }

    /**
     * Event when window is opened.
     * 
     * @param e WindowEvent
     */
    @Override
    public void windowOpened(WindowEvent e) {
       JOptionPane.showMessageDialog(frame,"Welcome");
    }

    /**
     * Event when window is opened.
     * 
     * @param e WindowEvent
     */
    @Override
    public void windowClosing(WindowEvent e) {
        JOptionPane.showMessageDialog(frame,"Good Bye");
    }

    /**
     * Event when window is closed.
     * 
     * @param e WindowEvent
     */
    @Override
    public void windowClosed(WindowEvent e) {
    }

    /**
     * Event when window is closed.
     * 
     * @param e WindowEvent
     */
    @Override
    public void windowIconified(WindowEvent e) {
        JOptionPane.showMessageDialog(frame,"Window is minimized");
    }

    /**
     * Event when window is deiconified.
     * 
     * @param e WindowEvent
     */
    @Override
    public void windowDeiconified(WindowEvent e) {
        JOptionPane.showMessageDialog(frame,"Window is maximized");
    }

    /**
     * Event when window is activated.
     * 
     * @param e WindowEvent
     */
    @Override
    public void windowActivated(WindowEvent e) {
    }

    /**
     * Event when window is deactivated.
     * 
     * @param e WindowEvent
     */
    @Override
    public void windowDeactivated(WindowEvent e) {
    }
}
