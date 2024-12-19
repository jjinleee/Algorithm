import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        

        String s=br.readLine();
        int n=s.length();
        //문자열이 0~i-1까지 몇번 등장했는지
        int[][] cnt=new int[26][n+1];

        for(int i=0;i<n;i++){
            for(int j=0;j<26;j++){
                cnt[j][i+1]=cnt[j][i];
            }
            cnt[s.charAt(i)-'a'][i+1]++;
        }
        int q=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<q;i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            char c=st.nextToken().charAt(0);
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());

            int result=cnt[c-'a'][end+1]-cnt[c-'a'][start];
            sb.append(result+"\n");
        }
        

        System.out.println(sb);
    }
}