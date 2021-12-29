package kata5View;

// Al tener un proyecto estructurado en varios paquetes, 
// es necesario importar la clase referenciada desde el paquete.
import kata5Model.Histogram;
import java.awt.Dimension;
import javax.swing.JPanel;

// Utilidades obtenidas al traer las librerias necesarias para el ejercicio
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class HistogramDisplay extends ApplicationFrame{
    private final Histogram<String> histogram;
    
    public HistogramDisplay(Histogram<String> histogram) {
        super("Histograma");
        this.histogram=histogram;
        setContentPane(createPanel());
        pack();
    }
    
    private JPanel createPanel(){
        ChartPanel chartPanel = new ChartPanel(createChart(createDataset()));
        chartPanel.setPreferredSize(new Dimension(500,400));
        return chartPanel;
    }
    
    private DefaultCategoryDataset createDataset(){
        DefaultCategoryDataset dataSet= new DefaultCategoryDataset();
        for (String key : histogram.keySet()){
            dataSet.addValue(histogram.get(key),"", key);
        }        
        return dataSet;
    }
    
    private JFreeChart createChart(DefaultCategoryDataset dataSet){
        JFreeChart chart = ChartFactory.createBarChart("Histograma", "Dominios",
                "Correos por dominio", dataSet, PlotOrientation.VERTICAL, 
                false, false, rootPaneCheckingEnabled);
        return chart;
    }
        
    public void execute(){
        setVisible(true);
    }
}
