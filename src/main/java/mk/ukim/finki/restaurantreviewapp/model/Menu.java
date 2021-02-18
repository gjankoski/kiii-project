package mk.ukim.finki.restaurantreviewapp.model;

import lombok.Data;

import java.util.List;

@Data
public class Menu {
    private List<MenuItem> menuItemList;

    public Menu(List<MenuItem> menuItemList) {
        this.menuItemList = menuItemList;
    }
}
