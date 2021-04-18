public class Solution3 {
    public static void main(String[] args) {

        System.out.println(solution(new int[][]{{4,3,4,5,3}, {2,7,3,8,4}, {1,7,6,5,2}, {8,4,9,5,5}})); //return 3

        System.out.println(solution(new int[][]{{2,2,1,1}, {2,2,2,2}, {1,2,2,2}})); //return 2

        System.out.println(solution(new int[][]{{7,2,4}, {2,7,6}, {9,5,1}, {4,3,8}, {3,5,4}})); //return 3

        System.out.println(solution(new int[][]{{2,2,2,2}, {2,2,2,2}, {2,2,2,2}, {2,2,2,2}})); //return 4
    }

    public static int solution(int[][] A) {

        int rowSize = A.length;
        int columnSize = A[0].length;
        int magicSquareSize = Math.min(rowSize, columnSize);


        
        for (magicSquareSize = magicSquareSize; magicSquareSize > 1; magicSquareSize--) { //마방진의 크기를 줄인다
            for (int rowIndex = 0; rowIndex <= rowSize - magicSquareSize; rowIndex++) { //맨 위의 로우부터 하나씩 내려간다.
                if(moveColumn(A, rowIndex, magicSquareSize, columnSize)) return magicSquareSize;
            }
        }

        return 0;
    }

    //해당 로우의 마방진을 체크한다.
    private static boolean moveColumn(int[][] A, int rowIndex, int magicSquareSize, int columnSize) {
        
        Loop1 :
        for (int i = 0; i <= columnSize - magicSquareSize; i++) { //스퀘어를 맨 왼쪽컬러부터 오른쪽으로 이동하며 마방진을 확인한다.
            int standardRowSum = 0;
            
            for (int j = i; j < i + magicSquareSize; j++) { // 특정 컬럼별 로우합 계산
                int columnSum = 0;
                for (int k = rowIndex; k < magicSquareSize + rowIndex; k++) {
                    if(j == i) standardRowSum += A[k][j]; //첫 컬럼이면 기준합 잡기
                    else columnSum += A[k][j];
                }
                if(j > i  && columnSum != standardRowSum) { //첫 컬럼이 아니고 기준합과 다르면
                    continue Loop1; //다음 컬럼으로 넘어감
                }
            }

            for (int k = rowIndex; k < magicSquareSize + i; k++) { // 특정 로우별 컬럼합 계산
                int rowSum = 0;
                for (int j = i; j < i + magicSquareSize; j++) { 
                    rowSum += A[k][j];
                }
                if(rowSum != standardRowSum) { //기준합과 다르면
                    continue Loop1; //다음 컬럼으로 넘어감
                }
            }
            return true; //위의 조건을 모두 통과해서 마방진
        }

        return false;
    }
}
