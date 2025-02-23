import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine().toUpperCase(); //다대문자로만들어

        int[] alpha=new int[26];
        for(char c:s.toCharArray()){
            alpha[c-'A']++;
        }

        int max=0;
        char maxChar='?';

        for(int i=0;i<26;i++){
            if(max<alpha[i]){
                max=alpha[i];
                maxChar=(char)(i+65);
            } else if(max==alpha[i]){
                maxChar='?';
            }
        }
        System.out.println(maxChar);
    }
}