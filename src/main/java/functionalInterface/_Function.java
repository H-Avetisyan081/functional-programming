package functionalInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        int increment = increment(0);
        System.out.println(increment);
        Integer increment2 = integerIntegerFunction.apply(1);
        System.out.println(increment2);
        int multiply = multipleBy10.apply(increment2);
        System.out.println(multiply);
        Integer incrementAndThenMultiply = integerIntegerFunction.andThen(multipleBy10).apply(4);
        System.out.println(incrementAndThenMultiply);
        // Bi function
        System.out.println(incrementByOneAndMultiply(4, 100));
        System.out.println(incrementByOneAndMultipleBiFunction.apply(5, 111));
    }
    static Function<Integer, Integer> integerIntegerFunction = number ->
            number+1;
    static Function<Integer, Integer> multipleBy10 = number ->
            number * 10;
    static int increment(int number){
        return number+1;
    }
    static BiFunction<Integer,Integer,Integer> incrementByOneAndMultipleBiFunction =
            (numberToIncrementByOne, numberToMultipleBy)
                    -> (numberToIncrementByOne+1)*numberToMultipleBy;
    static int incrementByOneAndMultiply(int number, int numToMultiply){
        return (number+1)*numToMultiply;
    }
}