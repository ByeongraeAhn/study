package algorithm.programmers.hash;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Solution1_2 {
    public static void main(String[] args) {

        List<Integer> startTimes = new ArrayList<>();
        startTimes.add(1);
        startTimes.add(3);
        startTimes.add(2);

        List<Integer> runningTimes = new ArrayList<>();
        runningTimes.add(3);
        runningTimes.add(1);
        runningTimes.add(1);

        System.out.println(solution(startTimes, runningTimes));
    }

    public static int solution(List<Integer> startTimes, List<Integer> runningTimes) {

        List<Task> result = new ArrayList<>();
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < startTimes.size(); i++) {
            tasks.add(new Task(startTimes.get(i), runningTimes.get(i)));
        }

        List<Task> sorted = tasks.stream()
                .sorted(Comparator.comparing(Task::getEndTime).thenComparing(Task::getStartTime))
                .collect(Collectors.toList());
        result.add(sorted.get(0));

        for (Task task : sorted) {
            Task tmp = result.get(result.size() - 1);
           if (tmp.isNotOverlaps(task)) {
               result.add(task);
           }

        }
        return result.size();
    }

    private static class Task {
        private final int startTime;
        private final int endTime;

        public Task(int startTime, int runningTime) {
            this.startTime = startTime;
            this.endTime = startTime + runningTime;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public boolean isNotOverlaps(Task other) {
            return getEndTime() <= other.getStartTime();
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Task.class.getSimpleName() + "[", "]")
                    .add("" + startTime)
                    .add("" + endTime)
                    .toString() + "\n";
        }
    }
}
