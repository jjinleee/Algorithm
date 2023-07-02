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

        //0으로 초기화
        for(int i=0;i<N;i++){
            box[i]=0;
        }
        //M번 반복
        for(int a=0;a<M;a++){
            int i=sc.nextInt();
            int j=sc.nextInt();
            int k=sc.nextInt();

            //공넣음, 변경되도 상관없음(0인지 아닌지 확인할필요없음)
            //근데 인덱스 신경써야함! 박스번호=인덱스+1
            for(int t=i-1;t<j;t++){
                box[t]=k;
            }
        }

        for(int i=0;i<N;i++){
            System.out.print(box[i]+" ");
        }
    }
}
