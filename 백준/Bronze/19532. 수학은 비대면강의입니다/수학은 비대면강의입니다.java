import java.io.*;
import java.util.*;


public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader((System.in)));
        String[] arr=br.readLine().split(" ");

        int x=0;
        int y=0;

        int a=Integer.parseInt(arr[0]);
        int b=Integer.parseInt(arr[1]);
        int c=Integer.parseInt(arr[2]);
        int d=Integer.parseInt(arr[3]);
        int e=Integer.parseInt(arr[4]);
        int f=Integer.parseInt(arr[5]);

        for(int i=-999;i<1000;i++){
            for(int j=-999;j<1000;j++){
                if((a*i+b*j==c) && (d*i+e*j==f)){
                    x=i; 
                    y=j;
                    break;
                }
            }
        }
        System.out.println(x+" "+y);
    }
}