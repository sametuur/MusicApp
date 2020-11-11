package com.example.mzikuygulamas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> arrayList;
    ArrayAdapter adapter;
    MediaPlayer mediaPlayer;
    ConstraintLayout conteyner;
    Button back , btnPlay, btnNext,btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //listview ve array listi kullanabilmek için tanıttık.
        listView= findViewById(R.id.listView);
        conteyner = findViewById(R.id.conteyner);
        arrayList= new ArrayList<String>();
        back = findViewById(R.id.back);



        Field[] fields = R.raw.class.getFields();
        for (int i = 0; i <fields.length;++i){
            arrayList.add(fields[i].getName());

        }
        adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(adapter);
        /////listviewdeki eleamnlara tıklandıkça yapılacğı işlemi söyledik
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                int tasiyici = getResources().getIdentifier(arrayList.get(i),"raw",getPackageName());
               if(mediaPlayer!=null){
                   mediaPlayer.release();
                }else{
                   mediaPlayer= MediaPlayer.create(MainActivity.this,tasiyici);
                   mediaPlayer.start();
               }
                conteyner.setVisibility(View.VISIBLE);
                listView.setVisibility(View.INVISIBLE);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                conteyner.setVisibility(View.INVISIBLE);
                listView.setVisibility(View.VISIBLE);
            }
        });

        }
    }
