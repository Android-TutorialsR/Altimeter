package com.vishal.altimeter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;


public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="altimeter";
    private static final int DATABASE_VERSION = 2;
    private static final String PRODUCT_IMAGE = "image";
    private static final String PRODUCT_NAME = "name";
    private static final String PRODUCT_PRICE = "price";
    private static final String PRODUCT_QUANTITY = "quantity";
    private static final String PRODUCT_TABLE = "prodemo";
    private static final String PRODUCT_CODE ="prodcode";
    private static final String USER_LATITUDE = "latitude";
    private static final String USER_LONGITUDE ="longitude";
    private static final String USER_TABLE ="appusertable";


    private static final String ORDERHISTORY_TABLE = "orderhistory";
    private static final String ORDERHISTORY_OI = "oid";
    private static final String ORDERHISTORY_OT = "otitle";
    private static final String ORDERHISTORY_OQ = "oqty";
    private static final String ORDERHISTORY_OP = "oprice";
    private static final String ORDERHISTORY_OTP = "otprice";
    private static final String ORDERHISTORY_OIM = "oimage";
    private static final String ORDER_STATUSS =  "status";
    private static final String NOTIFICATION_RID = "nid";
    private static final String DATABASE_NAMES = "name";
    private static final String DATABASE_PHONE= "phone";
    private static final String DATABASE_MOBILE = "mobile";
    private static final String NOTIFICATION_DT = "ndate";
    private static final String ACCOUNT = "account";
    private static final String ORDER_TYPE ="order_typr";
    private static final String CART_TABLE="cart_value";
    private static final String ORDER_CODE ="order_code";
    private static final String DELIVERY_PRICE="delivery";





    private static final String NOTIFICATION_TT = "ntitle";
    private static final String NOTIFICATION_TABLE = "notification";

    private static final String DATABASE_DATA_TABLE = "database_table";
    private static final String DATABASE_CATEGORY_NAME = "category_name";
    private static final String DATABASE_CATEGORY_VALUE = "category_value";
    private static final String DATABASE_SUB_CATEGORY_NAME = "sub_category_name";
    private static final String DATABASE_SUB_CATEGORY_VALUE = "sub_category_value";
    private static final String DATABASE_SUB_CATEGORY_IMAGE = "sub_category_image";
    private static final String DATABASE_MAIN_BIG_THUMB = "main_big_thumb";
    private static final String DATABASE_MAIN_IMAGE = "main_image";
    private static final String DATABASE_SMALL_IMAGE = "small_image";
    private static final String DATABASE_BARCODE = "barcode";
    private static final String DATABASE_BRAND = "brand";
    private static final String DATABASE_COLOR = "color";
    private static final String DATABASE_INNERQTY = "innerqty";
    private static final String DATABASE_OUTERQTY="outterqty";
    private static final String DATABASE_ISOUTOFSTOCK = "isoutofstock";
    private static final String DATABASE_PRICE = "price";
    private static final String DATABASE_PRODUCT_DESCRIPTION = "product_description";
    private static final String DATABASE_PRODUCTCODE = "product_code";
    private static final String DATABASE_SKU_DESCRIPTION = "sku_description";
    private static final String DATABASE_STOCK_QTY = "stock_qty";
    private static final String DATABASE_TAX_CODE = "tax_code";
    private static final String DATABASE_SIZE= "size";
    private static final String DATABASE_HEIGHT = "height";
    private static final String DATABASE_DEPTH = "depth";
    private static final String DATABASE_THUMBNAIL = "thumbnail";
    private static final String DATABASE_PROFILE = "profile_table";
    private static final String DATABASE_ADDRESS1= "address1";
    private static final String DATABASE_ADDRESS2 = "address2";
    private static final String DATABASE_CITY = "city";
    private static final String DATABASE_EMAIL = "email";
    private static final String DATABASE_STATUS ="status";



    Context context;

    private static final String STU_TABLE0 = "create table "+DATABASE_DATA_TABLE +"("+DATABASE_CATEGORY_NAME+" VARCHAR,"+DATABASE_CATEGORY_VALUE+" TEXT ,"+DATABASE_SUB_CATEGORY_NAME+" VARCHAR,"+DATABASE_SUB_CATEGORY_VALUE+" TEXT,"+DATABASE_MAIN_BIG_THUMB+" TEXT,"+DATABASE_MAIN_IMAGE+" TEXT,"+DATABASE_SMALL_IMAGE+" TEXT,"+DATABASE_BARCODE+" TEXT,"+DATABASE_BRAND+" TEXT,"+DATABASE_COLOR+" TEXT ,"+DATABASE_INNERQTY+" TEXT,"+DATABASE_ISOUTOFSTOCK+" TEXT,"+DATABASE_PRICE+" VARCHAR,"+DATABASE_PRODUCT_DESCRIPTION+" TEXT,"+DATABASE_PRODUCTCODE+" Text primary key,"+DATABASE_SKU_DESCRIPTION+" Text,"+DATABASE_STOCK_QTY+" Text,"+DATABASE_TAX_CODE+" Text ,"+DATABASE_SIZE+" Text ,"+DATABASE_HEIGHT+" Text ,"+DATABASE_DEPTH+" Text,"+DATABASE_THUMBNAIL+" Text,"+DATABASE_OUTERQTY+" Text,"+DATABASE_SUB_CATEGORY_IMAGE+")";
    private static final String STU_TABLE1 = "create table "+PRODUCT_TABLE +"("+PRODUCT_IMAGE+" TEXT,"+PRODUCT_NAME+" TEXT, "+PRODUCT_PRICE+" TEXT, "+PRODUCT_QUANTITY+" TEXT, "+PRODUCT_CODE+" TEXT)";
    private static final String STU_TABLE2 = "create table "+USER_TABLE+"("+USER_LATITUDE+" TEXT,"+USER_LONGITUDE+" TEXT)";
//    private static final String STU_TABLE3 = "create table "+LOGINHISTORY_TABLE +"("+NOTIFICATION_RID+" INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL,"+NOTIFICATION_DT+" DATETIME DEFAULT (DATETIME(CURRENT_TIMESTAMP, 'LOCALTIME')),"+ACCOUNT+" Text)";
//    private static final String STU_TABLE4 = "create table "+ORDERHISTORY_TABLE +"("+NOTIFICATION_RID+" INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL,"+ORDERHISTORY_OI+" TEXT ,"+ORDERHISTORY_OT+" TEXT ,"+ORDERHISTORY_OQ+" TEXT ,"+ORDERHISTORY_OP+" TEXT ,"+ORDERHISTORY_OTP+" TEXT ,"+ORDERHISTORY_OIM+" TEXT ,"+NOTIFICATION_DT+" DEFAULT CURRENT_DATE , "+DATABASE_ADDRESS1+" TEXT , "+DATABASE_ADDRESS2+" TEXT , "+DATABASE_NAMES+" TEXT , "+DATABASE_PHONE+" TEXT ,"+ACCOUNT+" TEXT ,"+ORDER_STATUSS+" TEXT)";
//    private static final String STU_TABLE5 = "create table "+CART_TABLE +"("+ORDERHISTORY_OI+" TEXT ,"+ORDERHISTORY_OT+" TEXT ,"+ORDERHISTORY_OQ+" TEXT ,"+ORDERHISTORY_OP+" TEXT ,"+ORDERHISTORY_OTP+" TEXT ,"+ORDERHISTORY_OIM+" TEXT , "+DATABASE_ADDRESS1+" TEXT , "+DATABASE_ADDRESS2+" TEXT , "+DATABASE_NAMES+" TEXT , "+DATABASE_PHONE+" TEXT ,"+ACCOUNT+" TEXT ,"+DELIVERY_PRICE+" TEXT,"+ORDER_TYPE+" TEXT,"+ORDER_CODE+" TEXT )";
//    private static final String  DATABASE_PROFILE_DATA = "create table "+DATABASE_PROFILE +"("+DATABASE_ADDRESS1+" TEXT,"+DATABASE_ADDRESS2+" TEXT ,"+DATABASE_CITY+" TEXT,"+DATABASE_COUNTRY+" TEXT,"+DATABASE_COUNTY+" TEXT,"+DATABASE_NAMES+" TEXT ,"+DATABASE_POSTALCODE+" TEXT,"+DATABASE_PHONE+" TEXT,"+DATABASE_MOBILE+" TEXT,"+DATABASE_COMPANYNAME+" TEXT ,"+DATABASE_CUTRRENCY+" TEXT ,"+DATABASE_EMAIL+" TEXT ,"+DATABASE_STATUS+" TEXT)";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(STU_TABLE0);
        db.execSQL(STU_TABLE1);
        db.execSQL(STU_TABLE2);
    }

    /*    @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            db.execSQL("DROP TABLE IF EXISTS " + PRODUCT_TABLE);

            // Create tables again
            onCreate(db);
        }*/
    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion,
                          int newVersion) {
        Log.w(DatabaseHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        database.execSQL("DROP TABLE IF EXISTS " + DATABASE_DATA_TABLE);
        onCreate(database);
    }


    public boolean deleteDatabase(Context context) {
        return context.deleteDatabase(DATABASE_NAME);
    }



    /*************INSERT NOTOFICATION DETAILS*************/

//    public void insertIntoNDB(String image, String name){
//        Log.d("insert", "before insert");
//
//        // 1. get reference to writable DB
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        // 2. create ContentValues to add key "column"/value
//        ContentValues values = new ContentValues();
//        values.put(PRODUCT_IMAGE, image);
//        values.put(PRODUCT_NAME, name);
//        // 3. insert
//        db.insert(NOTIFICATION_TABLE, null, values);
//        // 4. close
//        db.close();
//        Toast.makeText(context, "insert value", Toast.LENGTH_LONG);
//        Log.i("insert into DB", "After insert");
//    }

    /*************INSERT DATA INTO CARTVIEW TABLE*************/
    public void insertIntoDB(String image, String name){
        Log.d("insert", "before insert");

        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put(PRODUCT_IMAGE, image);
        values.put(PRODUCT_NAME, name);

        Log.i("inserintoB", "After insert"+values);
        // 3. insert
        db.insert(PRODUCT_TABLE, null, values);
        // 4. close
        db.close();
        Toast.makeText(context, "value inserted", Toast.LENGTH_LONG);

    }

    /* Insert into database*////////////////////////////////////////////////////////////////////////
    public boolean  checkIntoDB(String name, String image) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + PRODUCT_TABLE + " WHERE "
                + PRODUCT_NAME + "= '" + name + "' AND " + PRODUCT_IMAGE +"='" + image + "'",null);

        if (c.getCount() == 0) {
            Log.i("c.getCount()","" +c.getCount() );
            return false;
        } else
            return true;



    }

    /***********get all notification details***********/
//    public List<CartViewItemsBean> getnDataFromDB(String emailid){
//        List<CartViewItemsBean> modelList = new ArrayList<CartViewItemsBean>();
//        String query = "select * from "+NOTIFICATION_TABLE+" WHERE "
//                + ACCOUNT + "= '" + emailid + "' ORDER BY "+ NOTIFICATION_RID +" DESC";
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery(query,null);
//
//        if (cursor.moveToFirst()){
//            do {
//                CartViewItemsBean model = new CartViewItemsBean();
//                model.setNtitle(cursor.getString(1));
//                model.setNstock(cursor.getString(2));
//                model.setNread(cursor.getString(3));
//                model.setNdate(cursor.getString(4));
//                modelList.add(model);
//            }while (cursor.moveToNext());
//        }
//
//
//        Log.d("Notification data", modelList.toString());
//
//
//        return modelList;
//    }

    /*********** Retrive  data from database ***********/
//    public ArrayList<ShopCartLeadItems> getDataFromDB(){
//        ArrayList<ShopCartLeadItems> modelList = new ArrayList<ShopCartLeadItems>();
//        String query = "SELECT * FROM " + PRODUCT_TABLE ;
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery(query,null);
//
//        if (cursor.moveToFirst()){
//            do {
//                ShopCartLeadItems model = new ShopCartLeadItems();
//                model.setItem_Image(cursor.getString(0));
//                model.setItem_Name(cursor.getString(1));
//                model.setItem_price(cursor.getString(2));
//                model.setItem_quantity(cursor.getString(3));
//                model.setItem_ProductCode(cursor.getString(4));
//                modelList.add(model);
//            }while (cursor.moveToNext());
//        }
//
//
//        Log.d("product data", modelList.toString());
//
//
//        return modelList;
//    }



    public ArrayList<String> getProductNameFromDB(){
        ArrayList<String> modelList = new ArrayList<String>();
        String query = "SELECT "+PRODUCT_NAME+" FROM " + PRODUCT_TABLE ;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query,null);

        if (cursor.moveToFirst()){
            do {
                String strings ;
//                ShopCartLeadItems model = new ShopCartLeadItems();
//                model.setItem_Image(cursor.getString(0));
//                modelList.add(model);
                strings = cursor.getString(0);
                modelList.add(strings);
            }while (cursor.moveToNext());
        }


        Log.d("product data", modelList.toString());


        return modelList;
    }

    /*************delete a row from database*************/

    public void deleteARow(String name, String image){
        SQLiteDatabase db= this.getWritableDatabase();
        db.delete(PRODUCT_TABLE, "name" + " = ? AND image" + " = ?", new String[] { name, image });
        db.close();
    }


    public void deleteCart(){
        SQLiteDatabase db= this.getWritableDatabase();
        db.delete(PRODUCT_TABLE, null, null);
        db.close();
    }
//    public void deletedARow(String emailid, String code){
//        SQLiteDatabase db= this.getWritableDatabase();
//        db.delete(PRODUCT_TABLE, "account" + " = ? AND checkbox" + " = ? AND code" + " = ?", new String[] {  emailid,"true",code });
//        db.close();
//    }

    /*************count the no.of notification *************/
//    public int getNotificationCount(String emailid) {
//        int count = 0;
//        String countQuery = "SELECT  * FROM " + NOTIFICATION_TABLE+ " Where "+ACCOUNT+"='"+emailid+"' AND "+NOTIFICATION_RD+"='false'";
//
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery(countQuery, null);
//
//        if(cursor != null && !cursor.isClosed()){
//            count = cursor.getCount();
//            cursor.close();
//        }
//        return count;
//    }
    /*************count the no.of product*************/
    public int getProductCount() {
        int count = 0;
        String countQuery = "SELECT  * FROM " + PRODUCT_TABLE+ " ";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        if(cursor != null && !cursor.isClosed()){
            count = cursor.getCount();
            cursor.close();
        }
        return count;
    }
    /*************update notification table *************/
//    public void insertIntoNDB_RD(String aTrue, String emailid) {
//        Log.d("insert", "before insert");
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(NOTIFICATION_RD, aTrue);
//        db.update(NOTIFICATION_TABLE, values, NOTIFICATION_RD + " = '" + false + "' AND " + ACCOUNT +" = '"+ emailid +"'", null);
//        db.close();
//
//        Log.i("insert into DB", "After insert");
//    }
    /*************insert login time of user *************/
//    public void insertLoginTime(String emailid) {{
//        Log.d("insert", "before insert");
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(ACCOUNT, emailid);
//        db.insert(LOGINHISTORY_TABLE, null, values);
//        db.close();
//        Toast.makeText(context, "insert value", Toast.LENGTH_LONG);
//
//    }
//    }

    /*************show last five login of user *************/
//    public  List<CartViewItemsBean>getLoginHistory(String emailid) {
//        List<CartViewItemsBean> modelList = new ArrayList<CartViewItemsBean>();
//        String query= "select * from "+ LOGINHISTORY_TABLE +" WHERE " + ACCOUNT + "= '"+emailid+"' ORDER BY "+ NOTIFICATION_RID +" DESC LIMIT 5";
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery(query,null);
//
//        if (cursor.moveToFirst()){
//            do {
//                CartViewItemsBean model = new CartViewItemsBean();
//                model.setLogintime(cursor.getString(1));
//                modelList.add(model);
//            }while (cursor.moveToNext());
//        }
//
//
//        Log.d("product data", modelList.toString());
//
//
//        return modelList;
//    }
    /*************insert product data to order history table *************/
//    public void insertOrderHistory(String oTitle, String oQty, String oPrice, String oTprice, String oImage, String oOrderid, String address1, String address2, String name,String phone, String emailid,String order_status){
//        Log.d("insert", "before insert");
//        // 1. get reference to writable DB
//        SQLiteDatabase db = this.getWritableDatabase();
//        // 2. create ContentValues to add key "column"/value
//        ContentValues values = new ContentValues();
//        values.put(ORDERHISTORY_OT, oTitle);
//        values.put(ORDERHISTORY_OQ, oQty);
//        values.put(ORDERHISTORY_OP, oPrice);
//        // 3. insert
//        db.insert(ORDERHISTORY_TABLE, null, values);
//        // 4. close
//        db.close();
//        Toast.makeText(context, "insert value", Toast.LENGTH_LONG);
//        Log.i("insert into DB", "After insert");
//    }

    /*****************insert data into order cart table i.e product which we wanr to order ****************/
//    public void  insertOrdercartdta(String oTitle, String oQty, String oPrice, String oTprice, String oImage, String oOrderid, String address1, String address2, String name,String phone, String emailid, String delivery,String order_type, String order_code){
//        Log.d("insert", "before insert");
//        // 1. get reference to writable DB
//        SQLiteDatabase db = this.getWritableDatabase();
//        // 2. create ContentValues to add key "column"/value
//        ContentValues values = new ContentValues();
//        values.put(ORDERHISTORY_OT, oTitle);
//        values.put(ORDERHISTORY_OQ, oQty);
//        values.put(ORDERHISTORY_OP, oPrice);
//
//        // 3. insert
//        db.insert(CART_TABLE, null, values);
//        // 4. close
//        db.close();
//        Toast.makeText(context, "insert value", Toast.LENGTH_LONG);
//        Log.i("insertintDB", "After insert");
//    }
    /************show all data in order history layout **********/
//    public ArrayList<CartViewItemsBean> getOrderDataFromDB(String emailid) {
//        ArrayList<CartViewItemsBean> modelList = new ArrayList<CartViewItemsBean>();
//        String query = "select * from "+ORDERHISTORY_TABLE+" Where "+ ACCOUNT + "= '"+ emailid +"' ORDER BY "+ NOTIFICATION_RID +" DESC ";
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery(query,null);
//
//        if (cursor.moveToFirst()){
//            do {
//                CartViewItemsBean model = new CartViewItemsBean();
//                model.setOrderId(cursor.getString(1));
//                model.setOrderTitle(cursor.getString(2));
//                model.setOrderQty(cursor.getString(3));
//
//                modelList.add(model);
//            }while (cursor.moveToNext());
//        }
//
//
//        Log.d("product data", modelList.toString());
//
//
//        return modelList;
//    }
    /***********show allfilter product from low to high *************/
//    public ArrayList<CartViewItemsBean> getdescdata_filter(int cat_id){
//        ArrayList<CartViewItemsBean> modelList = new ArrayList<CartViewItemsBean>();
//        String query = "SELECT * FROM " + DATABASE_DATA_TABLE + " WHERE "
//                + DATABASE_CATEGORY_VALUE + "= '" + cat_id + "' " +" OR "
//                + DATABASE_SUB_CATEGORY_VALUE + "= '" + cat_id + "' ORDER BY CAST(" + DATABASE_PRICE + " AS DOUBLE) DESC ";
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery(query,null);
//        if (cursor.moveToFirst()){
//            do {
//                CartViewItemsBean model = new CartViewItemsBean();
//                model.setImage(cursor.getString(21));
//                model.setCode(cursor.getString(14));
//                model.setDesc(cursor.getString(15));
//                modelList.add(model);
//            }while (cursor.moveToNext());
//        }
//
//
//        Log.d("productdata", modelList.toString());
//
//        return modelList;
//    }
    //////show all product offline we w click on subcategory ///////////////////////////////////////
        /* Retrive  filter  ascending data from database */
//    public ArrayList<CartViewItemsBean> getproductdata(int cat_id){
//
//        ArrayList<CartViewItemsBean> modelList = new ArrayList<CartViewItemsBean>();
//
//        String query = "SELECT * FROM " + DATABASE_DATA_TABLE + " WHERE "
//                + DATABASE_CATEGORY_VALUE + "= '" + cat_id + "' " +" OR "
//                + DATABASE_SUB_CATEGORY_VALUE + "= '" + cat_id + "'  ";
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery(query,null);
//        if (cursor.moveToFirst()){
//            do {
//                CartViewItemsBean model = new CartViewItemsBean();
//                model.setImage(cursor.getString(21));
//                model.setCode(cursor.getString(14));
//                model.setDesc(cursor.getString(15));
//                modelList.add(model);
//            }while (cursor.moveToNext());
//        }
//
//
//        Log.d("DatabaseData", modelList.toString());
//
//        return modelList;
//    }

    /* Retrive  filter  ascending data from database */
//    public ArrayList<CartViewItemsBean> getascdata_filter(int cat_id){
//
//        ArrayList<CartViewItemsBean> modelList = new ArrayList<CartViewItemsBean>();
//
//        String query = "SELECT * FROM " + DATABASE_DATA_TABLE + " WHERE "
//                + DATABASE_CATEGORY_VALUE + "= '" + cat_id + "' " +" OR "
//                + DATABASE_SUB_CATEGORY_VALUE + "= '" + cat_id + "' ORDER BY CAST(" + DATABASE_PRICE + " AS DOUBLE) ASC ";
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery(query,null);
//        if (cursor.moveToFirst()){
//            do {
//                CartViewItemsBean model = new CartViewItemsBean();
//                model.setImage(cursor.getString(21));
//                model.setCode(cursor.getString(14));
//                model.setDesc(cursor.getString(15));
//                modelList.add(model);
//            }while (cursor.moveToNext());
//        }
//
//
//        Log.d("productdata", modelList.toString());
//
//        return modelList;
//    }

      /***** sort according to price and brand******/
//    public ArrayList<CartViewItemsBean> getsort_search(int low_p, int highp, String brands, int cat_id, int subcat_id){
//
//        ArrayList<CartViewItemsBean> modelList = new ArrayList<CartViewItemsBean>();
//
//        String query =
//        "SELECT * FROM " + DATABASE_DATA_TABLE + " WHERE (CAST(" + DATABASE_PRICE + " AS int)" + " BETWEEN "+ low_p +" AND " + highp + ") AND (" + DATABASE_CATEGORY_VALUE + "=" + cat_id + " OR " + DATABASE_SUB_CATEGORY_VALUE +"=" + cat_id + ") ORDER BY CAST(" + DATABASE_PRICE + " AS int)";
//
//        //SELECT * FROM Demo_table WHERE  CAST(name AS int) BETWEEN 1 AND 12 OR id= ''
//        //ORDER BY CAST(" + DATABASE_PRICE + " AS int)
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        Log.i("hgfjhg",""+query);
//        Cursor cursor = db.rawQuery(query,null);
//        Log.i("hgfjhg",""+cursor);
//        if (cursor.moveToFirst()){
//            do {
//                CartViewItemsBean model = new CartViewItemsBean();
//                model.setImage(cursor.getString(21));
//                model.setCode(cursor.getString(14));
//                model.setDesc(cursor.getString(15));
//                modelList.add(model);
//            }while (cursor.moveToNext());
//        }
//
//
//        Log.d("productdata", modelList.toString());
//
//        return modelList;
//    }


    /*****CALCULATE TOTAL PRICE OF PRODUCT ADDED IN CART********/
    public Float getTotalPrice(String item_name) {

        float result=0;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT SUM ("+PRODUCT_PRICE+") FROM " + PRODUCT_TABLE + " WHERE " + PRODUCT_NAME + " = '" + item_name + "'" +true+ "'", null);
//        Cursor cursor1 = db.rawQuery("SELECT SUM ("+PRODUCT_PRICE+" * " +PRODUCT_QUANTITY") AS TOTAL FROM " +PRODUCT_TABLE );
//        Cursor cursor = db.rawQuery("SELECT " + PRODUCT_PRICE + " * " + PRODUCT_QUANTITY + " AS result FROM " + PRODUCT_TABLE, null);
        if (cursor.moveToFirst()) {
            result= cursor.getFloat(0);

        }cursor.close();

        // String mResult= String.valueOf(result);
        return result;
    }


    public Float getCartTotalPrice() {

        float result=0;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT SUM ("+PRODUCT_PRICE+ "*" +PRODUCT_QUANTITY+") AS TOTAL FROM " + PRODUCT_TABLE, null);
//        Cursor cursor = db.rawQuery("SELECT SUM ("+PRODUCT_PRICE+") AS TOTAL FROM " +PRODUCT_TABLE,null);
//        Cursor cursor = db.rawQuery("SELECT " + PRODUCT_PRICE + " * " + PRODUCT_QUANTITY + " AS result FROM " + PRODUCT_TABLE, null);
//        Cursor cursor1 = db.rawQuery("SELECT " +PRODUCT_QUANTITY+ " FROM " +PRODUCT_TABLE+ " WHERE " +PRODUCT_NAME+ " = 'Hotels'", null);
        if (cursor.moveToFirst()) {
            result= cursor.getFloat(0);

        }cursor.close();

        // String mResult= String.valueOf(result);
        return result;
    }



    /*************UPDATE CARTVIEW DATA IF PRODUCT IS CHEKED OR UNCHECKED********/
//    public void updatecheckbox(String aTrue, String code, String emailid) {
//
//        Log.d("insert", "before insert");
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(PRODUCT_CB, aTrue);
//       long swl= db.update(PRODUCT_TABLE, values, PRODUCT_CODE + " = '" + code + "' AND " + ACCOUNT +" = '"+ emailid +"'", null);
//        db.close();
//
//        Log.i("insertintoDB", "Afterinsert"+swl);
//
//    }

    /*************Insert Full Update Data**************/
//    public void insertDownloadData(String mainCategoryName, int mainCategoryValue, String subCategoryName, int subCategoryValue, String mainBigThumb, String mainImage, String mainSmallImages, String barcode, String brand, String color, String innerqty, String isOutOfStock, String price, String productDescription, String productcode, String sku_description, String stockQty, String tax_code, String size, String height, String depth,String thumbnail,String outerqty,String subcat_image,String offerprice,String vatpercentage ,String duedate,String isvatapply,String isbestdeal,String itemtype,String isnew,String isspeialoffer,String productvisibility) {
//        Log.d("insert", "before insert");
//
//        // 1. get reference to writable DB
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        // 2. create ContentValues to add key "column"/value
//        ContentValues values = new ContentValues();
//        values.put(DATABASE_CATEGORY_NAME, mainCategoryName);
//        values.put(DATABASE_CATEGORY_VALUE, mainCategoryValue);
//        values.put(DATABASE_SUB_CATEGORY_NAME, subCategoryName);
//      // 3. insert
//        long rowid= db.update(DATABASE_DATA_TABLE,values,DATABASE_PRODUCTCODE + " = '" + productcode + "'AND " + DATABASE_CATEGORY_VALUE + " = '" + mainCategoryValue + "' ", null);
//        if(rowid==0) {
//            db.insert(DATABASE_DATA_TABLE, null, values);
//        }
//        // 4. close
//        db.close();
//        Toast.makeText(context, "insert value", Toast.LENGTH_LONG);
//        Log.i("insert into DB", "After insert");
//        Log.i("bbfDB", "After insert"+values);
//    }
    /***************profile database insert*****************/
//    public void insert_profiledata(String address1, String address2, String city, String subcountry , String county, String name, String postcode, String phone, String mobile,String company_name,String currency, String email,String status) {
//        Log.d("insert", "before insert");
//        // 1. get reference to writable DB
//        SQLiteDatabase db = this.getWritableDatabase();
//        // 2. create ContentValues to add key "column"/value
//        ContentValues values = new ContentValues();
//        values.put(DATABASE_ADDRESS1, address1);
//        values.put(DATABASE_ADDRESS2, address2);
//        values.put(DATABASE_CITY, city);
//
//        Log.i("inserintoBss", "After insert"+values);
//        // 3. insert
//        db.insert(DATABASE_PROFILE, null, values);
//        // 4. close
//        db.close();
//        Toast.makeText(context, "insert value", Toast.LENGTH_LONG);
//
//    }
    /***************** get profile for deliver address***************/
//    public ArrayList<CartViewItemsBean> getprofile_data(String Email){
//        ArrayList<CartViewItemsBean> modelList = new ArrayList<CartViewItemsBean>();
//        String query = " SELECT * FROM " +DATABASE_PROFILE+ " Where "+ DATABASE_EMAIL + " = '" + Email + "'";
//        Log.i("yrdytgfc",""+query);
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery(query,null);
//        if (cursor.moveToFirst()){
//            do {
//                CartViewItemsBean model = new CartViewItemsBean();
//                model.setadd1(cursor.getString(0));
//                model.setadd2(cursor.getString(1));
//                model.setcity(cursor.getString(2));
//                model.setcountry(cursor.getString(3));
//                model.setcounty(cursor.getString(4));
//                model.setname(cursor.getString(5));
//                model.setpostcode(cursor.getString(6));
//                model.setphone(cursor.getString(7));
//                model.setmobile(cursor.getString(8));
//                model.setcompany(cursor.getString(9));
//                model.setcurrency(cursor.getString(10));
//                model.setemail(cursor.getString(11));
//                modelList.add(model);
//                Log.i("fdsgdfzgfd",""+modelList);
//            }while (cursor.moveToNext());
//        }
//
//
//        Log.d("Notificationdata", modelList.toString());
//
//
//        return modelList;
//    }


    /**************check database for address duplication*************/
//    public boolean  checkIntoDB_profile(String address1, String address2) {
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor c = db.rawQuery("SELECT * FROM " + DATABASE_PROFILE + " WHERE "
//                + DATABASE_ADDRESS1 + "= '" + address1 + "' AND " + DATABASE_ADDRESS2 +"='" + address2 + "'",null);
//
//            if (c.getCount() == 0) {
//            Log.i("c.getCount()","" +c.getCount() );
//            return false;
//        } else
//            return true;
//
//
//
//    }

    /*****************report on click details database*******/
//    public int getTnospCount()
//    {
//        // get count number of total no of products stored
//        int count = 0;
//        String countQuery = "SELECT "+DATABASE_PRODUCTCODE +" FROM " + DATABASE_DATA_TABLE;
//
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery(countQuery, null);
//
//        if(cursor != null && !cursor.isClosed()){
//            count = cursor.getCount();
//
//        }
//        cursor.close();
//        return count;
//
//    }

    /***********get count number of categories**********/
//    public int getNocCount() {
//
//        String countQuery = "SELECT Count (Distinct "+ DATABASE_SUB_CATEGORY_NAME + ") FROM " + DATABASE_DATA_TABLE;
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery(countQuery, null);
//        cursor.moveToFirst();
//        int count= cursor.getInt(0);
//        cursor.close();
//        return count;
//
//    }

    /************get the no. of product store in database**********/
//    public List<CartViewItemsBean> getAllReport() { //get total no. of products and no. of categories
//        List<CartViewItemsBean> modelList = new ArrayList<CartViewItemsBean>();
//        String query = "select * from "+DATABASE_DATA_TABLE;
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery(query,null);
//
//        if (cursor.moveToFirst()){
//            do {
//                CartViewItemsBean model = new CartViewItemsBean();
//                model.setReport_code(cursor.getString(14));
//                model.setReport_name(cursor.getString(15));
//                modelList.add(model);
//            }while (cursor.moveToNext());
//        }
//
//
//        Log.d("product data", modelList.toString());
//
//
//        return modelList;
//    }

    /*************update order history table***********/
//    public void update_ohis(String oTitle, String oQty, String oPrice, String oTprice, String oImage, String oOrderid, String address1, String address2, String name,String phone, String emailid,String delivery,String order_type,String order_code) {
//        Log.d("insert", "before insert");
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(ORDERHISTORY_OT, oTitle);
//        values.put(ORDERHISTORY_OQ, oQty);
//
//        Log.i("updater", "After insert"+values);
//        long sql= db.update(CART_TABLE, values, ORDERHISTORY_OI +" = '" + oOrderid + "' AND " + ACCOUNT +" = '" + emailid + "' ", null);
//
//        db.close();
//
//        Log.i("insert into DB", "After insert"+sql);
//    }


    /***********DELETE DATA FROM CART TABLE AFTER ORDERING************/
    public void deletehsARow(String name){
        SQLiteDatabase db= this.getWritableDatabase();
        db.delete(PRODUCT_TABLE, "account" + " = ?", new String[] { name});
        db.close();
    }

    /************getvalue that are added to cart***********/
//    public ArrayList<Order_model> getcartorder(String emailid, String status) {
//        ArrayList<Order_model> modelList = new ArrayList<Order_model>();
//        String query = "select * from "+ CART_TABLE +" Where "+ ACCOUNT + "= '"+ emailid +"'AND " + ORDER_TYPE +" = '"+ status +"' ";
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery(query,null);
//        if (cursor.moveToFirst()){
//            do {
//                Order_model model = new Order_model();
//                model.setunqidss(cursor.getString(0));
//                model.setproduct_name(cursor.getString(1));
//                model.setinner_oty(cursor.getString(2));
//
//                modelList.add(model);
//            }while (cursor.moveToNext());
//        }
//
//
//        Log.d("productdata", modelList.toString());
//
//
//        return modelList;
//    }

     /*************getvalue name***************/
//    public String getname(String emailid) {
//        String attributeNamesubs = null;
//
//        String query = "select * from " + DATABASE_PROFILE + " Where " + DATABASE_EMAIL + "= '" + emailid + "'  AND " + DATABASE_STATUS +" = 'active' ";
//
//
//            SQLiteDatabase db = this.getWritableDatabase();
//            Cursor cursor = db.rawQuery(query, null);
//            if (cursor.moveToFirst()) {
//                do {
//                     attributeNamesubs = cursor.getString(5);
//
//                } while (cursor.moveToNext());
//            }
//
//
//
//            return attributeNamesubs;
//        }


     /**************update product table value******************/

    public void update_carviewpro(String quantity){
        Log.d("insert", "before insert");

        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put(PRODUCT_QUANTITY, quantity);
//        values.put(PRODUCT_NAME,item_name);
        db.update(PRODUCT_TABLE, values, PRODUCT_QUANTITY + " = " + quantity,null);

        db.close();

        Log.i("insert into DB", "After insert " + values);
    }


    public void update_ccartview_quantity(String quantity, String item_name){

        String query = "SELECT " +PRODUCT_NAME+ " FROM " +PRODUCT_TABLE+ " WHERE " +PRODUCT_NAME+ " = '" +item_name+"'" ;

        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery(query,null);
//        String pro_name = new String();
//        if (cursor.moveToFirst()){
//            do {
//
//                pro_name = cursor.getString(0);
//            }while (cursor.moveToNext());
//        }
        String strSQL = "UPDATE " + PRODUCT_TABLE + " SET " +PRODUCT_QUANTITY+ " = '" +quantity+ "' WHERE " +PRODUCT_NAME+ " = '"+item_name+"'" ;
        db.execSQL(strSQL);
        db.close();
        Log.i("insert into DB", "Quantity inserted." );
    }

    /*************SEND ORDER HISTORY DATA TO SERVER**************/
//    public Cursor getAllData(String emailid) {
//        String query = "select * from "+ORDERHISTORY_TABLE+" Where "+ ACCOUNT + "= '"+ emailid +"' AND " + ORDER_STATUSS + " = 'processing'  ORDER BY "+ NOTIFICATION_RID +" DESC ";
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery(query, null);
//        return cursor;
//    }


    /****************UPDATE ORDERHISTORY STATUS************/
//    public void updateorderHS(String emailid,String orderstatus){
//        Log.d("insert", "before insert");
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(ACCOUNT, emailid);
//        values.put(ORDER_STATUSS, orderstatus);
//       long sql= db.update(ORDERHISTORY_TABLE, values, ACCOUNT + " = '" + emailid + "' ", null);
//        db.close();
//        Log.i("insert into DB", "After insert"+sql);
//    }
}