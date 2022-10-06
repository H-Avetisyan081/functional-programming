package combinatorPattern;

import java.time.LocalDate;
import static combinatorPattern.CustomerRegistrationValidator.*;


public class CustomerTest {
    public static void main(String[] args) {
        Customer customer = new Customer(
                "Alice",
                "alice@gmail.com",
                "+37498696958",
                LocalDate.of(1998,5,6)
        );


        //we can store customer in db
        //Using combinator Pattern
       ValidationResult result = isEmailValid()
               .and(isPhoneValid())
               .and(isAdult())
               .apply(customer);
        System.out.println(result);

        if (result!= ValidationResult.SUCCESS){
            throw new IllegalStateException(result.name());
        }
    }
}
