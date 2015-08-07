package com.tubequiz.tubequiz03;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;

public class StationList extends ListActivity {

	private Cursor stations;
	private MyDatabase db;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		db = new MyDatabase(this);
		stations = db.getStations(); // you would not typically call this on the main thread

		ListAdapter adapter = new SimpleCursorAdapter(this,
				android.R.layout.simple_list_item_1,
				stations,
				new String[] {"station_name"},
				new int[] {android.R.id.text1});

		getListView().setAdapter(adapter);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		stations.close();
		db.close();
	}

}
