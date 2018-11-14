package th.ac.cmu.camt.sodiumconqueror.manager.db.dbHelper;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import retrofit2.http.POST;
import th.ac.cmu.camt.sodiumconqueror.manager.api.get.model.FoodDetail;
import th.ac.cmu.camt.sodiumconqueror.manager.db.model.Diary;
import th.ac.cmu.camt.sodiumconqueror.manager.db.model.MyFoodList;
import th.ac.cmu.camt.sodiumconqueror.manager.db.model.TodayReport;
import th.ac.cmu.camt.sodiumconqueror.manager.db.model.User;

/**
 * Created by Bitwarp on 7/22/2016.
 */
public class DbHelper extends SQLiteOpenHelper {

    SQLiteDatabase sqLiteDatabase;

    public static final String DB_NAME = "Sodium.db";
    public static final int DB_VERSION = 43;

    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        final String SQL_CREATE_USER = String.format("CREATE TABLE %s " + "(%s INTEGER PRIMARY KEY AUTOINCREMENT , %s TEXT,%s INTEGER,%s INTEGER,%s DECIMAL,%s DECIMAL,%s TEXT)",
                User.TABLE_NAME,
                User.Columns.ID,
                User.Columns.USER_NAME,
                User.Columns.USER_AGE,
                User.Columns.USER_GENDER,
                User.Columns.USER_WEIGHT,
                User.Columns.USER_HEIGHT,
                User.Columns.USER_DISEASE
        );

        final String SQL_CREATE_MYFOODLIST = String.format("CREATE TABLE %s " + "(%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT , %s INTEGER , %s TEXT , %s TEXT , %s TEXT)",
                MyFoodList.TABLE_NAME,
                MyFoodList.Column.ID,
                MyFoodList.Column.FOOD_NAME,
                MyFoodList.Column.SODIUM_VOLUME,
                MyFoodList.Column.TYPE,
                MyFoodList.Column.FAV_STATUS,
                MyFoodList.Column.SOURCE
        );

        final String SQL_CREATE_DIARY = String.format("CREATE TABLE %s " + "(%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT , %s INTEGER , %s TEXT , %s TEXT)",
                Diary.TABLE_NAME,
                Diary.Column.ID,
                Diary.Column.FOOD_NAME,
                Diary.Column.SODIUM_VOLUME,
                Diary.Column.TYPE,
                Diary.Column.DATE
        );


        final String SQL_INSERT_MYFOODLIST = String.format("INSERT INTO %s " + "(%s,%s,%s,%s,%s) " + "VALUES" +

                        "('สุกี้น้ำ',1560,'THAI','FALSE','HOME')," +
                        "('กระเพาะปลาน้ำแดง',1450,'THAI','FALSE','HOME')," +
                        "('แกงผักเซียงดา',2156,'THAI','FALSE','HOME')," +
                        "('แกงอ่อม',1272,'THAI','FALSE','HOME')," +
                        "('แกงผักปลัง',1300,'THAI','FALSE','HOME')," +
                        "('ยำหน่อไม้',1510,'THAI','FALSE','HOME')," +
                        "('ผัดผักบุ้ง',3063,'THAI','FALSE','HOME')," +
                        "('ผัดผักรวม',2332,'THAI','FALSE','HOME')," +
                        "('ผัดหน่อไม้ใส่ไข่',2540,'THAI','FALSE','HOME')," +
                        "('ผัดผักกาดดองใส่ไข่',4216,'THAI','FALSE','HOME')," +
                        "('ผัดพริกขิงถั่วฝักยาว',2544,'THAI','FALSE','HOME')," +
                        "('แกงหมูเทโพ',2332,'THAI','FALSE','HOME')," +
                        "('ปลา-กุ้ง จ่อม',2240,'THAI','FALSE','HOME')," +
                        "('ต้มมะระกระดูกหมู',1508,'THAI','FALSE','HOME')," +
                        "('มัสมั่นไก่',1752,'THAI','FALSE','HOME')," +
                        "('แกงเขียวหวานลูกชิ้นปลากราย',2220,'THAI','FALSE','HOME')," +
                        "('พะแนงหมู',1932,'THAI','FALSE','HOME')," +
                        "('แกงส้มผักรวม',2724,'THAI','FALSE','HOME')," +
                        "('แกงเลียง',1668,'THAI','FALSE','HOME')," +
                        "('แกงแค',1440,'THAI','FALSE','HOME')," +
                        "('แกงผักเฮือด',1892,'THAI','FALSE','HOME')," +
                        "('แกงโฮ๊ะ',2724,'THAI','FALSE','HOME')," +
                        "('แกงลาว',2640,'THAI','FALSE','HOME')," +
                        "('แกงคั่วสัปปะรดหอย',2472,'THAI','FALSE','HOME')," +
                        "('แกงเหลืองหน่อไม้ดองปลา',2892,'THAI','FALSE','HOME')," +
                        "('แกงไตปลา',3176,'THAI','FALSE','HOME')," +
                        "('แกงขี้เหล็กปลาย่าง',3176,'THAI','FALSE','HOME')," +
                        "('ขนมปังหน้ากุ้ง',410,'THAI','FALSE','HOME')," +
                        "('ทอดมันปลากราย 5ชิ้น',325,'THAI','FALSE','HOME')," +
                        "('ยำไก่ใส่มะม่วง',346,'THAI','FALSE','HOME');",

                MyFoodList.TABLE_NAME,
                MyFoodList.Column.FOOD_NAME,
                MyFoodList.Column.SODIUM_VOLUME,
                MyFoodList.Column.TYPE,
                MyFoodList.Column.FAV_STATUS,
                MyFoodList.Column.SOURCE
        );

        db.execSQL(SQL_CREATE_MYFOODLIST);
        db.execSQL(SQL_CREATE_DIARY);
        db.execSQL(SQL_CREATE_USER);

        db.execSQL(SQL_INSERT_MYFOODLIST);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String DROP_FRIEND_TABLE = "DROP TABLE IF EXISTS " + MyFoodList.TABLE_NAME;
        String DROP_DIARY_TALBE = "DROP TABLE IF EXISTS " + Diary.TABLE_NAME;
        String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + User.TABLE_NAME;

        db.execSQL(DROP_FRIEND_TABLE);
        db.execSQL(DROP_DIARY_TALBE);
        db.execSQL(DROP_USER_TABLE);


        onCreate(db);
    }

    public void insertUser(User user) {

        sqLiteDatabase = this.getWritableDatabase();

        final String SQL_INSERT_USER = String.format("INSERT INTO %s " + "(%s,%s,%s,%s,%s,%s) " + "VALUES('" +
                        user.getName() + "'," +
                        user.getAge() + ",'" +
                        user.getGender() + "'," +
                        user.getWeight() + "," +
                        user.getHeight() + ",'" +
                        user.getDisease() + "')",

                User.TABLE_NAME,
                User.Columns.USER_NAME,
                User.Columns.USER_AGE,
                User.Columns.USER_GENDER,
                User.Columns.USER_WEIGHT,
                User.Columns.USER_HEIGHT,
                User.Columns.USER_DISEASE
        );

        sqLiteDatabase.execSQL(SQL_INSERT_USER);
        sqLiteDatabase.close();
    }

    public void updateUser(User user) {
        //TODO : Update thai fave food list

        sqLiteDatabase = this.getReadableDatabase();

        String SQL_UPDATE_USER = String.format("UPDATE %s SET %s = '%s', %s = %s, %s = %s, %s = %s, %s = %s , %s = '%s' WHERE id = %s",
                User.TABLE_NAME,
                User.Columns.USER_NAME, user.getName(),
                User.Columns.USER_AGE, Integer.toString(user.getAge()),
                User.Columns.USER_GENDER , Integer.toString(user.getGender()),
                User.Columns.USER_WEIGHT , Double.toString(user.getWeight()),
                User.Columns.USER_HEIGHT, Double.toString(user.getHeight()),
                User.Columns.USER_DISEASE ,user.getDisease(),
                "1"
                );


        sqLiteDatabase.execSQL(SQL_UPDATE_USER);
        sqLiteDatabase.close();

    }

    public boolean isUserExist(){
        if(getUser().isValid()){
            return true;
        }else
            return false;
    }

    public User getUser() {

        User user = new User();

        sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.query(User.TABLE_NAME, null, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        if (cursor.getCount() > 0) {
            user.setName(cursor.getString(1));
            user.setAge(cursor.getInt(2));
            user.setGender(cursor.getInt(3));
            user.setWeight(cursor.getDouble(4));
            user.setHeight(cursor.getDouble(5));
            user.setDisease(cursor.getString(6));
        }

        cursor.close();
        sqLiteDatabase.close();

        return user;
    }

    public ArrayList<MyFoodList> getThaiFood() {

        ArrayList<MyFoodList> thaiFoodList = new ArrayList<MyFoodList>();

        sqLiteDatabase = this.getWritableDatabase();

        Cursor cursor = sqLiteDatabase.query(MyFoodList.TABLE_NAME, null, MyFoodList.Column.TYPE + " = ? AND " + MyFoodList.Column.SOURCE + " = ?", new String[]{"THAI","HOME"}, null, null, MyFoodList.Column.FOOD_NAME);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        while (!cursor.isAfterLast()) {

            MyFoodList myFoodList = new MyFoodList();

            myFoodList.setId(Integer.toString(cursor.getInt(0)));
            myFoodList.setFoodName(cursor.getString(1));
            myFoodList.setSodiumVolume(cursor.getInt(2));
            myFoodList.setType(cursor.getString(3));
            myFoodList.setFav(cursor.getString(4));

            thaiFoodList.add(myFoodList);
            cursor.moveToNext();
        }

        cursor.close();
        sqLiteDatabase.close();

        return thaiFoodList;
    }

    public ArrayList<MyFoodList> getThaiHomeMadeFoodList() {

        ArrayList<MyFoodList> thaiHomeMadeFoodList = new ArrayList<MyFoodList>();

        sqLiteDatabase = this.getWritableDatabase();

        Cursor cursor = sqLiteDatabase.query(MyFoodList.TABLE_NAME, null, MyFoodList.Column.TYPE + " = ? AND " + MyFoodList.Column.SOURCE + " = ?", new String[]{"THAI", "HOMEMADE"}, null, null, MyFoodList.Column.FOOD_NAME);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        while (!cursor.isAfterLast()) {

            MyFoodList myFoodList = new MyFoodList();

            myFoodList.setId(Integer.toString(cursor.getInt(0)));
            myFoodList.setFoodName(cursor.getString(1));
            myFoodList.setSodiumVolume(cursor.getInt(2));
            myFoodList.setType(cursor.getString(3));
            myFoodList.setFav(cursor.getString(4));

            thaiHomeMadeFoodList.add(myFoodList);
            cursor.moveToNext();
        }

        cursor.close();
        sqLiteDatabase.close();

        return thaiHomeMadeFoodList;
    }

    public ArrayList<MyFoodList> getGenericFood() {

        ArrayList<MyFoodList> genericFoodList = new ArrayList<MyFoodList>();

        sqLiteDatabase = this.getWritableDatabase();

        Cursor cursor = sqLiteDatabase.query(MyFoodList.TABLE_NAME, null, MyFoodList.Column.TYPE + " = ?", new String[]{"GENERIC"}, null, null, MyFoodList.Column.FOOD_NAME);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        while (!cursor.isAfterLast()) {

            MyFoodList myFoodList = new MyFoodList();

            myFoodList.setId(Integer.toString(cursor.getInt(0)));
            myFoodList.setFoodName(cursor.getString(1));
            myFoodList.setSodiumVolume(cursor.getInt(2));
            myFoodList.setType(cursor.getString(3));
            myFoodList.setFav(cursor.getString(4));

            genericFoodList.add(myFoodList);
            cursor.moveToNext();
        }

        cursor.close();
        sqLiteDatabase.close();

        return genericFoodList;
    }

    public boolean isGenericFoodExist(FoodDetail food) {


        String genericFoodName = food.getFoodName();
        sqLiteDatabase = this.getWritableDatabase();

        Cursor cursor = sqLiteDatabase.query(MyFoodList.TABLE_NAME, null, MyFoodList.Column.TYPE + " = ? AND " + MyFoodList.Column.FOOD_NAME + " = ?", new String[]{"GENERIC", genericFoodName}, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        if (cursor.getCount() > 0) {
            cursor.close();
            sqLiteDatabase.close();
            return true;
        } else {
            cursor.close();
            sqLiteDatabase.close();
            return false;
        }
    }

    public ArrayList<MyFoodList> getFavThaiFoodList() {

        ArrayList<MyFoodList> thaiFoodList = new ArrayList<MyFoodList>();
        sqLiteDatabase = this.getWritableDatabase();

        Cursor cursor = sqLiteDatabase.query(MyFoodList.TABLE_NAME, null, MyFoodList.Column.FAV_STATUS + "= ? AND " + MyFoodList.Column.SOURCE + "= ?", new String[]{"TRUE", "HOME"}, null, null, MyFoodList.Column.FOOD_NAME);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        while (!cursor.isAfterLast()) {

            MyFoodList myFoodList = new MyFoodList();

            myFoodList.setId(cursor.getString(0));
            myFoodList.setFoodName(cursor.getString(1));
            myFoodList.setSodiumVolume(cursor.getInt(2));
            myFoodList.setType(cursor.getString(3));
            myFoodList.setFav(cursor.getString(4));

            thaiFoodList.add(myFoodList);
            cursor.moveToNext();
        }

        cursor.close();
        sqLiteDatabase.close();

        return thaiFoodList;
    }

    public ArrayList<MyFoodList> getFavGenericFoodList() {

        ArrayList<MyFoodList> thaiFoodList = new ArrayList<MyFoodList>();

        sqLiteDatabase = this.getWritableDatabase();

        Cursor cursor = sqLiteDatabase.query(MyFoodList.TABLE_NAME, null, MyFoodList.Column.FAV_STATUS + "= ? AND " + MyFoodList.Column.SOURCE + "= ?", new String[]{"TRUE", "API"}, null, null, MyFoodList.Column.FOOD_NAME);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        while (!cursor.isAfterLast()) {

            MyFoodList myFoodList = new MyFoodList();

            myFoodList.setId(cursor.getString(0));
            myFoodList.setFoodName(cursor.getString(1));
            myFoodList.setSodiumVolume(cursor.getInt(2));
            myFoodList.setType(cursor.getString(3));
            myFoodList.setFav(cursor.getString(4));

            thaiFoodList.add(myFoodList);
            cursor.moveToNext();
        }

        cursor.close();
        sqLiteDatabase.close();

        return thaiFoodList;
    }

    public void insertDiary(MyFoodList food) {

        sqLiteDatabase = this.getWritableDatabase();

        Calendar c = Calendar.getInstance();

        SimpleDateFormat df = new SimpleDateFormat("dd MMMM yyyy");
        String formattedDate = df.format(c.getTime());

        final String SQL_INSERT_DIARY = String.format("INSERT INTO %s " + "(%s,%s,%s,%s)" +
                        "VALUES('" +
                        food.getFoodName() + "','" +
                        food.getSodiumVolume() + "','" +
                        food.getType() + "','" +
                        formattedDate + "')",

                Diary.TABLE_NAME,
                Diary.Column.FOOD_NAME,
                Diary.Column.SODIUM_VOLUME,
                Diary.Column.TYPE,
                Diary.Column.DATE
        );


        sqLiteDatabase.execSQL(SQL_INSERT_DIARY);
        sqLiteDatabase.close();

    }

    public void insertGenericFoodList(FoodDetail food) {

        sqLiteDatabase = this.getWritableDatabase();

        String foodName = food.getFoodName();
        int foodSodiumVolume = food.getSodiumVolume();

        final String SQL_INSERT_GENERIC_FOOD_LIST = String.format("INSERT INTO %s " + "(%s,%s,%s,%s,%s) " +
                        "VALUES('" + foodName + "'," + foodSodiumVolume + "," + "'GENERIC'," + "'FALSE'," + "'API'" + ")",
                MyFoodList.TABLE_NAME,
                MyFoodList.Column.FOOD_NAME,
                MyFoodList.Column.SODIUM_VOLUME,
                MyFoodList.Column.TYPE,
                MyFoodList.Column.FAV_STATUS,
                MyFoodList.Column.SOURCE

        );

        sqLiteDatabase.execSQL(SQL_INSERT_GENERIC_FOOD_LIST);
        sqLiteDatabase.close();
    }



    public void insertThaiHomeMadeFoodList(FoodDetail food) {

        sqLiteDatabase = this.getWritableDatabase();

        String foodName = food.getFoodName();
        int foodSodiumVolume = food.getSodiumVolume();

        final String SQL_INSERT_GENERIC_FOOD_LIST = String.format("INSERT INTO %s " + "(%s,%s,%s,%s,%s) " +
                        "VALUES('" + foodName + "'," + foodSodiumVolume + "," + "'THAI'," + "'FALSE'," + "'HOMEMADE'" + ")",
                MyFoodList.TABLE_NAME,
                MyFoodList.Column.FOOD_NAME,
                MyFoodList.Column.SODIUM_VOLUME,
                MyFoodList.Column.TYPE,
                MyFoodList.Column.FAV_STATUS,
                MyFoodList.Column.SOURCE

        );

        sqLiteDatabase.execSQL(SQL_INSERT_GENERIC_FOOD_LIST);
        sqLiteDatabase.close();
    }

    public ArrayList<Diary> getDiaryReport() {

        ArrayList<Diary> diaryReport = new ArrayList<Diary>();
        sqLiteDatabase = this.getReadableDatabase();


        if (Build.VERSION.SDK_INT >= 16) {
            Cursor cursor = sqLiteDatabase.rawQuery("SELECT SUM(" + Diary.Column.SODIUM_VOLUME + ")," + Diary.Column.DATE + " FROM " + Diary.TABLE_NAME + " GROUP BY " + Diary.Column.DATE, null, null);

            if (cursor != null) {
                cursor.moveToFirst();
            }

            while (!cursor.isAfterLast()) {

                Diary diary = new Diary();

                diary.setFoodName("");
                diary.setSodiumVolume(cursor.getInt(0));
                diary.setDate(cursor.getString(1));
                diary.setType("");

                diaryReport.add(diary);

                cursor.moveToNext();

            }

            cursor.close();
            sqLiteDatabase.close();
        }

        return diaryReport;
    }

    public TodayReport getTodayReport() {

        int totalSodium = 0;

        TodayReport todayReport = new TodayReport();
        ArrayList<Diary> diaries = new ArrayList<Diary>();

        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd MMMM yyyy");
        String today = df.format(c.getTime());

        sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.query(Diary.TABLE_NAME, new String[]{Diary.Column.DATE, Diary.Column.FOOD_NAME, Diary.Column.SODIUM_VOLUME, Diary.Column.TYPE}, Diary.Column.DATE + "= ?", new String[]{today}, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        while (!cursor.isAfterLast()) {

            totalSodium += cursor.getInt(2);
            Diary diary = new Diary();

            diary.setDate(cursor.getString(0));
            diary.setFoodName(cursor.getString(1));
            diary.setSodiumVolume(cursor.getInt(2));
            diary.setType(cursor.getString(3));

            diaries.add(diary);

            cursor.moveToNext();

        }

        todayReport.setFoodList(diaries);
        todayReport.setTotalSodium(totalSodium);

        cursor.close();
        sqLiteDatabase.close();

        return todayReport;

    }

    public void updateFavFoodList(String id, boolean isChecked) {
        //TODO : Update thai fave food list

        String SQL_UPDATE_FAV_STATUS = "";
        sqLiteDatabase = this.getReadableDatabase();

        System.out.println(id);

        if (!isChecked) {
            SQL_UPDATE_FAV_STATUS = String.format("UPDATE %s SET %s = 'FALSE' WHERE %s = %s",
                    MyFoodList.TABLE_NAME, MyFoodList.Column.FAV_STATUS, MyFoodList.Column.ID, id);
        } else {
            SQL_UPDATE_FAV_STATUS = String.format("UPDATE %s SET %s = 'TRUE' WHERE %s = %s",
                    MyFoodList.TABLE_NAME, MyFoodList.Column.FAV_STATUS, MyFoodList.Column.ID, id);
        }

        sqLiteDatabase.execSQL(SQL_UPDATE_FAV_STATUS);
        sqLiteDatabase.close();

    }

    public boolean isFavourite(String id) {

        String favouriteStatus = "";

        sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.query(MyFoodList.TABLE_NAME, new String[]{MyFoodList.Column.FAV_STATUS}, MyFoodList.Column.ID + "= ?", new String[]{id}, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        while (!cursor.isAfterLast()) {
            favouriteStatus = cursor.getString(0);
            cursor.moveToNext();
        }

        if (favouriteStatus.equals("TRUE")) {
            cursor.close();
            return true;
        } else {
            cursor.close();
            return false;
        }


    }

    public boolean isFavouriteByName(String name) {

        String favouriteStatus = "";

        sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.query(MyFoodList.TABLE_NAME, new String[]{MyFoodList.Column.FAV_STATUS}, MyFoodList.Column.FOOD_NAME + "= ?", new String[]{name}, null, null, null);


        if (cursor != null) {
            cursor.moveToFirst();
        }

        while (!cursor.isAfterLast()) {
            favouriteStatus = cursor.getString(0);
            cursor.moveToNext();
        }

        if (favouriteStatus.equals("TRUE")) {
            return true;
        } else {
            return false;
        }

    }


}
