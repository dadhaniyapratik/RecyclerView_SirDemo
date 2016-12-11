package com.recycleviewsdemo.gridrecycleview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.recycleviewsdemo.Note;
import com.recycleviewsdemo.R;

import java.util.ArrayList;
import java.util.List;

public class GridRecycleViewActivity extends Activity {

    //  Declare the recycleview object
    private RecyclerView rvGridScroll;

    //  Declare the Adapter
    private GridRecycleviewAdapter gridRecycleviewAdapter;

    //  Declare ArrayList
    private List<Note> noteList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_recycle_view);

        //  Bind the recycleview with the object
        rvGridScroll = (RecyclerView)findViewById(R.id.rv_gridScroll);

        //  Prepare ArrayList
        noteList = new ArrayList<>();
        for(int i=0; i<40; i++)
        {
            Note note = new Note("This is Note --> " + i);
            noteList.add(note);
        }

        /*  Declare and initialize layout manager that describe if the recycleview
            scroll vertical or horizontal*/

//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3, LinearLayoutManager.HORIZONTAL, false);

        gridRecycleviewAdapter = new GridRecycleviewAdapter(this,noteList);
        rvGridScroll.setLayoutManager(gridLayoutManager);
        rvGridScroll.setAdapter(gridRecycleviewAdapter);

    }
}
