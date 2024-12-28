import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<int[]> confs=new ArrayList<>(n);

        for(int i=0;i<n;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            confs.add(new int[]{start,end});
        }

        confs.sort((a,b)->{
            if(a[1]==b[1]){
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        int cnt=0;
        int time=0;

        for(int[] conf : confs){
            if(conf[0]>=time){
                cnt++;
                time=conf[1];
            }
        }

        System.out.println(cnt);
    }
}