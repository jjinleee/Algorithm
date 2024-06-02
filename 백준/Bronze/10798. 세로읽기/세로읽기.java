import java.io.*;
import java.util.*;

//내부 요소 길이가 다른 다차원 배열도 가능하다
//각 행마다 다른 크기의 일차원배열을 하나씩 할당하면된다
//어레이리스트로만 되나?
public class Main{
    public static void main(String[] args) throws IOException {
       Scanner sc=new Scanner(System.in);
       
       char[][] arr=new char[5][15];
       String[] temp=new String[75];
       int max=0;

       //nextLine: 공백까지 한줄입력 엡터시 종료, next:공백이면 끊어서
       for(int i=0;i<5;i++){
            String str=sc.nextLine();
            if(str.length()>max) max=str.length();
            for(int j=0;j<str.length();j++){
                arr[i][j]=str.charAt(j);
            }
            
        }
        
        for(int i=0;i<max;i++){
            for(int j=0;j<5;j++){
                if(arr[j][i]=='\0') continue;
                System.out.print(arr[j][i]);
            }
        }


    }
}
