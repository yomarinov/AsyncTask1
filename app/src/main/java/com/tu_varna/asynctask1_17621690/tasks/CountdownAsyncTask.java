package com.tu_varna.asynctask1_17621690.tasks;

import android.graphics.Color;
import android.os.AsyncTask;

import com.tu_varna.asynctask1_17621690.fragment.CountdownFragment;

import java.lang.ref.WeakReference;
import java.util.Locale;

public class CountdownAsyncTask extends AsyncTask<Integer, Integer, Void> {

    private WeakReference<CountdownFragment> fragmentContext;

    public CountdownAsyncTask(CountdownFragment fragmentContext) {
        this.fragmentContext = new WeakReference<>(fragmentContext);
    }

    @Override
    protected Void doInBackground(Integer... integers) {
        int counter = integers[0];
        while (counter > 0) {
            try {
                publishProgress(counter--);
                Thread.sleep(1000);
            } catch (InterruptedException ignore) {
            }
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        fragmentContext.get().setCountdownDisplayText(String.format(Locale.getDefault(), "%d", values[0]));
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        fragmentContext.get().setCountdownDisplayText(String.format(Locale.getDefault(),"%s", "Finished"));
        fragmentContext.get().setCountdownDisplayTextColor(Color.GREEN);
    }

}
