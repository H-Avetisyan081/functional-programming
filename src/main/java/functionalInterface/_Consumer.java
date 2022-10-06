package functionalInterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {
        greetCustomer( new Customer("Hayk", "989898"));
        Customer hovhannes =  new Customer("Hovhannes", "998");
        greetCustomerConsumer.accept(hovhannes);
        greetBiCustomerConsumer.accept(hovhannes,true);
    }

    static Consumer<Customer> greetCustomerConsumer = customer ->
            System.out.println("Hello " + customer.customerName + " thanks for registration phone number "
                    + customer.getCustomerNumber);
    static BiConsumer<Customer, Boolean> greetBiCustomerConsumer = (customer, showNumber) ->
            System.out.println("Hello " + customer.customerName + " thanks for registration phone number "
                    + (showNumber ? customer.getCustomerNumber: "*****"));
    static void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.customerName
                + " , thanks for registration phone number "
                + customer.getCustomerNumber);
    }
    static class Customer {
        private final String customerName;
        private final String getCustomerNumber;
        public Customer(String customerName, String getCustomerNumber) {
            this.customerName = customerName;
            this.getCustomerNumber = getCustomerNumber;
        }
    }

}
