package pl.polsl.java.andrzej.kowol.book.view;

import pl.polsl.java.andrzej.kowol.book.model.DataList;
import javax.swing.table.AbstractTableModel;

/**
 * Class which contains table with addresses.
 * 
 * @author Andrzej Kowol
 * @version 1.0
 */
public class AddressBookTable extends AbstractTableModel{
    
    private final String[] columnNames = {"Name", "Last Name", "Number"};
    
    DataList dataList;
    int columns = columnNames.length; //number of columns
    
    /**
     * Nonparametered constructor
     */
    public AddressBookTable(){
        dataList = new DataList(); 
    }
    
    /**
     * Method which returns dataList.
     * 
     * @return dataList List with data
     */
    public DataList getList(){
        return dataList;
    }
    
    /**
     * Method which return name of the column from array.
     * 
     * @param col Index of column
     * @return columnNames[col] Name of the column
     */
    public String getColumnName(int col) {
            return columnNames[col];
    }
    
    /**
     * Method which returns number of rows.
     * 
     * @return dataList.getList().size() Size of dataList
     */
    @Override
    public int getRowCount() {
        return dataList.getList().size();
    }
    
    /**
     * Method which returns number of columns.
     * 
     * @return columns Number of columns
     */
    @Override
    public int getColumnCount() {
        return columns;
    }
    
    /**
     * Method which returns data which will be display in table.
     * 
     * @param rowIndex Index of row.
     * @param columnIndex Index of column.
     * @return Data which will be display in table. Name, last name or phone number.
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        switch (columnIndex){
            
            case 0:
                return dataList.getList().get(rowIndex).getName();
            case 1:    
                return dataList.getList().get(rowIndex).getLastName();
            default: 
                return dataList.getList().get(rowIndex).getNumber();  
        }
    }    
}
