import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        //입력받기 
        int N=Integer.parseInt(br.readLine());
        //상의와 하의가 서로 다른 색상인 조합
        if(N==1) System.out.println("0");
        else System.out.println(N*(N-1));
    }
}