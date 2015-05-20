package com.example.primaapilicatie1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogInActivity extends Activity {

	EditText name;
	EditText pass;
	Button logIn;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.login);

		name = (EditText) findViewById(R.id.editUname);
		pass = (EditText) findViewById(R.id.editPass);
		logIn = (Button) findViewById(R.id.btnLogIn);

		logIn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				String userName = name.getText().toString();
				String password = pass.getText().toString();

				if (Restaurant.getMasaDupaNumeSiParola(userName, password) != null) {
					Intent intent = new Intent(v.getContext(),
							MenuActivity.class);
					startActivityForResult(intent, 0);

				} else {
					Toast.makeText(LogInActivity.this,
							"Userul si parola nu se potrivesc !",
							Toast.LENGTH_SHORT).show();

				}
				// } while (!parolaCorecta);

				// if ((uname.equals("masa1") && password.equals("abcd1x"))
				// || (uname.equals("masa2") && password.equals("abcd2y"))
				// || (uname.equals("masa3") && password.equals("abcd3z"))
				// || (uname.equals("masa4") && password.equals("abcd4t"))
				// || (uname.equals("masa5") && password.equals("abcd5u"))
				// || (uname.equals("masa6") && password.equals("abcd6v"))
				// || (uname.equals("masa7") && password.equals("abcd7w"))
				// || (uname.equals("masa8") && password.equals("abcd8o"))
				// || (uname.equals("masa9") && password.equals("abcd9p"))
				// || (uname.equals("masa10") && password
				// .equals("abcd10q"))) {
				//
				// Intent intent = new Intent(v.getContext(),
				// MenuActivity.class);
				// startActivityForResult(intent, 0);
				// } else {
				// Toast.makeText(LogInActivity.this,
				// "User and Password are don't matching",
				// Toast.LENGTH_SHORT).show();
				// logIn.setEnabled(false);
				// }
				//
			}
		});
	}
}
