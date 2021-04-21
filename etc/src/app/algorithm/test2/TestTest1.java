import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class TestTest1 {

    private static final int TOTAL_NUMBER_MONTH = 12;
    
    public static void main(String[] args) {

        System.out.println(solution(new int[]{100, 100, 100}, new String[]{"2020-12-31", "2020-12-22", "2020-12-03"})); //240
        System.out.println(solution(new int[]{180, -50, -25, -25}, new String[]{"2020-01-01", "2020-01-01", "2020-01-01", "2020-01-31"})); //25
        System.out.println(solution(new int[]{1, -1, 0, -105, 1}, new String[]{"2020-12-31", "2020-04-04", "2020-04-04", "2020-04-14", "2020-07-12"})); // -164
        System.out.println(solution(new int[]{100, 100, -10, -20, -30}, new String[]{"2020-01-01", "2020-02-01", "2020-02-11", "2020-02-05", "2020-02-08"})); // 80

    }

    public static int solution(int[] A, String[] D) {

        int totalAccount = 0;
        int totalFee = 0;

        DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        Map<Integer, CardMonthInfo> monthInfoMap = new HashMap<>();
        for (int i = 1; i <= TOTAL_NUMBER_MONTH; i++) {
            monthInfoMap.put(i, new CardMonthInfo());
        }

        for (int i = 0; i < A.length; i++) {
            LocalDate localDate = LocalDate.parse(D[i], dateformatter);
            int transferMonth = localDate.getMonthValue();
            if(A[i] < 0) {
                monthInfoMap.get(transferMonth).addTotalPayment(A[i]);
                monthInfoMap.get(transferMonth).addCardUseCount();
            }
        }

        for (int transactionMoney : A) {
            totalAccount += transactionMoney;
        }

        for (int i = 1; i <= TOTAL_NUMBER_MONTH; i++) {
            if(!(monthInfoMap.get(i).totalPayment <= -100 && monthInfoMap.get(i).cardUseCount >= 3)) {
                totalFee += 5;
            }
        }

        return totalAccount - totalFee;
    }

    static class CardMonthInfo {
        
        private int totalPayment = 0;
        private int cardUseCount = 0;

        public void addCardUseCount() {
            this.cardUseCount++;
        }

        public void addTotalPayment(int transactionMoney) {
            this.totalPayment += transactionMoney;
        }


    }

}
