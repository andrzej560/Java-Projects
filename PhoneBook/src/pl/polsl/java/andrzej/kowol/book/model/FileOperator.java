package pl.polsl.java.andrzej.kowol.book.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Class responsible for read and write file.
 * 
 * @author Andrzej Kowol
 * @version 1.0
 */
public class FileOperator {
    
    final String fileName = "address.txt";
    
    /**
     * Method which save addresses into file
     * 
     * @param dataList DataList
     * @return Return true if data was saved.
     */
    public boolean fileSave(DataList dataList){
        
        try{
                BufferedWriter br = new BufferedWriter(new FileWriter(fileName, true));
                for(Data d: dataList.getList()){
                    br.write(d.getName()+"/"+d.getLastName()+"/"+d.getNumber()+"\n");
                }
                br.close();
                return true;
            }catch(IOException e){
                return false;
            }
    }
    
    /**
     * Method which open file with addresses.
     * 
     * @param dataList DataList
     * @return True if file was open
     */
    public boolean fileLoad(DataList dataList){
        String line="";
        String parameter="";
        try{
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            while((line=br.readLine() ) !=null){
                parameter = line;
                dataList.add(parameter.split("/")[0], parameter.split("/")[1], parameter.split("/")[2]);
            }
            br.close();
            return true;
        }catch(FileNotFoundException e){
            return false;
        }catch(IOException e){
            return false;
        }
    }
}

