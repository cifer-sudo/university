import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class MatrixInterfaceImpl extends UnicastRemoteObject implements MatrixInterface{
    public MatrixInterfaceImpl() throws RemoteException{
        super();
    }
    
    
    @Override
    // Méthode pour l'addition de deux matrices
    public  double[][] add(double[][] matrix1, double[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        double[][] sum = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return sum;
    }
    @Override
    // Méthode pour la soustraction de deux matrices
    public  double[][] subtract(double[][] matrix1, double[][] matrix2) {
        int rows = matrix1.length;
        int columns = matrix1[0].length;
        double[][] diff = new double[rows][columns];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                diff[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        
        return diff;
    }
    @Override
    //la mehode qui permet de faire la multiplication
public  double[][] multiply(double[][] matrix1, double[][] matrix2) {
    int m1rows = matrix1.length;
    int m1cols = matrix1[0].length;
    int m2rows = matrix2.length;
    int m2cols = matrix2[0].length;

    if (m1cols != m2rows) {
        throw new IllegalArgumentException("Matrix dimensions do not match for multiplication");
    }

    double[][] prod = new double[m1rows][m2cols];

    for (int i = 0; i < m1rows; i++) {
        for (int j = 0; j < m2cols; j++) {
            for (int k = 0; k < m1cols; k++) {
                prod[i][j] += matrix1[i][k] * matrix2[k][j];
            }
        }
    }

    return prod;
}
@Override
//la methode qui permet transpose
public  double[][] transpose(double[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;

    double[][] transposed = new double[n][m];

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            transposed[j][i] = matrix[i][j];
        }
    }

    return transposed;
}
}
