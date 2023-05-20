import java.io.*;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        int[] sum = new int[T];

        for(int i=0;i<T;i++){
            sum[i]=sc.nextInt()+sc.nextInt();
        }
        for(int i=0;i<T;i++){
            System.out.println("Case #"+(i+1)+": "+sum[i]);
        }

    }
}
