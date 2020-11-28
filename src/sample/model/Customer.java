package sample.model;

public class Customer {
    private String name;
    private String address;
    private String phoneNumber;
    private Cart order;

    public Customer(String name, String zipCode, String city,
                    String street, String houseNumber, String phoneNumber) {
        this.name = name;
        this.address = String.format(
                "%s %s, %s %s",
                zipCode, city, street, houseNumber
        );
        this.phoneNumber = phoneNumber;
    }

    public void setOrder(Cart order) {
        this.order = order;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public Cart getOrder() {
        return this.order;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", order=" + order +
                '}';
    }
}
