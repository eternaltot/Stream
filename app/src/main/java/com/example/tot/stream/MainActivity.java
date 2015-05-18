package com.example.tot.stream;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.opengl.GLSurfaceView;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.io.IOException;


public class MainActivity extends ActionBarActivity {
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnPlay,btnPause,btnStop;
        btnPlay = (Button)findViewById(R.id.btnPlay);
        btnPause = (Button)findViewById(R.id.btnPause);
        btnStop = (Button)findViewById(R.id.btnStop);
        context = this;
        final MediaPlayer mediaPlayer = new MediaPlayer();

        try {
            mediaPlayer.setDataSource(this,Uri.parse("http://203.147.16.93:8000/seed_48k.mp3"));
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
            }
        });
        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                mediaPlayer.reset();
                try {
                    mediaPlayer.setDataSource(context,Uri.parse("http://203.147.16.93:8000/seed_48k.mp3"));
                    mediaPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
