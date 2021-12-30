/* Application to allow Online-Bank's "usuario" table CRUD management
    through a GUI specially designed for end-user purposes. 
   Major CRUD operations are:
    - Create: Use "Añadir" button 
    - Read: Use "Buscar" button
    - Update: Use "Actualizar" button
    - Delete: Use "Remover" button
   All those operations can be parameterized using the following
     text fields:
    - Alias: Given alias name
    - Nombre: User name
    - Apellido: User lastname
    - Email: User email
    - Celular: User contact number
    - Fecha: User birth date
    Note: the table field "password" is not visible nor parameterizable 
     through this GUI. When a new user is added, this field takes
     a default value. 
 */
package view;

// Top level container for Swing 
import javax.swing.JFrame;
// To containerize components in panels
import javax.swing.JPanel;
// To lay out container components in north-sotuh-est-west-center regions
import java.awt.BorderLayout;
// Provides an empty, transparent border which takes up space but does no drawing.
import javax.swing.border.EmptyBorder;

/**
 *
 * @author AstridM & DanielaM
 */
public class MainWindow extends JFrame {

    //JPanel container
    private JPanel contentPane;

    public static void main(String[] args) {
        try {
            //New JPanel main window
            new MainWindow().setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Main window 
    public MainWindow() {
        setTitle("Gestión de Usuarios");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Moves and resizes this component. The new location of the top-left corner 
        // is specified by x and y, and the new size is specified by width and height.
        setBounds(100, 100, 735, 550);
        // Make the container use no layout manager. It instead takes the size and
        // position of specified for every component with setBounds
        setLayout(null);
        // The main window is placed in the center of the screen
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        // Creates an empty border with the specified insets. Sets a margin of 5
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        // Constructs a new border layout with no gaps between components.
        contentPane.setLayout(new BorderLayout(0, 0));
        // Sets the contentPane JPanel inside JFrame container
        setContentPane(contentPane);
        // Adds a new panel to contentPane. Done to avoid using GridLayout 
        contentPane.add(new ControlsPanel(contentPane));
    }
}
