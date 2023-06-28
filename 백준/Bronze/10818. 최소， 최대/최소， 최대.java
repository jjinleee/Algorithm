import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();

        int[] a=new int[N];
        int i=0;
        while(i<N){
            a[i]= sc.nextInt();
            i++;
        }


        Arrays.sort(a);
        System.out.print(a[0]+" "+a[N-1]);

       sc.close();
    }
}
