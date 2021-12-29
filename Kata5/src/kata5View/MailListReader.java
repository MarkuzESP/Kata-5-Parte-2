package kata5View;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kata5Model.Mail;

public class MailListReader {
    public static List<Mail> read (String fileName) throws FileNotFoundException,
            IOException{
        List<Mail> listOfMails = new ArrayList<>();
        
        try(BufferedReader reader = new BufferedReader
        (new FileReader(new File(fileName)))){
            String correo;
            // Mientras se puedan leer correos
            while((correo=reader.readLine()) != null){
                // La idea es que si la linea leída no contiene una @,
                // siendo un carácter necesario para la nomenclatura de un email,
                // se ignora esa línea y se lee la siguiente.
                if(!correo.contains("@")){
                    continue;
                }
                listOfMails.add(new Mail(correo));
            }
        }
        return listOfMails;
    }
}
