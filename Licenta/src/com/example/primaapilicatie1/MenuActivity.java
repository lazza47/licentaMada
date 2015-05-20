package com.example.primaapilicatie1;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MenuActivity extends ListActivity {

	String[] menu = { "BauturiCaldeActivity", "Racoritoare", "Bere",
			"Cockteils", "Sandwiches" };

	// String[] menus = { "BauturiCaldeActivity", "Racoritoare", "Bere",
	// "Cockteils", "Sandwiches" };

	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);

		String name = menu[position];

		try {
			Class deDeschis = Class.forName("com.example.primaaplicatie1."
					+ name);
			// Class deDeschis = Class.forName("com.example.primaaplicatie1."
			// + name);
			Intent intent = new Intent(MenuActivity.this, deDeschis);
			startActivity(intent);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		}
	}

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// this.setContentView(R.layout.menu);

		setListAdapter(new ArrayAdapter<String>(MenuActivity.this,
				android.R.layout.simple_expandable_list_item_1, menu));

	}

}

// public void onCreate(Bundle savedInstanceState) {
// super.onCreate(savedInstanceState);
// this.setContentView(R.layout.menu);

// }
// }