package algorithm.programmers.hash;

import java.util.*;

public class Solution1_1 {
    public static void main(String[] args) {

        List<Integer> startTimes = new ArrayList<>();
        startTimes.add(1);
        startTimes.add(3);
        startTimes.add(1);
        startTimes.add(2);

        List<Integer> runningTimes = new ArrayList<>();
        runningTimes.add(2);
        runningTimes.add(1);
        runningTimes.add(1);
        runningTimes.add(1);

        solution(startTimes, runningTimes);
    }

    public static int solution(List<Integer> startTimes, List<Integer> runningTimes) {

        List<Job> jobSeqList = new ArrayList<>();

        for (int i = 0; i < startTimes.size(); i++) {
            int startTime = startTimes.get(i);
            int runningTime = runningTimes.get(i);
            Job job = new Job(startTime, runningTime);

            jobSeqList.add(job);

            Map a = new HashMap<>();
            a.get("Asdf");
        }

        return 0;
    }

    static class Job {
        List<Integer> time;
        List<Boolean> isRunning;

        public Job(int startTime, int runningTime) {
            this.time = new ArrayList<>();
            this.isRunning = new ArrayList<>();

            for (int i = 0; i < startTime; i++) {
                this.time.add(i);
                this.isRunning.add(false);
            }

            for (int k = startTime; k <= startTime + runningTime; k++) {
                this.time.add(k);
                this.isRunning.add(true);
            }

        }
        
        
    }
}
