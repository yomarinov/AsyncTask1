package com.tu_varna.asynctask1_17621690.activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.tu_varna.asynctask1_17621690.R;
import com.tu_varna.asynctask1_17621690.tasks.DownloadImageAsyncTask;
import com.tu_varna.asynctask1_17621690.tasks.LoginAsyncTask;

import java.util.Locale;

public class ResultActivity extends AppCompatActivity {

    private TextView resultTextView;
    private ProgressBar resultProgressBar;
    private Boolean isDownloadSuccessful;
    private Boolean isLoginSuccessful;

    public void setDownloadSuccessful(boolean downloadSuccessful) {
        isDownloadSuccessful = downloadSuccessful;
        displayResult();
    }

    public void setLoginSuccessful(boolean loginSuccessful) {
        isLoginSuccessful = loginSuccessful;
        displayResult();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultTextView = findViewById(R.id.resultText);
        resultProgressBar = findViewById(R.id.resultProgressBar);
        resultProgressBar.setVisibility(View.INVISIBLE);
        Button resultStartButton = findViewById(R.id.resultButton);

        resultStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reload();
                resultProgressBar.setVisibility(ProgressBar.VISIBLE);
                /*
                If we use .execute(), the tasks are executed one after another on a single thread :)
                new DownloadImageAsyncTask(ResultActivity.this).execute();
                new LoginAsyncTask(ResultActivity.this).execute();
                 */
                new DownloadImageAsyncTask(ResultActivity.this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
                new LoginAsyncTask(ResultActivity.this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
            }
        });
    }

    private void reload() {
        if (isDownloadSuccessful != null)
            isDownloadSuccessful = null;
        if (isLoginSuccessful != null)
            isLoginSuccessful = null;
        if (!resultTextView.getText().equals(""))
            resultTextView.setText("");
    }

    private void displayResult() {
        if (isDownloadSuccessful != null && isLoginSuccessful != null) {
            resultProgressBar.setVisibility(ProgressBar.INVISIBLE);
            if (isDownloadSuccessful && isLoginSuccessful) {
                resultTextView.setText(String.format(Locale.getDefault(), "%s", "Success!"));
            } else {
                resultTextView.setText(String.format(Locale.getDefault(), "%s", "Failure!"));
            }
        }
    }
}

