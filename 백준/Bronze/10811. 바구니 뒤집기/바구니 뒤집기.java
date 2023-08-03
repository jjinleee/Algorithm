import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> bag=new ArrayList<>();

        int N=sc.nextInt();         //바구니갯수
        int M= sc.nextInt();        //역순횟수

        //바구니번호 지정
        for(int i=1;i<=N;i++){
            bag.add(i);
        }
        //번호 역순으로 바꾸기
        for(int k=1;k<=M;k++){
            int i= sc.nextInt();
            int j= sc.nextInt();

            List<Integer> temp=bag.subList(i-1,j);
            Collections.reverse(temp);
        }
        for(int i=0;i<N;i++){
            System.out.print(bag.get(i)+" ");
        }

    }
}
