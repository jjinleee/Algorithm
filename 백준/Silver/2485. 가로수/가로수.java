import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());
        int[] tree=new int[n];
        int[] between=new int[n-1];

        //입력받고 사이 거리 구하기
        for(int i=0;i<n;i++){
            tree[i]=Integer.parseInt(br.readLine());   
        }
        for(int j=0;j<n-1;j++){
            between[j]=tree[j+1]-tree[j];
        }

        //간격의 최대공약수를 찾아야함(중복삭제 필요)
        int gcd=between[0];
        for(int i=1;i<n-1;i++){
            gcd=gcd(gcd,between[i]);
        }


        int newTree=0;     //삼어야하는 가로수의 수

        for(int bet:between){
            newTree+=(bet / gcd) -1;
        }
        System.out.println(newTree);



    }

    //최대공약수 찾는 함수
    public static int gcd(int x,int y){
        while(y!=0){
            int temp=y;
            y=x%y;
            x=temp;
        }
        return x;
    }
}