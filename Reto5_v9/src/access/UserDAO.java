package access;

/**
 *
 * @author AstridM & DanielaM
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import model.UserModel;
import utils.ConnectionDB;

public class UserDAO {

    private Connection conn = null;

    /**
     *
     * @return
     */
    public ArrayList<UserModel> getAllUsers() {
        ArrayList<UserModel> users = new ArrayList();
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }

            String sql = "SELECT usr_alias, usr_nombres, usr_apellidos, usr_email, usr_celular, usr_fecha_nto \n"
                    + "FROM reto4_online_bank.usuario\n"
                    + "ORDER BY usr_nombres;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                UserModel user = new UserModel(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getLong(5), result.getString(6));
                users.add(user);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return users;
    }

    public ArrayList<UserModel> getFilteredUsers(String user_alias, String user_name, String user_lastname, String user_email, String user_celular, String user_fechanto) {
        ArrayList<UserModel> users = new ArrayList();

        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }

            String sql = "SELECT usr_alias, usr_nombres, usr_apellidos,usr_email, usr_celular, usr_fecha_nto \n"
                    + "FROM reto4_online_bank.usuario \n"
                    + "WHERE usr_alias LIKE ? \n"
                    + "AND usr_nombres LIKE ? \n"
                    + "AND usr_apellidos LIKE ? \n"
                    + "AND usr_email LIKE ? \n"
                    + "AND usr_celular LIKE ? \n"
                    + "AND usr_fecha_nto LIKE ? \n";

            PreparedStatement statement = conn.prepareStatement(sql);
            System.out.println(sql);
            statement.setString(1, "%" + user_alias + "%");
            statement.setString(2, "%" + user_name + "%");
            statement.setString(3, "%" + user_lastname + "%");
            statement.setString(4, "%" + user_email + "%");
            statement.setString(5, "%" + user_celular + "%");
            statement.setString(6, "%" + user_fechanto + "%");

            System.out.println(statement.toString());
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                UserModel user = new UserModel(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getLong(5), result.getString(6));
                users.add(user);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return users;
    }

    public void insertUsers(String user_alias, String user_name, String user_lastname, String user_email, String user_celular, String user_fechanto) {
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }

            String sql = "INSERT INTO usuario(usr_alias, usr_nombres, usr_apellidos, usr_email, usr_celular, usr_fecha_nto) VALUES(?, ?, ?, ?, ?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, user_alias);
            statement.setString(2, user_name);
            statement.setString(3, user_lastname);
            statement.setString(4, user_email);
            statement.setString(5, user_celular);
            statement.setString(6, user_fechanto);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Registro agregado exitosamente");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }

    public void deleteUsers(String user_alias) {
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }

            String sql = "DELETE FROM usuario WHERE usr_alias=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, user_alias);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Registro eliminado exitosamente");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }

    public void updateUsers(String user_alias, String user_name, String user_lastname, String user_email, String user_celular, String user_fechanto) {
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }

            Map<Integer, String> options = new HashMap<Integer, String>();

            String sql = "UPDATE usuario SET ";
            int option = 0;
            if (!user_name.isEmpty()) {
                if (option > 0) {
                    sql += ", ";
                }
                sql += " usr_nombres=? ";
                option += 1;
                options.put(option, user_name);
            }
            if (!user_lastname.isEmpty()) {
                if (option > 0) {
                    sql += ", ";
                }
                sql += " usr_apellidos=? ";
                option += 1;
                options.put(option, user_lastname);

            }
            if (!user_email.isEmpty()) {
                if (option > 0) {
                    sql += ", ";
                }
                sql += " usr_email=? ";
                option += 1;
                options.put(option, user_email);
            }
            if (!user_celular.isEmpty()) {
                if (option > 0) {
                    sql += ", ";
                }
                sql += " usr_celular=? ";
                option += 1;
                options.put(option, user_celular);
            }
            if (!user_fechanto.isEmpty()) {
                if (option > 0) {
                    sql += ", ";
                }
                sql += " usr_fecha_nto=? ";
                option += 1;
                options.put(option, user_fechanto);
            }

            sql += " WHERE usr_alias=?;";
            PreparedStatement statement = conn.prepareStatement(sql);

            for (Map.Entry<Integer, String> m : options.entrySet()) {
                statement.setString(m.getKey(), m.getValue());
            }

            option += 1;
            statement.setString(option, user_alias);

            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Registro actualizado exitosamente");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }
}
