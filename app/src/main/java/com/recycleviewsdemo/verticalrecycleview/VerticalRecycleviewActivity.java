package com.recycleviewsdemo.verticalrecycleview;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.recycleviewsdemo.Note;
import com.recycleviewsdemo.R;

import java.util.ArrayList;
import java.util.List;

public class VerticalRecycleviewActivity extends Activity implements OnRecycleViewItemClick{

    //  Declare the recycleview object
    private RecyclerView rvVerticalScroll;

    //  Declare the Adapter
    private VericalRecycleviewAdapter vericalRecycleviewAdapter;

    //  Declare ArrayList
    private List<Note> noteList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertical_recycleview);

        SharedPreferences sharedPreferences = getSharedPreferences("MyPref", MODE_PRIVATE);
        String val = sharedPreferences.getString("Recycle12","No Key Found");

        Log.e("Log", "Data ---> " +val);

        //  Bind the recycleview with the object
        rvVerticalScroll = (RecyclerView)findViewById(R.id.rv_verticalScroll);

        //  Prepare ArrayList
        noteList = new ArrayList<>();
        for(int i=0; i<20; i++)
        {
            Note note = new Note("This is Note --> " + i);
            noteList.add(note);
        }

        /*  Declare and initialize layout manager that describe if the recycleview
            scroll vertical or horizontal*/

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        vericalRecycleviewAdapter = new VericalRecycleviewAdapter(this, noteList, this);
        rvVerticalScroll.setLayoutManager(linearLayoutManager);
        rvVerticalScroll.setAdapter(vericalRecycleviewAdapter);

    }

    /*private OnRecycleViewItemClick onRecycleViewItemClick = new OnRecycleViewItemClick() {
        @Override
        public void onClickButton(int position) {

        }
    }*/

    @Override
    public void onClickButton(int position, int temp) {
        Toast.makeText(this,"Button Position ---> "+position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClickTextView(int position) {
        Toast.makeText(this,"TextView Position ---> "+position, Toast.LENGTH_SHORT).show();
    }
}
