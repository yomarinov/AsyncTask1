package com.tu_varna.asynctask1_17621690.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tu_varna.asynctask1_17621690.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button openCountdownButton = findViewById(R.id.openCountdownButton);
        openCountdownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CountdownActivity.class);
                startActivity(intent);
            }
        });
        Button openDownloadAndLoginButton = findViewById(R.id.openDownloadAndLoginButton);
        openDownloadAndLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                startActivity(intent);
            }
        });
    }
}
