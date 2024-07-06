import java.io.*;
import java.util.*;


public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader((System.in)));
        
        long n=Integer.parseInt(br.readLine());          

        long result=4*n;
        System.out.println(result);
    }

}
