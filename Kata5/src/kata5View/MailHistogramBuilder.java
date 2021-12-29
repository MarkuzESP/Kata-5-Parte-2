package kata5View;

import java.util.List;
import kata5Model.Histogram;
import kata5Model.Mail;

public class MailHistogramBuilder {
    public static Histogram<String> build (List<Mail> listOfMails){
        Histogram<String> hist = new Histogram();
        for (Mail correo : listOfMails){
            hist.increment(correo.getDomain());
        }
        
        return hist;
    }
}
