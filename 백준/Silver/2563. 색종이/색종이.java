import java.io.*;
import java.util.*;


public class Main{
    public static void main(String[] args) throws IOException {
       Scanner sc=new Scanner(System.in);
       int answer=0;

       int n=sc.nextInt();
        boolean area[][]=new boolean[100][100];

       for(int i=0;i<n;i++){
            int x=sc.nextInt();
            int y=sc.nextInt();
            for(int j=x;j<x+10;j++){
                for(int k=y;k<y+10;k++){
                    area[j][k]=true;
                }
            }
       }

       for(int i=0;i<100;i++){
            for(int j=0;j<100;j++){
                if(area[i][j]==true)
                 answer++;
            }
       }
       System.out.println(answer);

    }
}
