package kata5Controller;

import java.io.IOException;
import java.util.List;
import kata5Model.Histogram;
import kata5Model.Mail;
import kata5View.HistogramDisplay;
import kata5View.MailHistogramBuilder;
import kata5View.MailListReader;

/**
 * @author Marcos del Cristo Díaz Gil
 * Ingeniería del Software 2, Universidad de las Palmas de Gran Canaria
 */
public class Controller {
    private String fileRoute;
    private List<Mail> listOfMails;
    private Histogram<String> histogram;
    
    public static void main(String[] args) throws IOException{
        Controller controlador = new Controller();
        controlador.control();
    }
    
    private void control() throws IOException{
        input();
        process();
        output();
    }

    private void input() throws IOException{
        // Se deja la ruta absoluta del fichero utilizado para la prueba.
        fileRoute = "C:\\Users\\Usuario\\Desktop\\Proyectos IS2 GitHub\\Kata-5-Parte-2\\email.txt";
        //C:\Users\Usuario\Desktop\Proyectos IS2 GitHub\Kata-5-Parte-2
        listOfMails = MailListReader.read(fileRoute);
    }

    private void process(){
        histogram = MailHistogramBuilder.build(listOfMails);
    }

    private void output(){
        new HistogramDisplay(histogram).execute();
    }
}

