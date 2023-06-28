import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();
        int X=sc.nextInt();

        int[] a=new int[N];
        int i=0;
        while(i<N){
            a[i]= sc.nextInt();
            i++;
        }

        for(int k=0;k<N;k++){
            if(a[k]<X) System.out.print(a[k]+" ");
        }
        
       sc.close();
    }
}
