package controller;

import access.UserDAO;
import java.util.ArrayList;
import model.UserModel;

/**
 *
 * @author AstridM & DanielaM
 */
public class InitialData {

    private ArrayList<UserModel> users = null;

    /**
     * Zero-parameters constructor
     */
    public InitialData() {
        UserDAO userDAO = new UserDAO();
        this.users = userDAO.getAllUsers();
    }

    /**
     * @return the Users
     */
    public ArrayList<UserModel> getUsers() {
        return users;
    }

}
