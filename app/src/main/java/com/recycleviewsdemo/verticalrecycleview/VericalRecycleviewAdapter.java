package com.recycleviewsdemo.verticalrecycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.recycleviewsdemo.Note;
import com.recycleviewsdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SHRENIK on 13-09-2016.
 */
public class VericalRecycleviewAdapter extends RecyclerView.Adapter<VericalRecycleviewAdapter.ViewHolder> {

    private Context mContext;
    private List<Note> noteList = new ArrayList<>();
    private OnRecycleViewItemClick onRecycleViewItemClick;

    public VericalRecycleviewAdapter(Context mContext, List<Note> noteList, OnRecycleViewItemClick onRecycleViewItemClick) {
        this.mContext = mContext;
        this.noteList = noteList;
        this.onRecycleViewItemClick = onRecycleViewItemClick;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_vertical_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        Note note = noteList.get(position);
        holder.tvSimpleText.setText(note.getMessage());

        holder.btnClickHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(mContext,"Position ---> "+position, Toast.LENGTH_SHORT).show();

                onRecycleViewItemClick.onClickButton(position, 1);
            }
        });

        holder.tvSimpleText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRecycleViewItemClick.onClickTextView(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvSimpleText;
        Button btnClickHere;

        ViewHolder(View view) {
            super(view);

            tvSimpleText = (TextView) view.findViewById(R.id.tv_simpleText);
            btnClickHere = (Button) view.findViewById(R.id.btn_clickHere);
        }
    }
}
