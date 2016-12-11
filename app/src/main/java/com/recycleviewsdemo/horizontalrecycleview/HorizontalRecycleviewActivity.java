package com.recycleviewsdemo.horizontalrecycleview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.recycleviewsdemo.Note;
import com.recycleviewsdemo.R;

import java.util.ArrayList;
import java.util.List;

public class HorizontalRecycleviewActivity extends Activity {

    //  Declare the recycleview object
    private RecyclerView rvHorizontalScroll;

    //  Declare the Adapter
    private HorizontalRecycleviewAdapter horizontalRecycleviewAdapter;

    //  Declare ArrayList
    private List<Note> noteList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_recycleview);

        //  Bind the recycleview with the object
        rvHorizontalScroll = (RecyclerView)findViewById(R.id.rv_horizontalScroll);

        //  Prepare ArrayList
        noteList = new ArrayList<>();
        for(int i=0; i<20; i++)
        {
            Note note = new Note("This is Note --> " + i);
            noteList.add(note);
        }

        /*  Declare and initialize layout manager that describe if the recycleview
            scroll vertical or horizontal*/

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        horizontalRecycleviewAdapter = new HorizontalRecycleviewAdapter(this,noteList);
        rvHorizontalScroll.setLayoutManager(linearLayoutManager);
        rvHorizontalScroll.setAdapter(horizontalRecycleviewAdapter);

    }
}
