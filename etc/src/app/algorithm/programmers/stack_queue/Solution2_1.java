package app.algorithm.programmers.stack_queue;

import java.util.*;

public class Solution2_1 {
    public static void main(String[] args) {

        // int bridge_length = 2;
        // int weight = 10;
        // int[] truck_weights = {7,4,5,6};

        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10};

        // int bridge_length = 100;
        // int weight = 100;
        // int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};

        System.out.println(solution(bridge_length, weight, truck_weights));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {

            Queue<Truck> truckOnBridge = new LinkedList<>();
            Queue<Integer> truckOnWait = new LinkedList<>(Arrays.asList(Arrays.stream(truck_weights).boxed().toArray( Integer[]::new )));

            int bridgeLength = bridge_length;
            int bridgeLimitWeight = weight;
            int bridgeCurrentWeight = 0;

            int answer;


            //answer은 경과시간.
            //최대 걸리는시간은 트럭갯수*다리길이
            for (answer = 1; answer <= truck_weights.length * bridge_length; answer++) {

                if(!truckOnBridge.isEmpty()) { //다리위에 트럭이 있으면
                    for (Truck truck : truckOnBridge) {
                        truck.loc++; //한칸씩 이동
                    }
                    if (truckOnBridge.peek().loc > bridgeLength) { // 맨앞 트럭이 다리를 다 건너면
                        bridgeCurrentWeight -= truckOnBridge.peek().weight; //현재 다리무게에서 트럭을 무게를 뺀다.  
                        truckOnBridge.poll(); // 맨앞 트럭 제거(다리를 건넘)
                    }
                }

                //대기중인 트럭이 있고, 현재의 다리에 올라갈수 있는 무게라면
                if (!truckOnWait.isEmpty() && (bridgeLimitWeight >= truckOnWait.peek() + bridgeCurrentWeight)) {
                    int truckWeight = truckOnWait.peek();
                    truckOnBridge.offer(new Truck(truckWeight)); //다리큐에 넣는다 (해당 트럭은 다리를 지난다.)
                    bridgeCurrentWeight += truckWeight; //현재 다리무게에서 트럭을 무게를 더한다.
                    truckOnWait.poll(); //대기큐에서는 뺀다.
                }

                if(truckOnBridge.isEmpty()) break; // 다리에 트럭이 없으면 모두 건넜다.

            }

            return answer;
        }

        static class Truck {
            int weight;
            int loc = 1;

            public Truck(int weight) {
                this.weight = weight;
            }
        }

}
