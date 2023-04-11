import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class MatrixServer{




    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);



            IAuthentification authentification = new AuthentificationImpl();
            Naming.rebind("authentification", authentification);


            
             MatrixInterfaceImpl matrix=new MatrixInterfaceImpl();
             System.out.println(matrix.toString());
             Naming.rebind("rmi://localhost:1099/BK",matrix);
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println("Server exception: " + e.getMessage());
        }
    }
}