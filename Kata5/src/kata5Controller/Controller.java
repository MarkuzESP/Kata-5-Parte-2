package kata5Controller;

import java.io.IOException;
import java.util.List;
import kata5Model.Histogram;
import kata5Model.Mail;
import kata5View.HistogramDisplay;
import kata5View.MailHistogramBuilder;
import kata5View.MailListReaderDB;

/**
 * @author Marcos del Cristo Díaz Gil
 * Ingeniería del Software 2, Universidad de las Palmas de Gran Canaria
 */
public class Controller {
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

    private void input(){
        listOfMails = new MailListReaderDB().read();
    }

    private void process(){
        histogram = MailHistogramBuilder.build(listOfMails);
    }

    private void output(){
        new HistogramDisplay(histogram).execute();
    }
}

