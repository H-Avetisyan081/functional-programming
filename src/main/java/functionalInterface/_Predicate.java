package functionalInterface;

import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
        System.out.println(isPhoneNumberValid("+37493454845"));
        System.out.println(isPhoneNumberValid("+374121212121"));

        System.out.println(isPhoneNumberValidPredicate.test("+37412121212"));
        boolean test = isPhoneNumberValidPredicate.and(containsNumber3).test("+37494121212");
        System.out.println(test);
    }
    static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("+374") && phoneNumber.length() == 12;
    }
    static Predicate<String> containsNumber3 = phoneNumber ->
            phoneNumber.contains("3");
    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
            phoneNumber.startsWith("+374") && phoneNumber.length() == 12;
}