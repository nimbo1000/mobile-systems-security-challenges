package com.mobisec.plaku.reachingout.splitflagapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PartTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part_two);
        Intent resultIntent = new Intent();
        resultIntent.putExtra("flag", "part2");
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }
}
