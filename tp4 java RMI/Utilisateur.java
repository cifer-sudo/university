import java.io.Serializable;

public class Utilisateur implements Serializable {
    private static final long serialVersionUID = 1L;
    public String id;
    public String pass;

    public Utilisateur(String id, String pass) {
        this.id = id;
        this.pass = pass;
    }
}
