package com.example.mzikuygulamas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class musicscreen extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    Button btnPlay,btnBack,btnNext;
    TextView textView;
    ListView listView;
    ArrayList<String> arrayList;
    ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musicscreen);
        btnBack=findViewById(R.id.btnback);
        btnPlay=findViewById(R.id.btnPlay);
        btnNext=findViewById(R.id.btnNext);

        TextView textView= (TextView) findViewById(R.id.textView);
        Bundle gelenVeri=getIntent().getExtras();
        CharSequence gelenyazi=gelenVeri.getCharSequence("giden");
        textView.setText(gelenyazi);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



    }
}
