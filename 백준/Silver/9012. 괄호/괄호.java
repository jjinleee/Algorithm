import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        

        int t=Integer.parseInt(br.readLine());
        String[] answer=new String[t];

        for(int i=0;i<t;i++){
            String s=br.readLine();
            if(isVPS(s)) answer[i]="YES";
            else answer[i]="NO";
        }

        for(String a:answer){
            System.out.println(a);
        }
    }

    public static boolean isVPS(String t){
        Stack<Character> data=new Stack<>();
        for(int i=0;i<t.length();i++){{
            if(t.charAt(i)=='(') data.push('(');
            else {
                if(data.isEmpty()) return false;
                data.pop();
            }
        }}
        if(data.isEmpty()) return true;
        else return false;
    }
}