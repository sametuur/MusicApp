package com.example.mzikuygulamas;

import androidx.annotation.MainThread;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> arrayList;
    ArrayAdapter adapter;
    MediaPlayer mediaPlayer;
    ConstraintLayout conteyner;
    Button back , btnPlay, btnNext,btnback,btnstop;
    ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //listview ve array listi kullanabilmek için tanıttık.
        listView= findViewById(R.id.listView);
        conteyner = findViewById(R.id.conteyner);
        arrayList= new ArrayList<String>();
        back = findViewById(R.id.back);
        btnPlay = findViewById(R.id.btnPlay);
        btnNext = findViewById(R.id.btnNext);
        btnback = findViewById(R.id.btnback);
        btnstop = findViewById(R.id.btnstop);
        img = findViewById(R.id.imageView);



        Field[] fields = R.raw.class.getFields();
        for (int i = 0; i <fields.length;++i){
            arrayList.add(fields[i].getName());

        }
        adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, final int i, long id) {

               if(mediaPlayer!=null){
                   mediaPlayer.release();
                }
                   int tasiyici = getResources().getIdentifier(arrayList.get(i),"raw",getPackageName());
                   mediaPlayer=MediaPlayer.create(MainActivity.this,tasiyici);
                   btnPlay.setVisibility(View.INVISIBLE);
                   btnstop.setVisibility(View.VISIBLE);
                   mediaPlayer.start();





                conteyner.setVisibility(View.VISIBLE);
                listView.setVisibility(View.INVISIBLE);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        conteyner.setVisibility(View.INVISIBLE);
                        listView.setVisibility(View.VISIBLE);

                    }
                });
                btnstop.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                            if(mediaPlayer==null) {

                            }
                            mediaPlayer.pause();
                            btnPlay.setVisibility(View.VISIBLE);
                            btnstop.setVisibility(View.INVISIBLE);


                    }



                });
                btnPlay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        mediaPlayer.start();
                        btnPlay.setVisibility(View.INVISIBLE);
                        btnstop.setVisibility(View.VISIBLE);



                    }



                });
                btnNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mediaPlayer.stop();
                        int ileri = getResources().getIdentifier(arrayList.get(i+1),"raw",getPackageName());
                        mediaPlayer=MediaPlayer.create(MainActivity.this,ileri);
                        btnPlay.setVisibility(View.INVISIBLE);
                        btnstop.setVisibility(View.VISIBLE);
                        mediaPlayer.start();
                    }
                });

                btnback.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mediaPlayer.stop();
                        int geri = getResources().getIdentifier(arrayList.get(i-1),"raw",getPackageName());
                        mediaPlayer=MediaPlayer.create(MainActivity.this,geri);
                       if(mediaPlayer==null)
                       {int dance = getResources().getIdentifier(arrayList.get(i+1),"raw",getPackageName());
                           mediaPlayer=MediaPlayer.create(MainActivity.this,dance);
                       }
                       else{
                           mediaPlayer=MediaPlayer.create(MainActivity.this,geri);
                           mediaPlayer.start();

                       }

                    }
                });



            }
        });



        }
    }
