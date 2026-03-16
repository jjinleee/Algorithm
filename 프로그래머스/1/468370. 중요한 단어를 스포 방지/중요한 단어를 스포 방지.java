import java.util.*;

class Solution {
    static class Word {
        String text;
        int start, end;
        int revealAt; // 이 클릭에서 완전히 공개됨, non-spoiler면 -1

        Word(String text, int start, int end, int revealAt) {
            this.text = text;
            this.start = start;
            this.end = end;
            this.revealAt = revealAt;
        }
    }

    public int solution(String message, int[][] spoiler_ranges) {
        List<Word> words = new ArrayList<>();
        int n = message.length();
        int m = spoiler_ranges.length;

        // 1. 단어 파싱
        int i = 0;
        while (i < n) {
            int start = i;
            while (i < n && message.charAt(i) != ' ') i++;
            int end = i - 1;
            String text = message.substring(start, i);
            words.add(new Word(text, start, end, -1));
            i++; // 공백 넘기기
        }

        // 2. 각 단어가 어떤 spoiler range들과 겹치는지 확인
        Set<String> nonSpoilerWords = new HashSet<>();
        List<List<Integer>> revealedAtClick = new ArrayList<>();
        for (int k = 0; k < m; k++) revealedAtClick.add(new ArrayList<>());

        int r = 0; // 현재 확인 중인 spoiler range 인덱스

        for (int w = 0; w < words.size(); w++) {
            Word word = words.get(w);

            // 현재 단어 시작점보다 완전히 왼쪽에 있는 range들은 넘김
            while (r < m && spoiler_ranges[r][1] < word.start) {
                r++;
            }

            int temp = r;
            int lastOverlap = -1;

            // word와 겹치는 모든 range 확인
            while (temp < m && spoiler_ranges[temp][0] <= word.end) {
                if (spoiler_ranges[temp][1] >= word.start) {
                    lastOverlap = temp;
                }
                temp++;
            }

            if (lastOverlap == -1) {
                // 스포 구간과 전혀 안 겹침
                nonSpoilerWords.add(word.text);
            } else {
                // spoiler word, 마지막으로 겹치는 range를 클릭할 때 완전히 공개됨
                word.revealAt = lastOverlap;
                revealedAtClick.get(lastOverlap).add(w);
            }
        }

        // 3. 클릭 순서대로 중요한 단어 개수 세기
        int answer = 0;
        Set<String> revealedSpoilerWords = new HashSet<>();

        for (int click = 0; click < m; click++) {
            for (int wordIndex : revealedAtClick.get(click)) {
                Word word = words.get(wordIndex);

                if (!nonSpoilerWords.contains(word.text) &&
                    !revealedSpoilerWords.contains(word.text)) {
                    answer++;
                }

                // 중요한 단어 여부와 상관없이
                // "이전에 공개된 스포 방지 단어" 판정용으로 기록
                revealedSpoilerWords.add(word.text);
            }
        }

        return answer;
    }
}