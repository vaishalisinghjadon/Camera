package com.example.camera;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    ImageButton imageButton;
    Button button;
    ImageView imageView;
    String s;
    Intent intent;
    Bitmap bitmp;
    final static int picbycamera=10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.button3);
        imageButton=findViewById(R.id.imageButton);
        imageView=findViewById(R.id.imageView);
        imageButton=findViewById(R.id.imageButton);

        InputStream inputStream=getResources().openRawResource(R.drawable.image_four);
        bitmp= BitmapFactory.decodeStream(inputStream);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    getApplicationContext().setWallpaper(bitmp);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Toast.makeText(MainActivity.this,"FEEL",Toast.LENGTH_SHORT).show();

            }
        });

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);   //implicit  //triger tat we have to click a image
                startActivityForResult(intent,picbycamera);
                Toast.makeText(MainActivity.this,"LOOK",Toast.LENGTH_SHORT).show();
            }
        });





    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id=item.getItemId();

        //switch case for the menu
        switch(id)
        {
            case R.id.item1:
            Toast.makeText(MainActivity.this,"hey1",Toast.LENGTH_SHORT).show();


            case R.id.item2:
                Toast.makeText(MainActivity.this,"hey2",Toast.LENGTH_SHORT).show();


            case R.id.item3:
                Toast.makeText(MainActivity.this,"hey3",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK)
        {
            Bundle extras=data.getExtras();
            bitmp=(Bitmap) extras.get("data");  //bitmpa format mai set karneka bitmap-array of pixels
            imageView.setImageBitmap(bitmp);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
        //apna menu uss par chipka diya

    }
}
