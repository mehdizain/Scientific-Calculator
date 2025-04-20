package com.example.calculator;

import android.app.ComponentCaller;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class splashScreen extends AppCompatActivity {

    ImageView myIcon;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_screen);
        myIcon =findViewById(R.id.cicon);
        Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
        myIcon.startAnimation(animation);
        tv=findViewById(R.id.tv);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent start=new Intent(splashScreen.this, MainActivity.class);
                ArrayList<String> val=new ArrayList<>();
                val.add("Mehdi");
                val.add("Zain");
                start.putExtra("key",val);
                startActivity(start);
                myIcon.clearAnimation();
                finish();
            }
        },3000);
    }

}