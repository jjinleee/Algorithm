import java.io.*;
import java.util.*;


public class Main { 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s= br.readLine();
        String del=br.readLine();
        StringBuilder sb= new StringBuilder(); //sb를 stack처럼 사용

        //입력받으면서 sb에 추가
        for(int i=0;i<s.length();i++){
            sb.append(s.charAt(i));

            //sb길이가 del문자열 길이랑 같아지면 검사
            if(sb.length()>=del.length()){
                boolean explode=true;
                //del문자열인지 검사, 아니면 break
                for(int j=0;j<del.length();j++){
                    if(sb.charAt(sb.length()-del.length()+j)!=del.charAt(j)){
                        explode=false;
                        break;
                    }
                }
                //true면 del 문자열길이만큼 삭제함
                if(explode){
                    sb.delete(sb.length()-del.length(), sb.length());
                }
            }
        }

        if(sb.length()==0) System.out.println("FRULA");
        else System.out.println(sb.toString());
        
    }
}