package th.ac.cmu.camt.sodiumconqueror.manager.db.model;

/**
 * Created by Bitwarp on 7/20/2016.
 */
public class User {

    public static final String TABLE_NAME = "USER";


    private String name;
    private int age;
    private int gender;
    private double weight;
    private double height;
    private String disease;

    public class Columns{

        public static final String ID = "id";
        public static final String USER_NAME = "name";
        public static final String USER_AGE = "age";
        public static final String USER_GENDER = "gender";
        public static final String USER_WEIGHT = "weight";
        public static final String USER_HEIGHT = "height";
        public static final String USER_DISEASE = "disease";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }



    public boolean isValid(){

        if(this.name != null && this.age != 0 &&  this.weight != 0 && this.height != 0){
            return true;
        }else
            return false;
    }
}
