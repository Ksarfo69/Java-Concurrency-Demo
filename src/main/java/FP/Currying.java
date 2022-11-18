package FP;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Currying {
    public static final Function<Integer, Integer> curryAdd = new Function<Integer, Integer>()
    {

        @Override
        public Integer apply(Integer integer) {
            return integer + 2;
        }
    };


    public static BiFunction<Integer, Integer, Integer> s(String name)
    {
        switch (name) {
            case "add":
                return (integer, integer2) -> integer+integer2;
            case "subtract":
                return ((integer, integer2) -> integer - integer2);
            case "power":
                return new BiFunction<Integer, Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer, Integer integer2) {
                        return null;
                    }
                };

        }
        return null;
    }



    public static void main(String[] args) {

        BiFunction<Integer, Integer, Integer> add = s("add");
        BiFunction<Integer, Integer, Integer> subtract = s("subtract");
        BiFunction<Integer, Integer, Integer> power = s("power");

        System.out.println(add.apply(3, 4));
        System.out.println(subtract.apply(8, 4));
        System.out.println(power.apply(3,3));
    }

}
