package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author Hadar Malul
 * @since 28.12.19
 */

public class MainActivity extends AppCompatActivity {

    TextView tv;
    EditText et;
    int count, number;
    String st;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.tv);
        et = (EditText) findViewById(R.id.et);

        /**
         * Reading the text file "NAME_NUM" to the TextView & EditText widgets in the screen
         */

        SharedPreferences settings = getSharedPreferences("NAME_NUM", MODE_PRIVATE);
        number = settings.getInt("Count", 1);
        st = settings.getString("name", "Name");

        tv.setText("" + number);
        et.setText("" + st);

    }

    /**
     * each click the number in the TextView is +1
     * @param view
     */

    public void count(View view) {
        tv.setText (""+number++);
        count = number;
    }

    /**
     * resets the TextView
     * @param view
     */

    public void reset(View view) {
        tv.setText("0");
        number = 1;
    }

    /**
     * Writing to text file "NAME_NUM" from the text the user typed
     * ansd the last number that is shown in the TextView
     * @param view
     */

    public void exit(View view) {
        st = et.getText().toString();
        SharedPreferences settings = getSharedPreferences("NAME_NUM", MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("Count", count);
        editor.putString("name",st);
        editor.commit();

        finish();


    }
}
