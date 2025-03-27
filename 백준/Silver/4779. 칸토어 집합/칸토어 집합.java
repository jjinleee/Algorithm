import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String line;

        while((line=br.readLine())!=null){
            int n=Integer.parseInt(line);
            int length=(int)Math.pow(3, n);
            char[] arr= new char[length];

            Arrays.fill(arr, '-');
            cantor(arr,0,length);

            System.out.println(new String(arr));
        }
    }

    //3등분해서 중간 없애기 
     static void cantor(char[] c,int start, int length){
        if(length<3) return;
        
        int div= length/3;
        for(int i=start+div;i<start+2*div;i++){
            c[i]=' ';
        }

        cantor(c, start, div);
        cantor(c, start+2*div, div);
    } 
}