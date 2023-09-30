import java.io.*;
import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);

        String S=sc.next();
        int[] Arr=new int[26];     //알파벳처음나타난위치저장할배열
        Arrays.fill(Arr,-1);   //배열 모두 -1로 초기화

        for(int i=0;i<S.length();i++){
            //아스키코드이용
            //처음나타난위치만 기록하도록 배열은 한번만 수정가능, 즉 -1일때만 수정
            if(Arr[(int)S.charAt(i)-97]==-1){
                Arr[(int)S.charAt(i)-97]=i;
            }
        }
        for(int i=0;i<26;i++){
            System.out.print(Arr[i]+" ");
        }
    }
}
