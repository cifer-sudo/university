import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
public class AuthentificationImpl extends UnicastRemoteObject implements IAuthentification{
    private static final long serialVersionUID = 1L;
    private HashMap<String, String> utilisateurs;

    public AuthentificationImpl() throws RemoteException {
        super();
        utilisateurs = new HashMap<String, String>();
    }

    public boolean authentifier(Utilisateur utilisateur) throws RemoteException {
        if (utilisateurs.containsKey(utilisateur.id)) {
            String motDePasseAttendu = utilisateurs.get(utilisateur.id);
            return motDePasseAttendu.equals(utilisateur.pass);
        } else {
            utilisateurs.put(utilisateur.id, utilisateur.pass);
            return true;
        }
    }
}