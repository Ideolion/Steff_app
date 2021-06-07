package com.example.ashram_app.AddYoutubeVideo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ashram_app.AddVideo.AddVideoActivity;
import com.example.ashram_app.MainActivity;
import com.example.ashram_app.R;
import com.google.firebase.database.DatabaseReference;

public class AddYoutubeVideo extends AppCompatActivity {
    EditText YoutubeURL;
    String URL;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_youtube_video);
    }

    public void back(View view) {

        Intent i = new Intent(AddYoutubeVideo.this, MainActivity.class);
        startActivity(i);
        //finish();


    }

    public void UploadLink(View view) {
        YoutubeURL = findViewById(R.id.YoutubeURL);
        URL = YoutubeURL.getText().toString();


       // https://youtu.be/mdd27VwuWQ0
        FirebaseFirestore db = FirebaseFirestore.getInstance();




    }

}