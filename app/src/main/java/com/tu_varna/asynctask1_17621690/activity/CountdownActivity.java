package com.tu_varna.asynctask1_17621690.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.tu_varna.asynctask1_17621690.fragment.CountdownFragment;
import com.tu_varna.asynctask1_17621690.R;

public class CountdownActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countdown);

        final EditText countdownSeconds = findViewById(R.id.countdownValue);
        Button countdownStartButton = findViewById(R.id.countdownButton);

        countdownStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int countdownSecondsValue = Integer.parseInt(countdownSeconds.getText().toString());
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    CountdownFragment countdownFragment = CountdownFragment.newInstance(countdownSecondsValue);
                    countdownFragment.show(fragmentManager, "fragment_countdown_fragment");
                }
                catch (NumberFormatException nfm) {
                    countdownSeconds.requestFocus();
                }
            }
        });
    }


}
