import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder sb= new StringBuilder();
        while(true){
            String s= br.readLine();
            if(s.equals(".")) break;
            boolean isValid=true;

            Stack<Character> stack=new Stack<>();
            for(char c : s.toCharArray()){
                if(c=='(') stack.push('(');
                else if(c==')'){
                    if(!stack.isEmpty() && stack.peek()=='('){
                        stack.pop();
                    } else{
                        isValid=false;
                        break;
                    }
                } else if(c=='['){
                    stack.push('[');
                } else if(c==']'){
                    if(!stack.isEmpty() && stack.peek()=='[' ){
                        stack.pop();
                    } else{
                        isValid=false;
                        break;
                    }
                }
            }
            if(!stack.isEmpty() || !isValid) sb.append("no").append('\n');
            else sb.append("yes").append('\n');

        }

        System.out.println(sb.toString());

    }
}