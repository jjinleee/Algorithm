import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // LIS를 저장할 리스트
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int num = A[i];

            // 삽입할 위치 이분탐색
            int idx = Collections.binarySearch(list, num);

            if (idx < 0) {
                idx = -(idx + 1); // 삽입 위치
            }

            if (idx >= list.size()) {
                list.add(num); // 맨 뒤에 추가
            } else {
                list.set(idx, num); // 해당 위치에 덮어쓰기
            }
        }

        System.out.println(list.size());
    }
}