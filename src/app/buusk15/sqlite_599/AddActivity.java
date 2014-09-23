package app.buusk15.sqlite_599;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends Activity{
	
	private EditText edit1,edit2;
	private Button btn_save;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add);
		
		edit1 = (EditText) findViewById(R.id.edit_name);
		edit2 = (EditText) findViewById(R.id.edit_tel);
		btn_save = (Button) findViewById(R.id.btn_show);
		
		btn_save.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(v == btn_save){
					Save();
				}
					
				
			}
		});
	}
	
	public boolean Save(){
		// สร้าง Popup
		final AlertDialog.Builder adb = new AlertDialog.Builder(this);
		AlertDialog ad = adb.create();
		/////////////////////
		
		if (edit1.getText().length() == 0) {
			ad.setMessage("Please input Name"); // ใส่ข้อมูลใน popup
			ad.show();
			edit1.requestFocus(); // ให้เคอร์เซอร์แสดงไว้
			return false;
		}
		
		if (edit2.getText().length() == 0) {
			ad.setMessage("Please input Tel"); // ใส่ข้อมูลใน popup
			ad.show();
			edit2.requestFocus(); // ให้เคอร์เซอร์แสดงไว้
			return false;
		}
		
		control599DB dbClass = new control599DB(this);
		long savedata = dbClass.InsertData(edit1.getText().toString(), 
										   edit2.getText().toString());
		if (savedata <= 0) {
			ad.setMessage("Error !!!!");  // ใส่ข้อมูลใน popup
			ad.show();
			return false;
		}
		Toast.makeText(getApplicationContext(), "Add Data Successfully",
				Toast.LENGTH_SHORT).show();
		return true;
		
	}
}
