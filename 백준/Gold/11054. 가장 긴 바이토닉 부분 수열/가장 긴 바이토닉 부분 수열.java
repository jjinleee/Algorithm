import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dpUp = new int[n];
        int[] dpDown = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dpUp, 1); 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dpUp[i] = Math.max(dpUp[i], dpUp[j] + 1);
                }
            }
        }

        Arrays.fill(dpDown, 1); 
        for (int i = n-1; i >=0; i--) {
            for (int j = n-1; j >i; j--) {
                if (arr[j] < arr[i]) {
                    dpDown[i] = Math.max(dpDown[i], dpDown[j] + 1);
                }
            }
        }

        int maxLength=0;
        for(int i=0;i<n;i++){
            maxLength=Math.max(maxLength, dpUp[i]+dpDown[i]-1);
        }
        System.out.println(maxLength);
    }
}