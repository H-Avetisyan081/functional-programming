package functionalInterface;

import java.util.function.Supplier;

public class _Supplier {
    public static void main(String[] args) {
        System.out.println(getDBConnectionURL());
        System.out.println(getDBConnectionUrlSupplier.get());
    }
    static String getDBConnectionURL(){
        return "jdbc://localhost:5432/someusers";
    }
    static Supplier<String> getDBConnectionUrlSupplier = ()
            -> "jdbc://localhost:5432/someusers";
}