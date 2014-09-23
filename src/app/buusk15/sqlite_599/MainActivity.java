package app.buusk15.sqlite_599;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends ActionBarActivity {

	SQLiteDatabase db;
	private Button btninsert, btnshow, btnupdate, btndelete;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//control599DB control599db = new control599DB(this);
		//control599db.getWritableDatabase();
		
		btninsert = (Button) findViewById(R.id.btn_insert);
		btnshow = (Button) findViewById(R.id.btn_show);
		btnupdate = (Button) findViewById(R.id.btn_update);
		btndelete = (Button) findViewById(R.id.btn_delete);
		btninsert.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(), AddActivity.class);
				startActivity(intent);
			}
		});
		
		btnshow.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent showdata = new Intent(getApplicationContext(), ShowActivity.class);
				startActivity(showdata);
			}
		});
	
		btnupdate.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				control599DB db = new control599DB(MainActivity.this);
				db.UpdateData("1", "A", "0875686969");
			}
		});
		
		btndelete.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				control599DB db = new control599DB(MainActivity.this);
				db.DeleteData("2");
			}
		});
	}
}
