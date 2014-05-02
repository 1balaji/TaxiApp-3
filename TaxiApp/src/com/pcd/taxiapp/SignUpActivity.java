package com.pcd.taxiapp;

import java.io.IOException;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class SignUpActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sign_up);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);
	}
	public void register(View view) throws IOException {
		
		EditText inputnom=(EditText) findViewById(R.id.nom);
		EditText inputprenom=(EditText) findViewById(R.id.prenom);
		EditText inputvoiture=(EditText) findViewById(R.id.voiture);
		String nom= inputnom.getText().toString();
		String prenom= inputprenom.getText().toString();
		String voiture= inputvoiture.getText().toString();
		String urladr="http://192.168.1.7/RestfulProject/REST/WebService/AddDriver/"+nom+"/"+prenom+"/"+voiture;
		ServiceHandler sh=new ServiceHandler();
		sh.makeServiceCall(urladr, ServiceHandler.POST);
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sign_up, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_sign_up,
					container, false);
			return rootView;
		}
	}

}
