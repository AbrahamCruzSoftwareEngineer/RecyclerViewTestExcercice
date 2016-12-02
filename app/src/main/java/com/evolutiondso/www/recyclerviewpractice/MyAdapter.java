package com.evolutiondso.www.recyclerviewpractice;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Albrtx on 01/12/2016.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<String> names;
    private int layout;
    private OnItemClickListener clicklistener;

    public MyAdapter(List<String> names, int layout, OnItemClickListener listener){
        this.names = names;
        this.layout = layout;
        this.clicklistener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textviewName;
        public ImageView image;
        public ImageButton botonadd;

        public ViewHolder(View itemView) {
            super(itemView);
            this.textviewName = (TextView) itemView.findViewById(R.id.textviewitem);
            this.image = (ImageView) itemView.findViewById(R.id.imgViewitem);
            this.botonadd = (ImageButton) itemView.findViewById(R.id.imageButton);

        }

        public void bind(final String name, final OnItemClickListener listener){
            this.textviewName.setText(name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.OnItemClick(name, getAdapterPosition());
                }
            });
        }

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
      holder.bind(names.get(position), clicklistener);
    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    //esta propiedad se tiene que setear a mano porque no hay un metodo como en listview
    public interface OnItemClickListener{
        void OnItemClick(String name, int position);

    }


}

