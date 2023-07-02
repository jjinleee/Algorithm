import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();
        int M= sc.nextInt();
        int[] box=new int[N];

        //바구니와 같은 공 번호로 초기화
        for(int i=0;i<N;i++){
            box[i]=i+1;
        }
        //M번 반복
        for(int a=0;a<M;a++){
            int i=sc.nextInt();
            int j=sc.nextInt();

            //공변경(근데 인덱스 신경써야함! 박스번호=인덱스+1)
            int temp=box[i-1];
            box[i-1]=box[j-1];
            box[j-1]=temp;
            
        }

        for(int i=0;i<N;i++){
            System.out.print(box[i]+" ");
        }
    }
}
