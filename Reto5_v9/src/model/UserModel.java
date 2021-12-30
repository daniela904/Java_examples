package model;

/**
 *
 * @author AstridM & DanielaM
 */
public class UserModel {

    private String usrAlias;
    private String usrNombres;
    private String usrApellidos;
    private String usrEmail;
    private long usrCelular;
    private String usrClave;
    private String usrFechaNto;

    /**
     *
     * @param usrAlias
     * @param usrNombres
     * @param usrApellidos
     * @param usrEmail
     * @param usrCelular
     * @param usrFechaNto
     */
    public UserModel(String usrAlias, String usrNombres, String usrApellidos, String usrEmail, long usrCelular, String usrFechaNto) {
        this.usrAlias = usrAlias;
        this.usrNombres = usrNombres;
        this.usrApellidos = usrApellidos;
        this.usrEmail = usrEmail;
        this.usrCelular = usrCelular;
        this.usrFechaNto = usrFechaNto;
    }

    public String getUsrAlias() {
        return usrAlias;
    }

    public void setUsrAlias(String usrAlias) {
        this.usrAlias = usrAlias;
    }

    public String getUsrNombres() {
        return usrNombres;
    }

    public void setUsrNombres(String usrNombres) {
        this.usrNombres = usrNombres;
    }

    public String getUsrApellidos() {
        return usrApellidos;
    }

    public void setUsrApellidos(String usrApellidos) {
        this.usrApellidos = usrApellidos;
    }

    public String getUsrEmail() {
        return usrEmail;
    }

    public void setUsrEmail(String usrEmail) {
        this.usrEmail = usrEmail;
    }

    public long getUsrCelular() {
        return usrCelular;
    }

    public void setUsrCelular(int usrCelular) {
        this.usrCelular = usrCelular;
    }

    public String getUsrFechaNto() {
        return usrFechaNto;
    }

    public void setUsrFechaNto(String usrFechaNto) {
        this.usrFechaNto = usrFechaNto;
    }

    public String getUsrClave() {
        return usrClave;
    }

    public void setUsrClave(String usrClave) {
        this.usrClave = usrClave;
    }

    public Object[] toArray() {
        Object[] data = {usrAlias, usrNombres, usrApellidos, usrEmail, usrCelular, usrFechaNto};
        return data;
    }

}
