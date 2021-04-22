package mk.ukim.finki.restaurantreviewapp.model.Dtos;

public class ReviewDto {
    Double rating;
    String comment;

    public ReviewDto(Double rating) {
        this.rating = rating;
    }

    public ReviewDto(Double rating, String comment) {
        this.rating = rating;
        this.comment = comment;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
