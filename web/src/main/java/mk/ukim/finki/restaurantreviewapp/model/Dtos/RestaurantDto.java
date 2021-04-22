package mk.ukim.finki.restaurantreviewapp.model.Dtos;

public class RestaurantDto {

    private String name;
    private String description;
    private Long locationId;
    private boolean delivery;
    private int price;
    private Long categoryId;

    public RestaurantDto() {
    }

    public RestaurantDto(String name, String description, Long locationId, boolean delivery, int price, Long categoryId) {
        this.name = name;
        this.description = description;
        this.locationId = locationId;
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

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
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
