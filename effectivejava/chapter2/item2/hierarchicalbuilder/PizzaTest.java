package chapter2.item2.hierarchicalbuilder;

import static chapter2.item2.hierarchicalbuilder.Pizza.Topping.*;
import static chapter2.item2.hierarchicalbuilder.NyPizza.Size.*;

// 계층적 빌더 사용 (21쪽)
public class PizzaTest {
    public static void main(String[] args) {
        NyPizza pizza = new NyPizza.Builder(SMALL)
                .addTopping(SAUSAGE).addTopping(ONION).build();
        Calzone calzone = new Calzone.Builder()
                .addTopping(HAM).sauceInside().build();
        
        System.out.println(pizza);
        System.out.println(calzone);
    }
}
