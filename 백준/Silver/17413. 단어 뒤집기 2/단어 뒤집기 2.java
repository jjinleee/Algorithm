import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        StringBuilder sb = new StringBuilder();   // 최종 결과
        StringBuilder word = new StringBuilder(); // 태그 밖에서 단어를 임시로 담는 용도
        boolean inTag = false;                   // 지금 태그 안인지 여부

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // 태그 시작
            if (ch == '<') {
                // 태그 시작 전에 쌓여 있던 단어를 뒤집어서 넣기
                if (word.length() > 0) {
                    sb.append(reverseString(word));
                    word.setLength(0);
                }
                inTag = true;
                sb.append(ch); // '<' 그대로
            }

            // 태그 끝
            else if (ch == '>') {
                inTag = false;
                sb.append(ch); // '>' 그대로
            }

            // 태그 안
            else if (inTag) {
                // 태그 안의 모든 문자(공백 포함)는 그대로 출력
                sb.append(ch);
            }

            // 태그 밖
            else {
                // 공백이면, 지금까지 쌓인 단어를 뒤집어서 출력하고 공백도 출력
                if (ch == ' ') {
                    if (word.length() > 0) {
                        sb.append(reverseString(word));
                        word.setLength(0);
                    }
                    sb.append(' ');
                } else {
                    // 단어 구성 문자면 word에 쌓기
                    word.append(ch);
                }
            }
        }

        // 루프 끝난 뒤, 마지막 단어가 남아 있으면 뒤집어서 추가
        if (word.length() > 0) {
            sb.append(reverseString(word));
        }

        System.out.println(sb.toString());
    }

    static String reverseString(StringBuilder word){
        int n = word.length();
        StringBuffer sb = new StringBuffer();
        for (int i = n - 1; i >= 0; i--) {
            sb.append(word.charAt(i));
        }
        return sb.toString();
    }
}