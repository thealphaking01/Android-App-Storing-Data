package com.example.abdur.storingdata;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends Activity {

    TextView name,phone;
    public static final String Name="nameKey",Phone="phoneKey",MyPreferences="MyPrefs";

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=(TextView)findViewById(R.id.editTextName);
        phone=(TextView)findViewById(R.id.editTextPhone);

        sharedPreferences= getSharedPreferences(MyPreferences, Context.MODE_PRIVATE);
        if(sharedPreferences.contains(Name))
        {
            name.setText(sharedPreferences.getString(Name,""));
        }
        if(sharedPreferences.contains(Phone))
        {
            phone.setText(sharedPreferences.getString(Phone,""));
        }
    }

    public void run(View view)
    {
        String n=name.getText().toString();
        String p=phone.getText().toString();

        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putString(Name,n+"saved data");
        editor.putString(Phone,p+"saved data");
        editor.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
