package ir.shariaty.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {

    private MediaPlayer spalshSound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
//spalshSound=MediaPlayer.create(this,R.raw.sound);
//spalshSound.start();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
Intent i=new Intent(SplashScreen.this,MainActivity.class);
        startActivity(i);

        finish();
            }
        },3000);

    }
}