package com.example.testconnecttootherapps;

import android.app.usage.UsageEvents;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import org.apache.http.protocol.HTTP;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    public void Call (View view) {
        Uri number = Uri.parse("tel:0525839244");
        Intent callIntent = new Intent(Intent.ACTION_CALL, number);
        //Intent callIntent = new Intent(Intent.ACTION_DIAL, number);   //emergency numbers

        startActivity(callIntent);
    }

    public void Email (View view) {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        String file_attached = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC).getPath() + "/" + "test.mp3";
        //Log.d("File Attached", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC).getPath() + "/" + "test.mp3");
        //emailIntent.setType(HTTP.PLAIN_TEXT_TYPE);
        emailIntent.setType("message/rfc822");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"aviyay@gmail.com"});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Email Subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message text");
        emailIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("file:///sdcard/response.txt"));

        startActivity(emailIntent);
    }

    public void Map (View view) {
        Uri location = Uri.parse("geo:31.765037, 35.191282");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);

        startActivity(mapIntent);
    }

    public void Calendar (View view) {
        Intent calendarIntent = new Intent(Intent.ACTION_INSERT, CalendarContract.Events.CONTENT_URI);

        Calendar beginTime = Calendar.getInstance();
        beginTime.set(2015, 9, 27, 15, 30);
        Calendar endTime = Calendar.getInstance();
        endTime.set(2015, 9, 27, 15, 31);

        calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis());
        calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis());
        calendarIntent.putExtra(CalendarContract.Events.TITLE, "ninja class");
        calendarIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, "Secret dojo");


        startActivity(calendarIntent);
    }

    public void Browse (View view) {
        Uri webpage  = Uri.parse("http://www.android.com");
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);

        startActivity(webIntent);
    }
}
