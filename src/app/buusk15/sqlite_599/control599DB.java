package app.buusk15.sqlite_599;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class control599DB extends SQLiteOpenHelper{
	private static final String DATABASE_NAME= "mydata599";
	private static final String TABLE_MEMBER = "members";
	private static final int DATABASE_VERSION =1;

	public control599DB(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("CREATE TABLE " + TABLE_MEMBER
				+ "(MemberId INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "Name TEXT(100),"
				+ "Tel TEXT(100)); ");
		Log.d("CREATE TABLE", "Create Table Successfully");
		
		
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_MEMBER);
		onCreate(db);
		
	
		
	}
	
	public long InsertData(String strName, String strTel) {
		// INSERT INTO Members(Name, Tel) Values('A','0485959656')
		// INSERT INTO Members(Name, Tel) Values('B','0485989656')
		try {
			SQLiteDatabase db;
			db = this.getWritableDatabase(); // ใช้คู่กับ INsert, update, delete
			ContentValues values = new ContentValues();
			values.put("Name", strName);
			values.put("Tel", strTel);
			long l = db.insert(TABLE_MEMBER, null, values);//
			db.close();
			return l;
		} catch (Exception e) {
			return -1;
		}
	}
	
	public long UpdateData(String strMemberID, String strName, String strTel) {
		//UPDATE Members SET Name=?, Tel=? WHERE MemberID=?
		try {
			SQLiteDatabase db;
			db = this.getWritableDatabase(); // ใช้คู่กับ INsert, update, delete
			ContentValues values = new ContentValues();
			values.put("Name", strName);
			values.put("Tel", strTel);
			long l = db.update(TABLE_MEMBER, values, "MemberID=?", new String[] {strMemberID});//
			db.close();
			return l;
		} catch (Exception e) {
			return -1;
		}
	}
	
	public long DeleteData(String strMemberID) { 
		//DELETE Members WHERE MembersID=?
		try {
			SQLiteDatabase db;
			db = this.getWritableDatabase(); // ใช้คู่กับ INsert, update, delete
			long l = db.delete(TABLE_MEMBER, "MemberID=?", new String[] {strMemberID});//
			db.close();
			return l;
		} catch (Exception e) {
			return -1;
		}
	}
	
public String[] CheckData(String strMemberID) {
    try {
        String arrData[] = null;
        SQLiteDatabase db;
        db = this.getReadableDatabase();
        // SELECT * FROM Members WHERE MemberID=?
        Cursor cursor = db.query(TABLE_MEMBER, 
				        		new String[] { "*" },
				                "MemberID=?", 
				                new String[] { String.valueOf(strMemberID)},
				                null, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
            	// String arraData[] = new String[4];
                arrData = new String[cursor.getColumnCount()]; // จำนวนคอลัมภ์
                arrData[0] = cursor.getString(0);
                arrData[1] = cursor.getString(1);
                arrData[2] = cursor.getString(2);
            }
        }
        cursor.close();
        db.close();
        return arrData;
    } catch (Exception e) {
        return null;
    }
}
   //Select All
    public ArrayList<HashMap<String,String>> SelectAllData(){
    	try{
    		ArrayList<HashMap<String, String>> MyArrayList =
    				new ArrayList<HashMap<String, String>>();
    		HashMap<String, String> map;
    		
    		SQLiteDatabase db;
    		db = this.getReadableDatabase();
    		// SELECT, INSERT, UPDATE, DELETE
    		// SELECT * FROM Members
    		
    		String strSQL = "SELECT * FROM " + TABLE_MEMBER;
    		Cursor cursor = db.rawQuery(strSQL, null);
    		int rows = cursor.getCount();
    		if(cursor !=null){
    			if(cursor.moveToFirst()){
    				do{
    					map = new HashMap<String, String>();
    					map.put("MemberID", cursor.getString(0));
    					map.put("Name", cursor.getString(1));
    					map.put("Tel", cursor.getString(2));
    					MyArrayList.add(map);
    				}while (cursor.moveToNext());
    			}
    		}
    		cursor.close();
    		db.close();
    		return MyArrayList;
    		 }catch (Exception e) {
    	return null;
    		 }
}
}