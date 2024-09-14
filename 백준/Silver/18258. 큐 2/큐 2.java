import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken(); // 첫 번째 명령어를 저장

            if (command.equals("push")) {
                queue.offer(Integer.parseInt(st.nextToken()));
            } else if (command.equals("pop")) {
                if (!queue.isEmpty()) {
                    sb.append(queue.pollFirst()).append("\n"); // pollFirst로 값을 꺼냄
                } else {
                    sb.append(-1).append("\n");
                }
            } else if (command.equals("size")) {
                sb.append(queue.size()).append("\n");
            } else if (command.equals("empty")) {
                if (!queue.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(1).append("\n");
                }
            } else if (command.equals("front")) {
                if (!queue.isEmpty()) {
                    sb.append(queue.peekFirst()).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            } else if (command.equals("back")) {
                if (!queue.isEmpty()) {
                    sb.append(queue.peekLast()).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            }
        }

        // 모든 명령어 처리가 끝난 후 결과 출력
        System.out.println(sb);
    }
}