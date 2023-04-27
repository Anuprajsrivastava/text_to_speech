package com.example.speechapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
//import android.widget.TextView;
//import android.widget.TextView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView txt,hintgiv;
    ImageButton btn;
     Integer count=0;

    SpeechRecognizer speechRecognizer;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = findViewById(R.id.txt);
        btn = findViewById(R.id.btn);
        hintgiv=findViewById(R.id.hintgiv);
        hintgiv.setText("Tap To Speak");
        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECORD_AUDIO}, 100);

        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count==0){
                    btn.setImageDrawable(getDrawable(R.drawable.baseline_mic_24));
                    speechRecognizer.startListening(intent);
                    hintgiv.setText("");
                    txt.setText("Listenning......");
                    count=1;
                }else{
                    btn.setImageDrawable(getDrawable(R.drawable.baseline_mic_off_24));
                    speechRecognizer.stopListening();
                    txt.setText("");
                    hintgiv.setText("Tap to Speak");
                    count=0;
                }
            }
        });

        speechRecognizer.setRecognitionListener(new RecognitionListener() {
            @Override
            public void onReadyForSpeech(Bundle params) {

            }

            @Override
            public void onBeginningOfSpeech() {

            }

            @Override
            public void onRmsChanged(float rmsdB) {

            }

            @Override
            public void onBufferReceived(byte[] buffer) {

            }

            @Override
            public void onEndOfSpeech() {

            }

            @Override
            public void onError(int error) {
                txt.setText("something wrent wrong");
                count=0;
                hintgiv.setText("Tap to speak");
                btn.setImageDrawable(getDrawable(R.drawable.baseline_mic_off_24));

            }

            @Override
            public void onResults(Bundle results) {
                ArrayList<String> data=results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
                txt.setText('"'+ data.get(0)+ '"');
                hintgiv.setText("Tap to speak");
                btn.setImageDrawable(getDrawable(R.drawable.baseline_mic_off_24));
                count=0;

            }

            @Override
            public void onPartialResults(Bundle partialResults) {

            }

            @Override
            public void onEvent(int eventType, Bundle params) {

            }
        });

    }
    @Override
    public void onRequestPermissionsResult ( int requestCode, @NonNull String[] permissions,
                                             @NonNull int[] grantResults){
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "permission granted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "permission not granted", Toast.LENGTH_SHORT).show();
            }
        }
    }
}