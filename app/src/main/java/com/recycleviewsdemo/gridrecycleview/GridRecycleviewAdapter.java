package com.recycleviewsdemo.gridrecycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.recycleviewsdemo.Note;
import com.recycleviewsdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SHRENIK on 13-09-2016.
 */
public class GridRecycleviewAdapter extends RecyclerView.Adapter<GridRecycleviewAdapter.ViewHolder> {

    private Context mContext;
    private List<Note> noteList = new ArrayList<>();

    public GridRecycleviewAdapter(Context mContext, List<Note> noteList) {
        this.mContext = mContext;
        this.noteList = noteList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_grid_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        Note note = noteList.get(position);
        holder.tvSimpleText.setText(note.getMessage());
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvSimpleText;
        ViewHolder(View view) {
            super(view);

            tvSimpleText = (TextView)view.findViewById(R.id.tv_simpleText);
        }
    }
}
