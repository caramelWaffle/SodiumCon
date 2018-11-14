package th.ac.cmu.camt.sodiumconqueror.manager.db.model;

/**
 * Created by Bitwarp on 7/22/2016.
 */
public class MyFoodList {

    public static final String TABLE_NAME = "MyFoodList";

    String id;
    String foodName;
    int sodiumVolume;
    String type;
    String Fav;
    String source;

    public class Column{

        public static final String ID = "id";
        public static final String FOOD_NAME = "foodName";
        public static final String SODIUM_VOLUME = "sodiumVolume";
        public static final String TYPE = "type";
        public static final String FAV_STATUS ="fav";
        public static final String SOURCE = "source";
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getSodiumVolume() {
        return sodiumVolume;
    }

    public void setSodiumVolume(int sodiumVolume) {
        this.sodiumVolume = sodiumVolume;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFav() {
        return Fav;
    }

    public void setFav(String fav) {
        Fav = fav;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}