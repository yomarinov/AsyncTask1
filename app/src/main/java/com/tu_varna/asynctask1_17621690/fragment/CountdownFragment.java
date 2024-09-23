package com.tu_varna.asynctask1_17621690.fragment;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tu_varna.asynctask1_17621690.R;
import com.tu_varna.asynctask1_17621690.tasks.CountdownAsyncTask;

import java.lang.ref.WeakReference;
import java.util.Locale;

public class CountdownFragment extends DialogFragment {

    private int counter;
    private TextView countdownDisplay;

    private CountdownFragment(int counter) {
        this.counter = counter;
    }

    public static CountdownFragment newInstance(int counter) {
        return new CountdownFragment(counter);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_countdown_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        countdownDisplay = view.findViewById(R.id.countdownDisplay);
        new CountdownAsyncTask(this).execute(counter);
    }

    public void setCountdownDisplayText(String text) {
        countdownDisplay.setText(text);
    }

    public void setCountdownDisplay(TextView countdownDisplay) {
        this.countdownDisplay = countdownDisplay;
    }

    public void setCountdownDisplayTextColor(int green) {
        this.countdownDisplay.setTextColor(green);
    }
}
