package app.buusk15.sqlite_599;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class ShowActivity extends Activity {
	private ListView ListView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show);
		
		ListView = (ListView)findViewById(R.id.listView1);
		
		control599DB control599db = new control599DB(this);
		ArrayList<HashMap<String, String>> arrayList = control599db.SelectAllData();
		
		SimpleAdapter adapter;
		adapter = new SimpleAdapter(ShowActivity. this, 
									arrayList, 
									R.layout.show_item, 
									new String[] {"MemberID","Name","Tel"}, 
									new int[] {R.id.ColMemberID, R.id.ColName, R.id.ColTel});
							
		ListView.setAdapter(adapter);
	}
}

