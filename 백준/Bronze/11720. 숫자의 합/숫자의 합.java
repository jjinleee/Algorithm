import java.io.*;
import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);

        int sum=0;

        int N=Integer.parseInt(sc.next());
        String[] Array=new String[N];
        Array=sc.next().split("");

        for(int i=0;i<N;i++){
            sum+=Integer.parseInt(Array[i]);
            //System.out.println(Array[i]);
        }
       System.out.println(sum);

    }
}
