package mk.ukim.finki.restaurantreviewapp.model.Dtos;

public class RestaurantDto {

    private String name;
    private String description;
    private String address;
    private String city;
    private String country;
    private boolean delivery;
    private int price;
    private Long categoryId;

    public RestaurantDto() {
    }

    public RestaurantDto(String name, String description, String address, String city, String country, boolean delivery, int price, Long categoryId) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.city = city;
        this.country = country;
        this.delivery = delivery;
        this.price = price;
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isDelivery() {
        return delivery;
    }

    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
