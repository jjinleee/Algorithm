import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();

        while(true){
            String s=br.readLine();
            if(s==null) break;
            int n=Integer.parseInt(s);
            int size=(int) Math.pow(3, n);

            char[] chars= new char[size];

            for(int i=0;i<size;i++){
                chars[i]='-';
            }

            cant(chars,0,size);
            sb.append(chars).append('\n');
        }
        System.out.println(sb);

    }

    public static void cant(char[] canto, int start, int size){
        if(size==1) return;

        int div=size/3;

        //중간 3등분 후 중간 삭제
        for(int i=start+div;i<start+2*div;i++){
            canto[i]=' ';
        }

        //좌우
        cant(canto,start,div);
        cant(canto,start+2*div,div);
    }
}