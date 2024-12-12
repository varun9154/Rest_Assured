package Chart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;

public class ChatDiagram {

    public static void main(String[] args) {
        
        String[] nodes = {"Node A", "Node B", "Node C", "Node D", "Node E"};
        double[] pagerankScores = {0.35, 0.25, 0.15, 0.10, 0.05};
        
        
        DefaultCategoryDataset dataset = createDataset(nodes, pagerankScores);

       
        JFreeChart barChart = ChartFactory.createBarChart(
                "PageRank Scores for Nodes", 
                "Nodes",                     
                "PageRank Score",            
                dataset,                     
                PlotOrientation.VERTICAL,   
                true,                        
                true,                        
                false                        
        );

        
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        JFrame frame = new JFrame("PageRank Bar Chart");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(chartPanel);
        frame.pack();
        frame.setVisible(true);
    }

    private static DefaultCategoryDataset createDataset(String[] nodes, double[] pagerankScores) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

       
        for (int i = 0; i < nodes.length; i++) {
            dataset.addValue(pagerankScores[i], "PageRank", nodes[i]);
        }

        return dataset;
    }
}
