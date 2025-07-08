import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        int cnt=0;
        for(int i=0;i<n;i++){
            String s=br.readLine();
            if(isGroup(s)) cnt++;
        }
        System.out.println(cnt);
        
    }
    static boolean isGroup(String word){
        char prev=word.charAt(0);
        boolean[] alpa=new boolean[26];
        alpa[prev-'a']=true;

        for(int i=1;i<word.length();i++){
            char c= word.charAt(i);
            if(c!=prev){
                if(alpa[c-'a']==true) return false;
            }
            alpa[c-'a']=true;
            prev=c;
        }

        return true;
    }
}