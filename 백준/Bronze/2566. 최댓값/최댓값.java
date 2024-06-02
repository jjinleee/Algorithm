import java.io.*;
import java.util.*;


public class Main{
    public static void main(String[] args) throws IOException {
       Scanner sc=new Scanner(System.in);
       
       int max=0;
       int location[]=new int[2];

        int arr[][]=new int[9][9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                arr[i][j]=sc.nextInt();
                if(arr[i][j]>=max) {
                    max=arr[i][j];
                    location[0]=i+1;
                    location[1]=j+1;
                }
            }
        }
        sc.close();

        System.out.println(max);
        System.out.print(location[0]+" "+location[1]);
       
    }
}
