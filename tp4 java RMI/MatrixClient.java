import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.rmi.Naming;
public class MatrixClient{

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
try {
    IAuthentification authentification = (IAuthentification) Naming.lookup("rmi://localhost/authentification");
    System.out.print("Identifiant : ");
    String identifiant = scan.nextLine();
    System.out.print("Mot de passe : ");
    String motDePasse = scan.nextLine();
    Utilisateur utilisateur = new Utilisateur(identifiant, motDePasse);
    if (authentification.authentifier(utilisateur)) {
        System.out.println("Authentification reussie ");
    } else {
        System.out.println("Identifiant ou mot de passe incorrect ");
    }


    
    MatrixInterface matrix=(MatrixInterface)Naming.lookup("rmi://localhost:1099/BK");
    System.out.println("Saisissez les dimensions de la premiere matrice :");
        System.out.print("Nombre de lignes : ");
        int rows1 = scan.nextInt();
        System.out.print("Nombre de colonnes : ");
        int cols1 = scan.nextInt();

        // Saisie des éléments de la première matrice
        double[][] matrix1 = new double[rows1][cols1];
        System.out.println("Saisissez les éléments de la premiere matrice :");
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols1; j++) {
                matrix1[i][j] = scan.nextDouble();
            }
        }
        // Saisie des dimensions de la deuxième matrice
        System.out.println("Saisissez les dimensions de la deuxieme matrice :");
        System.out.print("Nombre de lignes : ");
        int rows2 = scan.nextInt();
        System.out.print("Nombre de colonnes : ");
        int cols2 = scan.nextInt();

        // Saisie des éléments de la deuxième matrice
        double[][] matrix2 = new double[rows2][cols2];
        System.out.println("Saisissez les elements de la deuxieme matrice :");
        for (int i = 0; i < rows2; i++) {
            for (int j = 0; j < cols2; j++) {
                matrix2[i][j] = scan.nextDouble();
            }
        }

        // Affichage des matrices saisies
        System.out.println("Matrice 1 :");
        printMatrix(matrix1);
        
        System.out.println("Matrice 2 :");
        printMatrix(matrix2);
        

        System.out.print("click sur 1 pour addition,click sur 2 pour la soustraction,click sur 3 pour la multiplication,click sur 4 pour la transpose:");

        int choice=scan.nextInt();
        if(choice==1){
            double[][] sum = matrix.add(matrix1, matrix2);
            System.out.println("Somme des deux matrices :");
        printMatrix(sum);
        }else if(choice==2){
            double[][] diff = matrix.subtract(matrix1, matrix2);
            System.out.println("Difference des deux matrices :");
        printMatrix(diff);
        }else if(choice==3){
            double[][] prod = matrix.multiply(matrix1, matrix2);
            System.out.println("Produit des deux matrices :");
            printMatrix(prod);
        }else if(choice==4){
            double[][] transposed = matrix.transpose(matrix1);
             System.out.println("Transposee de la premiere matrice :");
            printMatrix(transposed);
        }
} catch (Exception e) {
    System.err.println("Client exception: " + e.getMessage());
}
    }
    public static void printMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
