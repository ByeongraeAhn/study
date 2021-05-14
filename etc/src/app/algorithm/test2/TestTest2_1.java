package app.algorithm.test2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TestTest2_1 {

    public static String[] SEASONS = new String[]{"WINTER", "SPRING", "SUMMNER", "AUTUMN"};
    private static final int NUMBER_OF_SEASON = SEASONS.length;
    
    public static void main(String[] args) {

        System.out.println(solution(new int[]{-3, -14, -5, 7, 8, 42, 8, 3})); //차이 34, SUMMER
        System.out.println(solution(new int[]{2, -3, 3, 1, 10, 8, 2, 5, 13, -5, 3, -18})); //차이 21, AUTUMN
    }

    public static String solution(int[] T) {

        int term = T.length / NUMBER_OF_SEASON;

        List<Season> seasons = new ArrayList<>();

        for (int i = 0; i < NUMBER_OF_SEASON; i++) {
            int min = Arrays.stream(T, term * i, term * (i + 1))
                    .min()
                    .orElseThrow(RuntimeException::new);

            int max = Arrays.stream(T, term * i, term * (i + 1))
                    .max()
                    .orElseThrow(RuntimeException::new);

            seasons.add(new Season(SEASONS[i], min, max));
        }

        return seasons.stream()
                .max(Comparator.comparing(Season::getDiff))
                .map(Season::getName)
                .orElseThrow(RuntimeException::new);
    }

    static class Season {

        private final String name;
        private final int min;
        private final int max;

        public Season(String name, int min, int max) {
            this.name = name;
            this.min = min;
            this.max = max;
        }

        public int getDiff() {
            return max - min;
        }

        public String getName() {
            return name;
        }
    }
}
