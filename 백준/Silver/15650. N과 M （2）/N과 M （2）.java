import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] sequence;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        sequence = new int[M];
        
        backtrack(1, 0);
        
        System.out.println(sb.toString());
    }

    // 백트래킹 함수
    public static void backtrack(int start, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(sequence[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = start; i <= N; i++) {
            sequence[depth] = i;
            backtrack(i + 1, depth + 1);  
        }
    }
}