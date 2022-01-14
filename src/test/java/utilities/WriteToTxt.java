package utilities;

import pojos.Registrant;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class WriteToTxt {
//since I save my registrant data in the file i gave it as paraemeter
    public static void saveRegistrantData(String fileName, Registrant registrant){  //when we create file we need file name and location this is the location

        try{

            FileWriter fileWriter= new FileWriter(fileName, true);
            BufferedWriter writer =new BufferedWriter(fileWriter);
            writer.append(registrant.getFirstName()+ ","+ registrant.getLastName()+","+registrant.getEmail()+","+registrant.getLangKey()+","+
                    registrant.getLogin()+","+registrant.getSsn()+",\n");  //append means add, data in the registrant object
           writer.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
