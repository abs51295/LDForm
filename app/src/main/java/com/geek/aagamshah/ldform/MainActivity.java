package com.geek.aagamshah.ldform;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RatingBar ratingBar = (RatingBar)findViewById(R.id.ratingbar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                String rate = String.valueOf(rating);
                Toast.makeText(getApplicationContext(), rate, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
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

    public void submit(View v) {
        EditText editText = (EditText) findViewById(R.id.username);
        String user = editText.getText().toString();
        editText = (EditText) findViewById(R.id.password);
        String pass = editText.getText().toString();
        if (user.equals("") || pass.equals("")) {
            Toast.makeText(getApplicationContext(), "Please enter all details", Toast.LENGTH_SHORT).show();
        } else if (user.equals("Aagam") && pass.equals("123")) {
            Intent intent = new Intent(this, WelcomeActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Please enter username as Aagam and password as 123", Toast.LENGTH_SHORT).show();
        }
    }

    public void radio(View v){
        Boolean checked= ((RadioButton)v).isChecked();

        switch (v.getId()){
            case R.id.male:
                if(checked){
                    Toast.makeText(getApplicationContext(), "You are Male!", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.female:
                if(checked){
                    Toast.makeText(getApplicationContext(), "You are Female!", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    public void checkbox(View view){
        Boolean checked = ((CheckBox)view).isChecked();

        switch (view.getId()){
            case R.id.email:
                if (checked){
                    Toast.makeText(getApplicationContext(), "You selected Mail", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "You removed Mail!", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.whatsapp:
                if (checked){
                    Toast.makeText(getApplicationContext(), "You selected whatsapp!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "You deselected whatsapp!", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

}
