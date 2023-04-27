package com.example.speechapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class texttospeech extends AppCompatActivity {

    EditText e1;
    Button b1;
    TextToSpeech tts;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_texttospeech);
        e1=findViewById(R.id.e1);
        b1=findViewById(R.id.button3);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tts=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if(status==TextToSpeech.SUCCESS) {
                            tts.setLanguage(Locale.ENGLISH);
                            tts.setSpeechRate(1.0f);
                            tts.speak(e1.getText().toString(), TextToSpeech.QUEUE_ADD, null);

                        }
                    }
                });
            }
        });
    }
}