package com.example.mymood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetailAffirmationActivity extends AppCompatActivity {

    public static final String AFFIRMATION_ID = "affirmationId";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_affirmation);
        String title = getIntent().getStringExtra("Title");
        String time = getIntent().getStringExtra("Time");
        String description = getIntent().getStringExtra("Description");
        int photo = getIntent().getIntExtra("Photo",0);

        TextView titleTextView = (TextView) findViewById(R.id.titleDetailAffirmationTextView);
        TextView timeTextView = (TextView) findViewById(R.id.timeDetailAffirmationTextView);
        TextView descriptionTextView = (TextView) findViewById(R.id.descriptionDetailAffirmationTextView);
        ImageView photoImageView = (ImageView) findViewById(R.id.photoDetailAffirmationImageView);

        titleTextView.setText(title);
        timeTextView.setText(time);
        descriptionTextView.setText(description);
        photoImageView.setImageResource(photo);
    }
}