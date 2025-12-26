import java.util.*;

class Solution {
    class Task {
        String name;
        int time; // 남은 시간
        Task(String name, int time) {
            this.name = name;
            this.time = time;
        }
    }

    public String[] solution(String[][] plans) {
        List<String> done = new ArrayList<>();

        // 시작 시간 기준 정렬
        Arrays.sort(plans, (a, b) -> a[1].compareTo(b[1]));

        Deque<Task> stop = new ArrayDeque<>();

        for (int i = 0; i < plans.length - 1; i++) {
            String name = plans[i][0];
            int start = toTime(plans[i][1]);
            int need = Integer.parseInt(plans[i][2]);

            int nextStart = toTime(plans[i + 1][1]);
            int end = start + need;

            if (end > nextStart) {
                // 다음 과제 시작 전에 못 끝냄 -> 멈춰두기
                int worked = nextStart - start;
                int remain = need - worked;
                stop.addLast(new Task(name, remain));
            } else {
                // 현재 과제 끝냄
                done.add(name);

                // 남는 시간 동안 멈춘 과제 이어서 하기
                int free = nextStart - end;
                while (free > 0 && !stop.isEmpty()) {
                    Task last = stop.peekLast();
                    if (last.time <= free) {
                        free -= last.time;
                        done.add(last.name);
                        stop.pollLast();
                    } else {
                        last.time -= free;
                        free = 0;
                    }
                }
            }
        }

        // 마지막 과제는 무조건 시작해서 끝냄 (뒤에 방해할 과제 없음)
        done.add(plans[plans.length - 1][0]);

        // 멈춘 과제들 LIFO로 마무리
        while (!stop.isEmpty()) {
            done.add(stop.pollLast().name);
        }

        return done.toArray(new String[0]);
    }

    int toTime(String s) {
        String[] tmp = s.split(":");
        int h = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);
        return 60 * h + m;
    }
}