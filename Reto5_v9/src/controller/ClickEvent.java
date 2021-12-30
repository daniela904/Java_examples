package controller;

import access.UserDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.UserModel;
import view.ControlsPanel;

/**
 *
 * @author AstridM & DanielaM
 */
public class ClickEvent implements ActionListener {

    private ControlsPanel controlsPanel;

    /**
     * Constructor of the class
     *
     * @param controlsPanel
     */
    public ClickEvent(ControlsPanel controlsPanel) {
        this.controlsPanel = controlsPanel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == this.controlsPanel.getBtnSearch()) {
            String alias = (String) this.controlsPanel.getTxtAlias().getText();
            String nombre = (String) this.controlsPanel.getTxtNombres().getText();
            String apellido = (String) this.controlsPanel.getTxtApellidos().getText();
            String email = (String) this.controlsPanel.getTxtEmail().getText();
            String celular = (String) this.controlsPanel.getTxtCelular().getText();
            String fecha = (String) this.controlsPanel.getTxtFecha().getText();

            UserDAO userDAO = new UserDAO();
            ArrayList<UserModel> users = userDAO.getFilteredUsers(alias, nombre, apellido, email, celular, fecha);

            this.controlsPanel.setTblResults(users);
        }

        if (actionEvent.getSource() == this.controlsPanel.getBtnAdd()) {

            String alias = (String) this.controlsPanel.getTxtAlias().getText();
            String nombre = (String) this.controlsPanel.getTxtNombres().getText();
            String apellido = (String) this.controlsPanel.getTxtApellidos().getText();
            String email = (String) this.controlsPanel.getTxtEmail().getText();
            String celular = (String) this.controlsPanel.getTxtCelular().getText();
            String fecha = (String) this.controlsPanel.getTxtFecha().getText();
                        
            if (alias.isEmpty() && nombre.isEmpty() && apellido.isEmpty() && email.isEmpty() && celular.isEmpty() && fecha.isEmpty()){
                JOptionPane.showMessageDialog(null, "Error " 
                    + "\nLos campos están vacíos");                
            }
            else{
                UserDAO userDAO = new UserDAO();
                userDAO.insertUsers(alias, nombre, apellido, email, celular, fecha);                
            }
        }

        if (actionEvent.getSource() == this.controlsPanel.getBtnDelete()) {

            String alias = (String) this.controlsPanel.getTxtAlias().getText();

            UserDAO userDAO = new UserDAO();
            userDAO.deleteUsers(alias);

        }

        if (actionEvent.getSource() == this.controlsPanel.getBtnUpdate()) {

            String alias = (String) this.controlsPanel.getTxtAlias().getText();
            String nombre = (String) this.controlsPanel.getTxtNombres().getText();
            String apellido = (String) this.controlsPanel.getTxtApellidos().getText();
            String email = (String) this.controlsPanel.getTxtEmail().getText();
            String celular = (String) this.controlsPanel.getTxtCelular().getText();
            String fecha = (String) this.controlsPanel.getTxtFecha().getText();
            
            if (alias.isEmpty()){
                JOptionPane.showMessageDialog(null, "Error " 
                    + "\nEl campo 'alias' está vacío");                
            }
            else{
                UserDAO userDAO = new UserDAO();
                userDAO.updateUsers(alias, nombre, apellido, email, celular, fecha);            
            }            
        }

    }
}
