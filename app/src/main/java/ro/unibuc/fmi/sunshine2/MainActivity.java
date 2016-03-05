package ro.unibuc.fmi.sunshine2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Log.v("WeatherApp", "Create");
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
            Intent settingsIntent = new Intent(getApplicationContext(), SettingsActivity.class);
            startActivity(settingsIntent);
            return true;
        } else if (id == R.id.action_map) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            intent.setData(Uri.parse("geo:0,0?q="+pref.getString(getString(R.string.location_key), getString(R.string.default_location))));
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("WeatherApp", "Stop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("WeatherApp", "Resume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("WeatherApp", "Destroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("WeatherApp", "Pause");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v("WeatherApp", "Start");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v("WeatherApp", "Restart");
    }
}
