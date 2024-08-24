import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> A = new HashSet<>();
        Set<String> B = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A.add(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            B.add(st.nextToken());
        }

        // A - B
        Set<String> AminusB = new HashSet<>(A);
        AminusB.removeAll(B);

        // B - A
        Set<String> BminusA = new HashSet<>(B);
        BminusA.removeAll(A);

        // 대칭 차집합의 크기
        int symmetricDifferenceSize = AminusB.size() + BminusA.size();

        System.out.println(symmetricDifferenceSize);
    }
}