import java.io.*;
import java.util.*;


public class Main { 
    static int n,k;
    static int[] a;
    static boolean[] robot;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());

        a=new int[2*n];
        robot=new boolean[n];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<2*n;i++){
            a[i]=Integer.parseInt(st.nextToken());
        }

        int level=0;

        while(true){ 
            level++;

            rotate();
            moveRobot();
            putRobot();

            if(cntZero()>=k) break;
        }

        System.out.println(level);
    }
    static void rotate(){
        //벨트회전
        int last=a[2*n-1];
        for(int i=2*n-1;i>0;i--){
            a[i]=a[i-1];
        }
        a[0]=last;
        //로봇회전
        for(int i=n-1;i>0;i--){
            robot[i]=robot[i-1];
        }
        robot[0]=false; //회전중
        robot[n-1]=false; //내려가는위치에 도달
    }
    //로봇이동
    static void moveRobot(){
        for(int i=n-2;i>=0;i--){
            if(robot[i] && !robot[i+1] && a[i+1]>=1){
                robot[i]=false;
                robot[i+1]=true;
                a[i+1]--;
            }
        }
        robot[n-1]=false;
    }
    //로봇올리기
    static void putRobot(){
        if(!robot[0] && a[0]>0){
            robot[0]=true;
            a[0]--;
        }
    }
    //내구도0 개수 세기
    static int cntZero(){
        int cnt=0;
        for(int i=0;i<2*n;i++){
            if(a[i]==0) cnt++;
        }
        return cnt;
    }
}   