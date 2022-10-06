package callback;

import java.util.function.Consumer;

public class Callback {
    public static void main(String[] args) {

        hello("Hovhannes",null, value-> System.out.println("no last name provided for " + value));

    }
    static void  hello(String name , String surname, Consumer<String> callback){
        System.out.println(name);
        if (surname!=null){
            System.out.println(surname);
        }else {
            callback.accept(name);
        }
    }
}
