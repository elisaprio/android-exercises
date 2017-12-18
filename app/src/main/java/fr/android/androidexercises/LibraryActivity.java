package fr.android.androidexercises;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Date;

public class LibraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button openButton = findViewById(R.id.openButton);
        Button datePicker = findViewById(R.id.datePicker);

        Book book = new Book("Garry Whopper", "CK Rowling");

        openButton.setOnClickListener(v -> {
            Intent intent = new Intent(LibraryActivity.this, BookActivity.class);
            // TODO add parcel book to intent

            intent.putExtra(BookActivity.BOOK,book);
            startActivity(intent);
        });

        datePicker.setOnClickListener(v -> {
            new DatePickerDialog(LibraryActivity.this,new DatePickerDialog.OnDateSetListener(){
                public void onDateSet(DatePicker view, int year, int month, int day){
                    new AlertDialog.Builder(LibraryActivity.this).setMessage(day+"/"+(month+1)+"/"+year).show();
                    //Toast.makeText(LibraryActivity.this,day+"/"+(month+1)+"/"+year,Toast.LENGTH_SHORT).show();
                }
            }, 2017, 11, 18).show();

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_library, menu);
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
