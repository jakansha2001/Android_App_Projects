package com.akansha.calendar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private int currentYear = 0;
    private int currentMonth = 0;
    private int currentDay = 0;

    private  int daysIndex = 0;
    CalendarView calendarView;
    TextView myDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calendarView = (CalendarView) findViewById(R.id.calendarView);
        myDate = (TextView) findViewById(R.id.myDate);
        final List<String> calenderStrings = new ArrayList<>();
        final int[] days = new int[30];
        final EditText textInput = findViewById(R.id.textInput);
        final View dayContent = findViewById(R.id.dayContent);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                String date = "Selected Date: " + i2 + "/" + (i1 + 1) + "/" + i;
                myDate.setText(date);
                currentYear = i;
                currentMonth = i1;
                currentDay = i2;
                if(dayContent.getVisibility() == calendarView.GONE) {
                    dayContent.setVisibility(calendarView.VISIBLE);
                }
                for(int j=0;j<30;j++){
                    if(days[j] == currentDay){
                        textInput.setText(calenderStrings.get(j));
                        return;
                    }
                }
                textInput.setText("");
            }
        });


       final Button saveTextButton = findViewById(R.id.saveTextButton);



        saveTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                days[daysIndex] = currentDay;

                calenderStrings.add(daysIndex,textInput.getText().toString());
                daysIndex++;
                //calenderStrings.add(textInput.getText().toString());
                textInput.setText("");
            }
        });
    }
    public void googlenews(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://news.google.com/topstories?hl=en-IN&gl=IN&ceid=IN:en"));
        startActivity(browserIntent);
    }
    public void googleweather(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=google+weather"));
        startActivity(browserIntent);
    }
}