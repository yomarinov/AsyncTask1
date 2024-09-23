package com.tu_varna.asynctask1_17621690.tasks;

import android.os.AsyncTask;

import com.tu_varna.asynctask1_17621690.activity.ResultActivity;

import java.lang.ref.WeakReference;
import java.util.Random;


public class DownloadImageAsyncTask extends AsyncTask<Void, Void, Boolean> {

    private WeakReference<ResultActivity> context;
    private int time;

    public DownloadImageAsyncTask(ResultActivity context) {
        this.context = new WeakReference<>(context);
    }

    @Override
    protected void onPreExecute() {
        Random random = new Random();
        time = random.nextInt(4) + 2;
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException ignore) {
        }
        return time % 2 == 0;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        context.get().setDownloadSuccessful(aBoolean);
    }
}

