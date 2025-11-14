import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
       BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st= new StringTokenizer(br.readLine());
       int n=Integer.parseInt(st.nextToken());
       int k=Integer.parseInt(st.nextToken());

        boolean[] robot= new boolean[2*n];
        int[] belt=new int[2*n];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<2*n;i++){
            belt[i]=Integer.parseInt(st.nextToken());
        }

        int step=0;
        while(true){
            step++;
            // 1.벨트+로봇 회전
            int lastb=belt[2*n-1];
            boolean lastr=robot[2*n-1];

            for(int i=2*n-1;i>0;i--){
                belt[i]=belt[i-1];
                robot[i]=robot[i-1];
            }
            //마지막칸 따로 처리
            belt[0]=lastb; 
            robot[0]=lastr;

            //2.로봇 이동-약순
            robot[n-1]=false; //내리는 위치에서 내림
            for(int i=n-2;i>=0;i--){
                if(belt[i+1]>=1 && !robot[i+1] && robot[i]){ //내구도>=1 && 비어있으면
                    robot[i+1]=true; //로봇이동
                    robot[i]=false;
                    belt[i+1]--; //내구도감소
                }
            }
            robot[n-1]=false; //로봇이동후 내리는 위치에서 내림

            //3. 로봇올림
            if(belt[0]>0 && !robot[0]){
                belt[0]--;
                robot[0]=true;
            }

            //4. 내구도 확인
            int cnt=0;
            for(int b : belt){
                if(b==0) cnt++;
            }
            if(cnt>=k) break;

        }

        System.out.println(step);
    }
}