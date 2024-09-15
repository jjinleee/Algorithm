import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<n;i++){
            queue.add(i+1);
        }

        while(queue.size()!=1){
            queue.poll();
            int num=queue.element();
            queue.poll();
            queue.add(num);
        }

        System.out.println(queue.peek());
    }
}