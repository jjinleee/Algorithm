import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        boolean[] check=new boolean[10001];

        for(int i=1;i<=10000;i++){
            int n=isSelfNumber(i);
            if(n<10001) check[n]=true;
        }

        for(int i=1;i<=10000;i++){
            if(!check[i]) System.out.println(i);
        }

    }
    private static int isSelfNumber(int n){
        int sum=n;
        while(n!=0){
            sum+=n%10;
            n/=10;
        }

        return sum;
    }
}