import java.io.*;
import java.util.*;


public class Main{
    public static void main(String[] args) throws IOException {
       Scanner sc=new Scanner(System.in);
       int N=sc.nextInt();
       int M=sc.nextInt();
       int array[]=new int[2*N*M];
       int result[][]=new int[N][M];

    
       for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                result[i][j]=sc.nextInt();
            }
       }
       for(int i=0;i<N;i++){
        for(int j=0;j<M;j++){
            result[i][j]+=sc.nextInt();
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
       }
       
    }
}
