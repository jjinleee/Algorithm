import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int count=n;

        for(int i=0;i<n;i++){
            String s=sc.next();
            //boolean 배열 초기값=false
            boolean alpa[]=new boolean[26];

            for(int j=0;j<s.length()-1;j++){
                if(s.charAt(j)!=s.charAt(j+1)){
                    if(alpa[s.charAt(j+1)-97]==true){
                        count--;
                        break;
                    }
                }
                alpa[s.charAt(j)-97]=true;
            }
        }

        System.out.println(count);
    }
}
