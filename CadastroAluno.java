import java.util.Random;
import java.util.Scanner;

public class CadastroAluno {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("Insira o nuemro de linhas da matriz: ");
        int x = scn.nextInt();
        while ((x <= 0) || (x > 10)) {
            System.out.print("O numero deve ser maior que 0 e menor que 10: ");
            x = scn.nextInt();
        }

        System.out.print("Insira o nuemro de colunas da matriz: ");
        int y = scn.nextInt();
        while ((y <= 0) || (x > 10)) {
            System.out.print("O numero deve ser maior que 0 e menor que 10: ");
            y = scn.nextInt();
        }

        int[][] A = new int[x][y];
        
        //preenche aleatoriamente a matriz
        Random rnd = new Random();
        for (x = 0; x < A.length; x++){
            for (y = 0; y < A[x].length; y++){
                A[x][y] = rnd.nextInt(10) + 1;
            }
        }
        //imrpime a matriz
        for (x = 0; x < A.length; x++){
            System.out.println("");
            for (y = 0; y < A[x].length; y++){
               System.out.print(A[x][y] + " ");
            }
        }

        int[][] B = novaMatriz(A);
        System.out.println("");
        System.out.println("");

        //imrpime a matriz
        for (x = 0; x < B.length; x++){
            System.out.println("");
            for (y = 0; y < B[x].length; y++){
               System.out.print(B[x][y] + " ");
            }
        }
    }

    static int[][] novaMatriz(int[][] a){
        int[][] b = new int[a.length][a[0].length + 1];
        for (int x = 0; x < b.length; x++){
            int temp = 1;
            for (int y = 0; y < a[x].length; y++){
               b[x][y] = a[x][y]; 
               temp *= b[x][y];
            }
            b[x][b[x].length - 1] = temp;
        }

        return b;
    }
}