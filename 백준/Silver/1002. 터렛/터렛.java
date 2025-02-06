import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();

        int t=Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int i=0;i<t;i++){
            st=new StringTokenizer(br.readLine());            
            int x1=Integer.parseInt(st.nextToken());
            int y1=Integer.parseInt(st.nextToken());
            int r1=Integer.parseInt(st.nextToken());
            int x2=Integer.parseInt(st.nextToken());
            int y2=Integer.parseInt(st.nextToken());
            int r2=Integer.parseInt(st.nextToken());

            //무한
            if(x1==x2 && y1==y2 && r1==r2) {
                sb.append(-1).append("\n");
                continue;
            }

            double sum= Math.pow((x2-x1), 2)+Math.pow(y2-y1, 2);
            double rSum=Math.pow(r2+r1,2);
            double rSub=Math.pow(r2-r1,2);

            if(sum>rSum || sum<rSub) {
                sb.append(0).append("\n");
            } else if(sum==rSub || sum==rSum) sb.append(1).append("\n");
            else sb.append(2).append("\n");

        }


        System.out.println(sb.toString());
    }
}