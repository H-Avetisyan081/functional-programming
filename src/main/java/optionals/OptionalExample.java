package optionals;

import java.util.Optional;
import java.util.function.Supplier;

public class OptionalExample {
    public static void main(String[] args) {

        Supplier<IllegalStateException> exception = () -> new IllegalStateException("exception");
        Object value = Optional.ofNullable("Hello")
                .orElseThrow(exception);
        System.out.println(value);



        Optional.ofNullable("test@mail.com")
                .ifPresent(email -> System.out.println("Sending email to " + email));


        Optional.ofNullable(null)
                .ifPresentOrElse(email -> System.out.println("Sending email to " + email),
                        ()-> System.out.println("Cannot send email"));
    }


}
