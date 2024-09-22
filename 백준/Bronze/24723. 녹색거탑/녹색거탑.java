import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        //입력받기 
        int N=Integer.parseInt(br.readLine());
        System.out.println((int)Math.pow(2,N));
        
    }
}