import java.util.*;

class Solution {
    //최대 가입자 수, 최대 매출액 저장
    int maxPlus = 0;
    int maxSales = 0;

    // 가능한 할인율
    int[] rates = {10, 20, 30, 40};

    int[][] gUsers;
    int[] gEmoticons;

    public int[] solution(int[][] users, int[] emoticons) {
        this.gUsers = users;
        this.gEmoticons = emoticons;

        int m = emoticons.length;
        int[] applied = new int[m]; // 각 이모티콘에 적용된 할인율

        // 이모티콘마다 할인율을 10,20,30,40 중 하나씩 모두 시도
        dfs(0, applied);

        return new int[]{maxPlus, maxSales};
    }

    // idx번째 이모티콘의 할인율을 정하는 DFS
    void dfs(int idx, int[] applied) {
        // 모든 이모티콘의 할인율을 다 정했으면 결과 계산
        if (idx == gEmoticons.length) {
            evaluate(applied);
            return;
        }

        // 현재 이모티콘에 10,20,30,40 각각 적용해봄
        for (int rate : rates) {
            applied[idx] = rate;
            dfs(idx + 1, applied);
        }
    }

    // 현재 할인율 조합(applied)으로 사용자 반응을 계산
    void evaluate(int[] applied) {
        int plusCnt = 0;
        int sales = 0;

        // 각 사용자별로
        for (int[] user : gUsers) {
            int minRate = user[0];  // 이 사용자 최소 원하는 할인율
            int limit = user[1];    // 이 금액 이상이면 이모티콘 플러스 가입

            int sum = 0;

            // 모든 이모티콘에 대해
            for (int i = 0; i < gEmoticons.length; i++) {
                int rate = applied[i];

                // 이 사용자 원하는 할인율 이상인 이모티콘만 구매
                if (rate >= minRate) {
                    int price = gEmoticons[i] * (100 - rate) / 100;
                    sum += price;
                }
            }

            // 이 사용자 처리
            if (sum >= limit) {
                // 이모티콘 플러스 가입
                plusCnt++;
            } else {
                // 그냥 구매 금액 매출에 더함
                sales += sum;
            }
        }

        // 결과 갱신 (가입자 수 우선, 그 다음 매출)
        if (plusCnt > maxPlus) {
            maxPlus = plusCnt;
            maxSales = sales;
        } else if (plusCnt == maxPlus && sales > maxSales) {
            maxSales = sales;
        }
    }
}