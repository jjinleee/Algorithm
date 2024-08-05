import java.io.*;
import java.util.*;


public class Main{
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();

        String[] temp=sc.next().split("");
        int[] arr=new int[temp.length];

        for(int i=0;i<temp.length;i++){
            arr[i]=Integer.parseInt(temp[i]);
        }

        Arrays.sort(arr);

        for (int i = arr.length - 1; i >= 0; i--) {
			System.out.print(arr[i]);
		}
    }
}