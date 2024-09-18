import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 풍선의 수 입력
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 덱에 풍선 번호와 이동할 값을 저장
        Deque<int[]> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            deque.offer(new int[]{i + 1, Integer.parseInt(st.nextToken())});
        }

        StringBuilder sb = new StringBuilder();

        // 첫 번째 풍선부터 터뜨리기 시작
        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();  // 첫 번째 풍선 터뜨리기
            sb.append(current[0]).append(" ");  // 터진 풍선 번호 기록

            if (deque.isEmpty()) break;  // 모든 풍선이 터지면 종료

            int move = current[1];  // 이동할 값

            // 양수 또는 음수에 따라 이동 처리
            if (move > 0) {
                for (int i = 0; i < move - 1; i++) {
                    deque.offerLast(deque.pollFirst());  // 오른쪽으로 이동
                }
            } else {
                for (int i = 0; i < Math.abs(move); i++) {
                    deque.offerFirst(deque.pollLast());  // 왼쪽으로 이동
                }
            }
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}