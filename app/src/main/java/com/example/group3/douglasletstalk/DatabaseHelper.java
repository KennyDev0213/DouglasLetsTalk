package com.example.group3.douglasletstalk;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    // ************** ADMIN ***********************************
    // CASHIER (AdminID, AdminName, AdminPassword)
    // Primary Key = AdminID
    private static final String ADMIN_TABLE = "ADMIN";
    private static final String ADMIN_ID_COL = "AdminID";
    private static final String ADMIN_NAME_COL = "AdminName";
    private static final String ADMIN_PASSWORD_COL = "AdminPassword";
    private static final String createAdminTable = "CREATE TABLE " + ADMIN_TABLE +
            "(" +
            ADMIN_ID_COL + " TEXT PRIMARY KEY, " +
            ADMIN_NAME_COL + " TEXT, " +
            ADMIN_PASSWORD_COL + " TEXT " +
            ");";
    private static final String dropAdminTable = "DROP TABLE if exists " + ADMIN_TABLE + ";";
    // ************** Person ***********************************

    private static final String PERSON_TABLE = "PERSON";
    private static final String PERSON_USER_ID_COL = "UserID";
    private static final String PERSON_USERNAME_COL = "UserName";
    private static final String PERSON_DATE_COL = "DateOfJoin";
    private static final String PERSON_PASSWORD_COL = "Password";
    private static final String createPersonTable = "CREATE TABLE " + PERSON_TABLE +
            "(" +
            PERSON_USER_ID_COL + " TEXT PRIMARY KEY, " +
            PERSON_USERNAME_COL + " TEXT, " +
            PERSON_DATE_COL + " TEXT, " +
            PERSON_PASSWORD_COL + " TEXT " +
            ");";
    private static final String dropPersonTable = "DROP TABLE if exists " + PERSON_TABLE + ";";

    // ************** Event ***********************************

    private static final String EVENT_TABLE = "EVENT";
    private static final String EVENT_ID_COL = "EventID";
    private static final String EVENT_COORDINATOR_COL = "CoordinatorID";
    private static final String EVENT_DATE_COL = "DateOfCreation";
    private static final String createEventTable = "CREATE TABLE " + EVENT_TABLE +
            "(" +
            EVENT_ID_COL + " TEXT PRIMARY KEY, " +
            EVENT_COORDINATOR_COL + " TEXT, " +
            EVENT_DATE_COL + " TEXT, " +
            " FOREIGN KEY ("+EVENT_COORDINATOR_COL+") REFERENCES " +  PERSON_TABLE + "("+PERSON_USER_ID_COL + ")" +
            ");";

    private static final String dropEventTable = "DROP TABLE if exists " + EVENT_TABLE + ";";
    // ************** EventMembers ***********************************

    private static final String EVENTMEMBERS_TABLE = "EventMembers";
    private static final String EVENTMEMBERS_ID_COL = "EventMembersID";
    private static final String EVENTMEMBERS_EVENT_ID_COL = "EventID";
    private static final String EVENTMEMBERS_PERSON_ID_COL = "PersonID";
    private static final String createEventMembersTable = "CREATE TABLE " + EVENTMEMBERS_TABLE +
            "(" +
            EVENTMEMBERS_ID_COL + " TEXT PRIMARY KEY, " +
            EVENTMEMBERS_EVENT_ID_COL + " TEXT, " +
            EVENTMEMBERS_PERSON_ID_COL + " TEXT, " +
            " FOREIGN KEY ("+EVENTMEMBERS_EVENT_ID_COL+") REFERENCES " +  EVENT_TABLE + "("+EVENT_ID_COL + "), " +
            " FOREIGN KEY ("+EVENTMEMBERS_PERSON_ID_COL+") REFERENCES " +  PERSON_TABLE + "("+PERSON_USER_ID_COL + ")" +
            ");";

    private static final String dropEventMembersTable = "DROP TABLE if exists " + EVENTMEMBERS_TABLE + ";";
    //-----------------------------------------------------------------------------------------

    private final static String DATABASE_NAME = "LetsTalk.db";
    private final static int DATABASE_VERSION = 1;
    private static final String TAG = "DBHelper";

    private static DatabaseHelper instance;

    public static synchronized DatabaseHelper getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseHelper(context.getApplicationContext());
        }
        return instance;
    }

    private DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(createAdminTable);
        Log.d(TAG,"ADMIN table has been created");
        sqLiteDatabase.execSQL(createPersonTable);
        Log.d(TAG, "Person Table has been created");
        sqLiteDatabase.execSQL(createEventTable);
        Log.d(TAG, "Event table has been created");
        sqLiteDatabase.execSQL(createEventMembersTable);
        Log.d(TAG, "EventMembers table has been created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        if(oldVersion != newVersion){
            sqLiteDatabase.execSQL(dropAdminTable);
            sqLiteDatabase.execSQL(dropEventTable);
            sqLiteDatabase.execSQL(dropPersonTable);
            sqLiteDatabase.execSQL(dropEventMembersTable);
            onCreate(sqLiteDatabase);
        }

    }

    // ********************** ADMIN ****************************************************

    public boolean checkIfAdminExists(String adminId, String adminPassword){
        String query = "SELECT * FROM " + ADMIN_TABLE + " WHERE " +
                ADMIN_ID_COL + " = '" + adminId + "' AND " +
                ADMIN_PASSWORD_COL + " = '" + adminPassword + "';";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        boolean status = false;
        if(cursor.moveToFirst()){
            status = true;
        }
        else{
            status = false;
        }
        cursor.close();
        db.close();
        return status;
    }

    public void insertAdmin(Admin admin){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ADMIN_ID_COL,admin.getId());
        values.put(ADMIN_NAME_COL,admin.getName());
        values.put(ADMIN_PASSWORD_COL,admin.getPassword());
        db.insert(ADMIN_TABLE,null,values);
        db.close();
    }

    public String getAdminId(String adminId){
        String query = "SELECT " + ADMIN_ID_COL + " FROM " + ADMIN_TABLE + " WHERE " + ADMIN_ID_COL + " = '" + adminId + "';";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        String id = null;
        if (cursor.moveToFirst()){
            id = cursor.getString(0);
        }
        cursor.close();
        db.close();
        return id;
    }

    public Admin getAdminById(String adminId){
        String query = "SELECT * FROM " + ADMIN_TABLE + " WHERE " + ADMIN_ID_COL + " = '" + adminId + "';";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        Admin admin = null;
        if(cursor.moveToFirst()){
            String name = cursor.getString(1);
            String password = cursor.getString(2);
            admin = new Admin(adminId,name,password);
        }
        cursor.close();
        db.close();
        return admin;
    }



    // ********************** Person **************************************************
    public Person getPersonById(String userID) {
        String query = "SELECT * FROM " + PERSON_TABLE + " WHERE " + PERSON_USER_ID_COL + " = '" + userID + "';";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Person person = null;
        if (cursor.moveToNext()) {
            String userName = cursor.getString(1);
            String dateOfBirth = cursor.getString(2);
            String password = cursor.getString(3);
            person = new Person(userID, userName, dateOfBirth, password);
        }
        cursor.close();
        db.close();
        return person;
    }

    public boolean removePersonById(String userID) {
        String query = "SELECT * FROM " + PERSON_TABLE + " WHERE " + PERSON_USER_ID_COL + " = '" + userID + "';";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.getCount() > 0 ) {
            long result = db.delete("PERSON_TABLE", "userID=?", new String[] {userID});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public void insertPerson(Person person) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PERSON_USER_ID_COL, person.getUserID());
        values.put(PERSON_USERNAME_COL, person.getUserName());
        values.put(PERSON_DATE_COL, person.getDateOfJoin());
        values.put(PERSON_PASSWORD_COL, person.getPassword());
        db.insert(PERSON_TABLE, null, values);
        db.close();
    }

    //authenticate user
    public boolean checkIfPersonExists(String userId, String userPassword){
        String query = "SELECT * FROM " + PERSON_TABLE + " WHERE " +
                PERSON_USER_ID_COL + " = '" + userId + "' AND " +
                PERSON_PASSWORD_COL + " = '" + userPassword + "';";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        boolean status = false;
        if(cursor.moveToFirst()){
            status = true;
        }
        else{
            status = false;
        }
        cursor.close();
        db.close();
        return status;
    }

    //check the person exists or not
    public boolean checkIfPersonExists(String userId){
        String query = "SELECT * FROM " + PERSON_TABLE + " WHERE " +
                PERSON_USER_ID_COL + " = '" + userId + "';";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        boolean status = false;
        if(cursor.moveToFirst()){
            status = true;
        }
        else{
            status = false;
        }
        cursor.close();
        db.close();
        return status;
    }



    // ********************** Event **************************************************
    public Event getEventById(String eventID) {
        String query = "SELECT * FROM " + EVENT_TABLE + " WHERE " + EVENT_ID_COL + " = '" + eventID + "';";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Event event = null;
        if (cursor.moveToNext()) {
            String coordinatorID = cursor.getString(1);
            String dateOfCreation = cursor.getString(2);
            event = new Event(eventID, coordinatorID, dateOfCreation);
        }
        cursor.close();
        db.close();
        return event;
    }

    public boolean removeEventById(String eventID) {
        String query = "SELECT * FROM " + EVENT_TABLE + " WHERE " + EVENT_ID_COL + " = '" + eventID + "';";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.getCount() > 0 ) {
            long result = db.delete("EVENT_TABLE", "eventID=?", new String[] {eventID});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public void insertEvent(Event event) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(EVENT_ID_COL, event.getGroupID());
        values.put(EVENT_COORDINATOR_COL, event.getCoordinatorID());
        values.put(EVENT_DATE_COL, event.getDateOfCreation());
        db.insert(EVENT_TABLE, null, values);
        db.close();
    }

    public String[] getEventsAvailable() {
        String query = "SELECT " + EVENT_ID_COL + " FROM " + EVENT_TABLE + " ;";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        String[] events = null;
        int i =0;
        while(cursor.moveToNext()){
            events[i] = cursor.getString(0);
            i++;
        }
        return events;
    }

    // ********************** EventMembers **************************************************


}
