import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s= br.readLine();

        //대소문자 구분없게하기위해
        int[] arr=new int[26];

        for(int i=0;i<s.length();i++){
            //소문자일때
            if('a'<=s.charAt(i)&&s.charAt(i)<='z'){
                arr[s.charAt(i)-97]++;
            } else{  //대문자일때
                arr[s.charAt(i)-65]++;
            }
        }

        int max=0;
        char maxChar='?';

        for(int i=0;i<26;i++){
            if(arr[i]>max){
                max=arr[i];
                maxChar=(char)(i+65);
            }

            //같으면 ?출력
            else if(arr[i]==max){
                maxChar='?';
            }
        }
        System.out.println(maxChar);
    }
}
