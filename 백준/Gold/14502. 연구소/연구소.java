import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int[][] lab;
    static int[][] templab;
    static List<int[]> viruses=new ArrayList<>();
    static int maxSafeArea=Integer.MIN_VALUE;
     //상하좌우 이동방향
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,1,-1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        lab=new int[n][m];

        //lab 입력받기
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                lab[i][j]=Integer.parseInt(st.nextToken());
                if(lab[i][j]==2) viruses.add(new int[]{i,j}); //바이러스위치
            }
        }

        setWall(0);
        System.out.println(maxSafeArea);

    }

    static void setWall(int count){
        if(count==3){       // 벽을 다세웠으면 시뮬레읻션
            spreadVirus();
            return;
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(lab[i][j]==0){
                    lab[i][j]=1; //벽세워보기
                    setWall(count+1);      //재귀호출
                    lab[i][j]=0;           //원상복구
                }
            }
        }
    }

    static void spreadVirus(){
        templab=new int[n][m];

        //연구실복사
        for(int i=0;i<n;i++){
            System.arraycopy(lab[i], 0, templab[i], 0, m);
        }
        Queue<int[]> queue=new LinkedList<>();
        for(int[] virus: viruses){
            queue.offer(virus);
        }

        // 바이러스 확산
        while (!queue.isEmpty()) {
            int[] v = queue.poll();
            int x = v[0];
            int y = v[1];
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (templab[nx][ny] == 0) {
                        templab[nx][ny] = 2;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        
        // 안전 영역 크기 계산
        calculateSafeArea();
    }

   
    static void calculateSafeArea(){
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(templab[i][j]==0) cnt++;
            }
        }
        maxSafeArea=Math.max(maxSafeArea,cnt);
    }

   
}