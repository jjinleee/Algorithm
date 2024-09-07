import java.io.*;
import java.util.*;

public class Main {
    
    static int N;
    static String[][] hallway;
    static String[][] temp;
    static List<int[]> teachers=new ArrayList<>();
    static List<int[]> objects=new ArrayList<>();

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        hallway = new String[N][N];

        // 복도 입력받기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                hallway[i][j] = st.nextToken();
                if (hallway[i][j].equals("T") ) {
                    teachers.add(new int[]{i,j}); // 선생님 정보 저장
                }
            }
        }

        setObject(0);
        System.out.println("NO");
        
    }

    static void setObject(int count){
        if(count==3){
            if(simulate()){
                System.out.println("YES");
                System.exit(0);
            }
            return;
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(hallway[i][j].equals("X")){
                    hallway[i][j]="O";
                    setObject(count+1);
                    hallway[i][j]="X";
                }
            }
        }
    }

    static boolean simulate() {
        // 복도 상태 복사
        temp = new String[N][N];
        for (int i = 0; i < N; i++) {
            System.arraycopy(hallway[i], 0, temp[i], 0, N);
        }

        // 모든 선생님에 대해 학생이 발견되는지 시뮬레이션
        for (int[] teacher : teachers) {
            int x = teacher[0];
            int y = teacher[1];

            // 4방향으로 감시
            for (int i = 0; i < 4; i++) {
                int nx = x;
                int ny = y;

                while (true) {
                    nx += dx[i]; // 한 칸 이동
                    ny += dy[i]; // 한 칸 이동

                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) break; // 범위를 벗어나면 종료
                    if (temp[nx][ny].equals("O")) break; // 장애물을 만나면 종료
                    if (temp[nx][ny].equals("S")) return false; // 학생을 발견하면 false 반환
                }
            }
        }
        return true; // 모든 선생님이 학생을 발견하지 못한 경우 true 반환
    }
}