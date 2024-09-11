import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> result=new ArrayList<>();

        while(true){
            String s=br.readLine();
            if(s.equals(".")) break;

            if(isBalance(s)) result.add("yes");
            else result.add("no");

        }

        for(String r:result){
            System.out.println(r);
        }
    }

    public static boolean isBalance(String t){
        Stack<Character> data=new Stack<>();
        for(int i=0;i<t.length();i++){{
            char ch = t.charAt(i);

            if (ch == '(') {
                data.push('(');
            } else if (ch == '[') {
                data.push('[');
            } else if (ch == ')') {
                if (data.isEmpty() || data.peek() != '(') {
                    return false;
                }
                data.pop();
            } else if (ch == ']') {
                if (data.isEmpty() || data.peek() != '[') {
                    return false;
                }
                data.pop();
            }
        }}

        return data.isEmpty();
    }
}