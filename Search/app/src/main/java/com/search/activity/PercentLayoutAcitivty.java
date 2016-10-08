package com.search.activity;

import android.app.Activity;
import android.os.Bundle;

import com.search.LeakSingleInstanceTest;
import com.search.R;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class PercentLayoutAcitivty extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_percent_layout_acitivty);
        LeakSingleInstanceTest singleInstanceTest = LeakSingleInstanceTest.getInstance(this);
    }

}
