import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //과목의 개수
        int N= sc.nextInt();
        //개수만큼 배열 생성
        int[] score=new int[N];

        for(int i=0;i<N;i++){
            score[i]=sc.nextInt();
        }
        //최고점찾기
        int max=0;
        for(int i=0;i<N;i++){
            if(max<score[i]) max=score[i];
        }

        //새로운평균 구하기
        double avg=0;
        double sum=0;
        for(int i=0;i<N;i++){
           sum+=  (double)score[i]/(double)max*100;
        }

        avg=sum/N;
        System.out.println(avg);
    }
}
