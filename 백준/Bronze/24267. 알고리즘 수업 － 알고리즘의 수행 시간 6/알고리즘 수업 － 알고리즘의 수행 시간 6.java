import java.io.*;
import java.util.*;


public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader((System.in)));
        String s=br.readLine();
       
        long n=Integer.parseInt(s);
        System.out.println(n*(n-1)*(n-2)/6);
        System.out.println("3");
    }

}
