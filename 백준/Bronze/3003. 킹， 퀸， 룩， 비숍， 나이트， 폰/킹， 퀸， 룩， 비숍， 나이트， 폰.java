import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        // //byte 스트림->문자 스트림->버퍼 스트림
        // BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        // // String str=br.readLine();

        // int[] get=Integer.parseInt(br.readLine().split("null"));
        // String[] origin=[]
        
        // br.close();
        Scanner sc=new Scanner(System.in);
        int[] get=new int[6];
        int[] origin={1,1,2,2,2,8};
        int[] need=new int[6];

        for(int i=0;i<6;i++){
            get[i]=sc.nextInt();
            need[i]=origin[i]-get[i];
        }

        for(int i=0;i<6;i++){
            System.out.print(need[i]+" ");
        }
    
    }
}