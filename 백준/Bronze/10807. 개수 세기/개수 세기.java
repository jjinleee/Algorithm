import java.io.*;
import java.util.ArrayList;
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
        int v=sc.nextInt();
        int count=0;
        for(int k=0;k<N;k++){
            if(a[k]==v) count++;
        }

        System.out.println(count);
       sc.close();
    }
}
