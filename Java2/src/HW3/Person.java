package HW3;

public class Person {

    private String email;

    private String phone;


    public Person(String phone, String email) {
        this.phone = phone;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public Person setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Person setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String toString() {
        return "(" + phone + ", " + email + ")";
    }
}
