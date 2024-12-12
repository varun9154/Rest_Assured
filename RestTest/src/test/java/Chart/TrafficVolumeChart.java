package Chart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

import javax.swing.*;
import java.awt.*;

public class TrafficVolumeChart {

    public static void main(String[] args) {
       
        TimeSeries trafficVolumeSeries = new TimeSeries("Traffic Volume");

        trafficVolumeSeries.add(new Second(0, 0, 0, 1, 1, 2024), 100); 
        trafficVolumeSeries.add(new Second(10, 0, 0, 1, 1, 2024), 200); 
        trafficVolumeSeries.add(new Second(20, 0, 0, 1, 1, 2024), 400); 
        trafficVolumeSeries.add(new Second(30, 0, 0, 1, 1, 2024), 300); 
        trafficVolumeSeries.add(new Second(40, 0, 0, 1, 1, 2024), 150); 

        
        TimeSeriesCollection dataset = new TimeSeriesCollection(trafficVolumeSeries);

       
        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "Traffic Volume Over Time",    
                "Time",                        
                "Traffic Volume (vehicles/min)", 
                dataset,                       
                true,                          
                true,                          
                false                          
        );

       
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800, 600));
        JFrame frame = new JFrame("Traffic Volume Time Series Chart");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(chartPanel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}

