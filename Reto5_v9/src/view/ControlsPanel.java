package view;

import controller.ClickEvent;
import controller.InitialData;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.UserModel;

/**
 *
 * @author AstridM & DanielaM
 */
public class ControlsPanel extends JPanel {

    // Four panels: logo section, input text section, buttons section 
    //  and table results section
    private JPanel panel0;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    // For logo display
    private JLabel lblLogo;
    // For input of users' aliases
    private JLabel lblAlias;
    private JTextField txtAlias;
    // For input of usernames
    private JLabel lblNombres;
    private JTextField txtNombres;
    // For input of users' lastnames
    private JLabel lblApellidos;
    private JTextField txtApellidos;
    // For input of users' emails
    private JLabel lblEmail;
    private JTextField txtEmail;
    // For input of users' contact numbers
    private JLabel lblCelular;
    private JTextField txtCelular;
    // For input of users' passwords. Not included on initial design
    /* private JLabel lblClave;
    private JTextField txtClave;*/
    // For input of users' birth dates
    private JLabel lblFecha;
    private JTextField txtFecha;
    // Four buttons, one for each CRUD operations
    private JButton btnSearch;
    private JButton btnAdd;
    private JButton btnUpdate;
    private JButton btnDelete;
    // To display search results
    private JTable tblResults;
    // To add a panel with scroll feature
    private JScrollPane jspPane;

    /**
     * Constructor of the contentPanel class.
     *
     * @param contentPane
     */
    public ControlsPanel(JPanel contentPane) {
        initComponents(contentPane);
    }

    private void initComponents(JPanel contentPane) {

        panel0 = new JPanel();
        panel0.setBackground(Color.WHITE);
        panel0.setBounds(0, 0, 720, 60);
        contentPane.add(panel0, BorderLayout.CENTER);
        panel0.setLayout(null);
        componentesPanel0();

        panel1 = new JPanel();
        panel1.setBackground(Color.WHITE);
        panel1.setBounds(0, 60, 720, 100);
        contentPane.add(panel1, BorderLayout.CENTER);
        panel1.setLayout(null);
        componentesPanel1();

        panel2 = new JPanel();
        panel2.setBackground(Color.WHITE);
        panel2.setBounds(0, 160, 720, 40);
        contentPane.add(panel2, BorderLayout.CENTER);
        componentesPanel2();

        panel3 = new JPanel();
        panel3.setBackground(Color.WHITE);
        panel3.setBounds(0, 200, 720, 260);
        contentPane.add(panel3, BorderLayout.CENTER);
        componentesPanel3();
    }

    private void componentesPanel0() {
        lblLogo = new JLabel();
        panel0.add(lblLogo, BorderLayout.EAST);
        lblLogo.setBounds(468, 0, 242, 58);
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("logo.png")));
    }

    private void componentesPanel1() {

        lblAlias = new JLabel("Alias: ");
        panel1.add(this.getLblAlias());
        lblAlias.setBounds(60, 10, 60, 20);

        txtAlias = new JTextField();
        panel1.add(this.getTxtAlias());
        txtAlias.setBounds(120, 10, 200, 20);

        this.lblNombres = new JLabel("Nombre: ");
        this.lblNombres.setBounds(60, 40, 60, 20);
        panel1.add(this.getLblNombres());

        this.txtNombres = new JTextField();
        this.txtNombres.setBounds(120, 40, 200, 20);
        panel1.add(this.getTxtNombres());

        this.lblApellidos = new JLabel("Apellido: ");
        this.lblApellidos.setBounds(60, 70, 60, 20);
        panel1.add(this.getLblApellidos());

        this.txtApellidos = new JTextField();
        this.txtApellidos.setBounds(120, 70, 200, 20);
        panel1.add(this.getTxtApellidos());

        this.lblEmail = new JLabel("Email: ");
        this.lblEmail.setBounds(400, 10, 60, 20);
        panel1.add(this.getLblEmail());

        this.txtEmail = new JTextField();
        this.txtEmail.setBounds(460, 10, 200, 20);
        panel1.add(this.getTxtEmail());

        this.lblCelular = new JLabel("Celular: ");
        lblCelular.setBounds(400, 40, 60, 20);
        panel1.add(this.getLblCelular());

        this.txtCelular = new JTextField();
        txtCelular.setBounds(460, 40, 200, 20);
        panel1.add(this.getTxtCelular());

        this.lblFecha = new JLabel("Fecha N: ");
        lblFecha.setBounds(400, 70, 60, 20);
        panel1.add(this.getLblFecha());

        this.txtFecha = new JTextField();
        txtFecha.setBounds(460, 70, 200, 20);
        panel1.add(this.getTxtFecha());
    }

    private void componentesPanel2() {

        this.btnSearch = new JButton("Buscar");
        panel2.add(this.btnSearch);
        btnSearch.setBounds(5, 105, 10, 20);

        ClickEvent clickEvent = new ClickEvent(this);
        this.btnSearch.addActionListener(clickEvent);

        this.btnAdd = new JButton("Añadir");
        panel2.add(this.getBtnAdd());
        btnAdd.setBounds(35, 105, 10, 20);
        this.getBtnAdd().addActionListener(clickEvent);

        this.btnDelete = new JButton("Remover");
        panel2.add(this.getBtnDelete());
        btnDelete.setBounds(65, 105, 10, 20);
        this.getBtnDelete().addActionListener(clickEvent);

        this.btnUpdate = new JButton("Actualizar");
        panel2.add(this.getBtnUpdate());
        btnUpdate.setBounds(95, 105, 10, 20);
        this.getBtnUpdate().addActionListener(clickEvent);
    }

    private void componentesPanel3() {

        ResultsPanel resultsPanel = new ResultsPanel();
        this.tblResults = resultsPanel.getTblResults();
        InitialData initialData = new InitialData();
        // Complete List of users at first screenload
        this.setTblResults(initialData.getUsers());
        jspPane = new JScrollPane(this.tblResults);
        panel3.add(jspPane, BorderLayout.CENTER);
        jspPane.setBackground(Color.LIGHT_GRAY);
        jspPane.setPreferredSize(new Dimension(700, 255));
    }

    // Getters
    public JLabel getLblAlias() {
        return lblAlias;
    }

    public JLabel getLblNombres() {
        return lblNombres;
    }

    public JTextField getTxtNombres() {
        return txtNombres;
    }

    public JLabel getLblApellidos() {
        return lblApellidos;
    }

    public JTextField getTxtApellidos() {
        return txtApellidos;
    }

    public JLabel getLblEmail() {
        return lblEmail;
    }

    public JTextField getTxtEmail() {
        return txtEmail;
    }

    public JLabel getLblCelular() {
        return lblCelular;
    }

    public JTextField getTxtCelular() {
        return txtCelular;
    }

    /*
    public JLabel getLblClave() {
        return lblClave;
    }

    public JTextField getTxtClave() {
        return txtClave;
    }
    */

    public JLabel getLblFecha() {
        return lblFecha;
    }

    public JTextField getTxtFecha() {
        return txtFecha;
    }

    public JButton getBtnSearch() {
        return btnSearch;
    }

    public JButton getBtnAdd() {
        return btnAdd;
    }

    public JButton getBtnUpdate() {
        return btnUpdate;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public JTable getTblResults() {
        return tblResults;
    }

    public JTextField getTxtAlias() {
        return txtAlias;
    }

    // Setters
    public void setLblAlias(JLabel lblAlias) {
        this.lblAlias = lblAlias;
    }

    public void setTxtAlias(JTextField txtAlias) {
        this.txtAlias = txtAlias;
    }

    public void setLblNombres(JLabel lblNombres) {
        this.lblNombres = lblNombres;
    }

    public void setTxtNombres(JTextField txtNombres) {
        this.txtNombres = txtNombres;
    }

    public void setLblApellidos(JLabel lblApellidos) {
        this.lblApellidos = lblApellidos;
    }

    public void setTxtApellidos(JTextField txtApellidos) {
        this.txtApellidos = txtApellidos;
    }

    public void setLblEmail(JLabel lblEmail) {
        this.lblEmail = lblEmail;
    }

    public void setTxtEmail(JTextField txtEmail) {
        this.txtEmail = txtEmail;
    }

    public void setLblCelular(JLabel lblCelular) {
        this.lblCelular = lblCelular;
    }

    public void setTxtCelular(JTextField txtCelular) {
        this.txtCelular = txtCelular;
    }

    /*
    public void setLblClave(JLabel lblClave) {
        this.lblClave = lblClave;
    }

    public void setTxtClave(JTextField txtClave) {
        this.txtClave = txtClave;
    }
    */

    public void setLblFecha(JLabel lblFecha) {
        this.lblFecha = lblFecha;
    }

    public void setTxtFecha(JTextField txtFecha) {
        this.txtFecha = txtFecha;
    }

    public void setBtnSearch(JButton btnSearch) {
        this.btnSearch = btnSearch;
    }

    public void setBtnAdd(JButton btnAdd) {
        this.btnAdd = btnAdd;
    }

    public void setBtnUpdate(JButton btnUpdate) {
        this.btnUpdate = btnUpdate;
    }

    public void setBtnDelete(JButton btnDelete) {
        this.btnDelete = btnDelete;
    }

    public void setTblResults(JTable tblResults) {
        this.tblResults = tblResults;
    }

    /**
     * @param users
     */
    // To display the table by row
    public void setTblResults(ArrayList<UserModel> users) {
        String[] headers = {"Alias", "Nombre", "Apellido", "Email", "Celular", "Fecha"};
        this.tblResults.removeAll();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(headers);
        this.tblResults.setModel(tableModel);
        for (int i = 0; i < users.size(); i++) {
            tableModel.addRow(users.get(i).toArray());
        }
    }
}
