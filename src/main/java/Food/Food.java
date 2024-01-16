package Food;

import java.util.UUID;

public class Food {
    private String id;
    private String name;
    private int price;
    private String description;

    public Food (String name, int price, String description) {
        this.id = this.createId();
        this.name = name;
        this.price = price;
        this.description = description;
    }

    private String createId(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
