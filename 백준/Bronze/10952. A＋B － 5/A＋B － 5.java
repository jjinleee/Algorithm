import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<Integer> sum=new ArrayList<>();

        while(true){
            int A=sc.nextInt();
            int B=sc.nextInt();
            if(A==0 & B==0) break;
            sum.add(A+B);
        }
        for(int k=0;k<sum.size();k++){
            System.out.println(sum.get(k));
        }
    }
}
