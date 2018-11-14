package th.ac.cmu.camt.sodiumconqueror.manager.db.model;

/**
 * Created by Bitwarp on 7/22/2016.
 */
public class Diary {

    public static final String TABLE_NAME = "Diary";

    String foodName;
    int sodiumVolume;
    String type;
    String date;

    public class Column{

        public static final String ID = "id";
        public static final String FOOD_NAME = "foodName";
        public static final String SODIUM_VOLUME = "sodiumVolume";
        public static final String TYPE = "type";
        public static final String DATE = "date";

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}