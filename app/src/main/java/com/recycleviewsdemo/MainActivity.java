package com.recycleviewsdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.recycleviewsdemo.gridrecycleview.GridRecycleViewActivity;
import com.recycleviewsdemo.horizontalrecycleview.HorizontalRecycleviewActivity;
import com.recycleviewsdemo.verticalrecycleview.VerticalRecycleviewActivity;

public class MainActivity extends Activity implements View.OnClickListener {

    private Button btnVerticalRecycleView, btnHorizontalRecycleView, btnGridRecycleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnVerticalRecycleView = (Button) findViewById(R.id.btn_verticalRecycleView);
        btnHorizontalRecycleView = (Button) findViewById(R.id.btn_horizontalRecycleView);
        btnGridRecycleView = (Button) findViewById(R.id.btn_gridRecycleView);

        btnVerticalRecycleView.setOnClickListener(this);
        btnHorizontalRecycleView.setOnClickListener(this);
        btnGridRecycleView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == btnVerticalRecycleView) {
/*
            // We need an Editor object to make preference changes.
            // All objects are from android.context.Context
            SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
            SharedPreferences.Editor editor = settings.edit();
            editor.putBoolean("silentMode", mSilentMode);

            // Commit the edits!
            editor.commit();*/

/*
            SharedPreferences sharedPreferences = getSharedPreferences("MyPref", MODE_PRIVATE);

            SharedPreferences.Editor editor = sharedPreferences.edit();

            editor.putString("Recycle", "Vertical Recycle Clicked");
            editor.commit();*/

            Intent intent = new Intent(MainActivity.this, VerticalRecycleviewActivity.class);
            startActivity(intent);

        } else if (view == btnHorizontalRecycleView) {

            Intent intent = new Intent(MainActivity.this, HorizontalRecycleviewActivity.class);
            startActivity(intent);

        } else if (view == btnGridRecycleView) {

            Intent intent = new Intent(MainActivity.this, GridRecycleViewActivity.class);
            startActivity(intent);
        }
    }
}
