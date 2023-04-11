import java.rmi.Remote;
import java.rmi.RemoteException;
public interface IAuthentification  extends Remote{
    public boolean authentifier(Utilisateur utilisateur) throws RemoteException;
}