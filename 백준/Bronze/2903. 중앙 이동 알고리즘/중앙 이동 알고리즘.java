import java.io.*;
import java.util.*;


public class Main{
    public static void main(String[] args) throws IOException {
       Scanner sc=new Scanner(System.in);

       int n=sc.nextInt();
        double dot=Math.pow((Math.pow(2, n)+1),2);
        int result=(int)dot;

        System.out.println(result);

    }
}
