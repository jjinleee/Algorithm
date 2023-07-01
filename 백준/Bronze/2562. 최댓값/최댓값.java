import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        ArrayList<Integer> a=new ArrayList<>();

        int i=0;
        while(i<9){
            a.add(sc.nextInt());
            i++;
        }

        int max=0;
        for(int n : a){
            if(max<n){
                max=n;
            }
        }

        System.out.println(max);
        System.out.println(a.indexOf(max)+1);

       sc.close();
    }
}
