package RestDemo;

import java.util.List;

public class Product {
    private Name name;
    private String email;
    private List<String> phoneNumbers;
    private Address address;
    private OrderId orderId;

    // Constructor
    public Product(Name name, String email, List<String> phoneNumbers, Address address, OrderId orderId) {
        this.name = name;
        this.email = email;
        this.phoneNumbers = phoneNumbers;
        this.address = address;
        this.orderId = orderId;
    }

    // Inner class Name
    public static class Name {
        private String id;
        private String userName;

        public Name(String id, String userName) {
            this.id = id;
            this.userName = userName;
        }

        // Getters
        public String getId() { return id; }
        public String getUserName() { return userName; }
    }

    // Inner class Address
    public static class Address {
        private String street;
        private String houseNumber;
        private String city;
        private String state;
        private String zip;

        public Address(String street, String houseNumber, String city, String state, String zip) {
            this.street = street;
            this.houseNumber = houseNumber;
            this.city = city;
            this.state = state;
            this.zip = zip;
        }

        // Getters
        public String getStreet() { return street; }
        public String getHouseNumber() { return houseNumber; }
        public String getCity() { return city; }
        public String getState() { return state; }
        public String getZip() { return zip; }
    }

    // Inner class OrderId
    public static class OrderId {
        private String orderNumber;
        private String productCode;
        private String productName;

        public OrderId(String orderNumber, String productCode, String productName) {
            this.orderNumber = orderNumber;
            this.productCode = productCode;
            this.productName = productName;
        }

        // Getters
        public String getOrderNumber() { return orderNumber; }
        public String getProductCode() { return productCode; }
        public String getProductName() { return productName; }
    }

    // Getters
    public Name getName() { return name; }
    public String getEmail() { return email; }
    public List<String> getPhoneNumbers() { return phoneNumbers; }
    public Address getAddress() { return address; }
    public OrderId getOrderId() { return orderId; }
}
