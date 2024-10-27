import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] S;
    static boolean[] team;  // 팀 구성을 위한 방문 체크 배열
    static int minDifference = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        team = new boolean[N];

        // 능력치 행렬 입력 받기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 조합을 사용하여 팀을 나눕니다.
        divideTeams(0, 0);
        
        // 결과 출력
        System.out.println(minDifference);
    }

    // 조합을 사용하여 팀을 나누는 함수
    public static void divideTeams(int idx, int count) {
        // N/2명을 선택한 경우
        if (count == N / 2) {
            calculateDifference();
            return;
        }
        
        for (int i = idx; i < N; i++) {
            if (!team[i]) {
                team[i] = true;
                divideTeams(i + 1, count + 1);
                team[i] = false;
            }
        }
    }

    // 팀 능력치를 계산하여 최소 차이를 갱신하는 함수
    public static void calculateDifference() {
        int startTeam = 0;
        int linkTeam = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (team[i] && team[j]) {
                    startTeam += S[i][j];
                } else if (!team[i] && !team[j]) {
                    linkTeam += S[i][j];
                }
            }
        }

        // 두 팀의 능력치 차이의 절대값을 구하고 최소값 갱신
        int difference = Math.abs(startTeam - linkTeam);
        minDifference = Math.min(minDifference, difference);
    }
}