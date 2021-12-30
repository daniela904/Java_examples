package view;

import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 *
 * @author AstridM & DanielaM
 */
public class ResultsPanel extends JPanel {

    private JTable tblResults;

    public ResultsPanel() {
        initComponents();
    }

    //Table to show results of users in database
    private void initComponents() {
        this.tblResults = new JTable(); //Adds the results table to the graph interface
        this.tblResults.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); // Uses scroll instead
        this.tblResults.setShowVerticalLines(false); // Just displays horizontal lines
        tblResults.setPreferredSize(new Dimension(700, 255));
    }

    public JTable getTblResults() {
        return tblResults;
    }

    /**
     * @param tblResults the tblResults to set
     */
    public void setTblResults(JTable tblResults) {
        this.tblResults = tblResults;
    }
}
