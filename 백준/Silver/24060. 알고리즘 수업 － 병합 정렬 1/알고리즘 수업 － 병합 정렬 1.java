import java.io.*;
import java.util.*;

public class Main {
    static int[] A, tmp;
    static int K, count = 0, result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N];
        tmp = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(0, N - 1);

        // K번째 저장 횟수보다 저장이 더 적었다면 -1 출력
        System.out.println(result);
    }

    public static void mergeSort(int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(p, q);
            mergeSort(q + 1, r);
            merge(p, q, r);
        }
    }

    public static void merge(int p, int q, int r) {
        int i = p, j = q + 1, t = p;

        // 병합 과정에서 두 배열을 병합하며 카운트 증가
        while (i <= q && j <= r) {
            if (A[i] <= A[j]) {
                tmp[t++] = A[i++];
            } else {
                tmp[t++] = A[j++];
            }
        }

        // 왼쪽 배열 부분이 남은 경우 처리
        while (i <= q) {
            tmp[t++] = A[i++];
        }

        // 오른쪽 배열 부분이 남은 경우 처리
        while (j <= r) {
            tmp[t++] = A[j++];
        }

        // 임시 배열을 원래 배열로 복사
        for (i = p; i <= r; i++) {
            A[i] = tmp[i];
            count++; // 배열에 저장될 때마다 카운트 증가

            // K번째 저장된 수를 기록하고 출력
            if (count == K) {
                result = A[i];
                return;
            }
        }
    }
}