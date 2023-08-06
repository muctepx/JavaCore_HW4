package JavaCore.HW4.model;

import java.time.LocalDate;
import java.time.Period;

public class Customer {
    String fullName;
    private final LocalDate birthday;
    String phone;

    public Customer(String lastName, String firstName, String patronymic,
                    LocalDate birthday, String phoneCountryCode, long phoneNumber) {
        this.fullName = lastName + ' ' + firstName + ' ' + patronymic;
        this.birthday = birthday;
        this.phone = phoneCountryCode + phoneNumber;
    }

    public int getAge() {
        return Period.between(birthday, LocalDate.now()).getYears();
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        return String.format("Покупатель: %s (%d лет), %s",
                fullName, getAge(), phone);
    }
}
