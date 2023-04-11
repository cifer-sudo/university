import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MatrixInterface extends Remote{

    
    double[][] add(double[][] matrix1, double[][] matrix2) throws RemoteException;
    double[][] subtract(double[][] matrix1, double[][] matrix2) throws RemoteException;
    double[][] multiply(double[][] matrix1, double[][] matrix2) throws RemoteException;
    double[][] transpose(double[][] matrix) throws RemoteException;
}



