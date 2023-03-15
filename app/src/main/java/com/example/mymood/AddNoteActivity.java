package com.example.mymood;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddNoteActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText dateTimeEntry, editTextDescription;
    private TextView textViewSuper, textViewGood, textViewNeutral, textViewBad, textViewTerrible;
    private ImageButton imageButtonSuper, imageButtonGood, imageButtonNeutral, imageButtonBad, imageButtonTerrible;
    Calendar calendar = Calendar.getInstance();
    private FloatingActionButton createEntryButton;
    int priority;
    String textViewVisibilityString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        init();
        setInitialDateTime();
        dateTimeEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateTimeDialog(dateTimeEntry);
            }
        });
    }

    private void setInitialDateTime() {
        dateTimeEntry.setText(DateUtils.formatDateTime(this, calendar.getTimeInMillis(),
                DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR | DateUtils.FORMAT_SHOW_TIME));
    }

    private void showDateTimeDialog(final EditText dateTimeEntry) {
        final Calendar calendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        calendar.set(Calendar.MINUTE, minute);
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMMM yyyy, HH:mm");
                        dateTimeEntry.setText(simpleDateFormat.format(calendar.getTime()));
                    }
                };
                new TimePickerDialog(AddNoteActivity.this, timeSetListener, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true).show();

            }
        };
        new DatePickerDialog(AddNoteActivity.this, dateSetListener, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();

    }

    private void init() {
        dateTimeEntry = findViewById(R.id.dateTimeEntry);
        dateTimeEntry.setInputType(InputType.TYPE_CLASS_DATETIME);
        textViewSuper = findViewById(R.id.textViewSuper);
        textViewGood = findViewById(R.id.textViewGood);
        textViewNeutral = findViewById(R.id.textViewNeutral);
        textViewBad = findViewById(R.id.textViewBad);
        textViewTerrible = findViewById(R.id.textViewTerrible);
        imageButtonSuper = findViewById(R.id.imageButtonSuper);
        imageButtonGood = findViewById(R.id.imageButtonGood);
        imageButtonNeutral = findViewById(R.id.imageButtonNeutral);
        imageButtonBad = findViewById(R.id.imageButtonBad);
        imageButtonTerrible = findViewById(R.id.imageButtonTerrible);
        editTextDescription = findViewById(R.id.editTextDescription);
        createEntryButton = findViewById(R.id.createEntryButton);
        imageButtonSuper.setOnClickListener(this);
        imageButtonGood.setOnClickListener(this);
        imageButtonNeutral.setOnClickListener(this);
        imageButtonBad.setOnClickListener(this);
        imageButtonTerrible.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imageButtonSuper:
                setVisibleSmiling(view);
                textViewSuper.setVisibility(View.VISIBLE);
                textViewVisibilityString = String.valueOf(R.string.name_smiling_super);
                priority = 1;
                break;
            case R.id.imageButtonGood:
                setVisibleSmiling(view);
                textViewGood.setVisibility(View.VISIBLE);
                textViewVisibilityString = String.valueOf(R.string.name_smiling_good);
                priority = 2;
                break;
            case R.id.imageButtonNeutral:
                setVisibleSmiling(view);
                textViewNeutral.setVisibility(View.VISIBLE);
                textViewVisibilityString = String.valueOf(R.string.name_smiling_neutral);
                priority = 3;
                break;
            case R.id.imageButtonBad:
                setVisibleSmiling(view);
                textViewBad.setVisibility(View.VISIBLE);
                textViewVisibilityString = String.valueOf(R.string.name_smiling_bad);
                priority = 4;
                break;
            case R.id.imageButtonTerrible:
                setVisibleSmiling(view);
                textViewTerrible.setVisibility(View.VISIBLE);
                textViewVisibilityString = String.valueOf(R.string.name_smiling_terrible);
                priority = 5;
                break;
            default:
                setVisibleSmiling(view);
        }
    }

    private void setVisibleSmiling(View view) {
        textViewSuper.setVisibility(View.INVISIBLE);
        textViewGood.setVisibility(View.INVISIBLE);
        textViewNeutral.setVisibility(View.INVISIBLE);
        textViewBad.setVisibility(View.INVISIBLE);
        textViewTerrible.setVisibility(View.INVISIBLE);
        textViewVisibilityString = "";
        priority = 0;
    }
}