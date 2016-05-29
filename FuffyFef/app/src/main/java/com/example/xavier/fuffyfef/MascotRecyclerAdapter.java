package com.example.xavier.fuffyfef;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by xavier on 28/05/16.
 */
public class MascotRecyclerAdapter extends RecyclerView.Adapter<MascotRecyclerAdapter.MascotViewHolder> {

    ArrayList arrayList = new ArrayList<>();


    public MascotRecyclerAdapter(ArrayList arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public MascotViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view_mascot, viewGroup, false);
        return new MascotViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotViewHolder mascotViewHolder, int position) {
        mascotViewHolder.img_mascot.setImageResource(((Mascot) arrayList.get(position)).getImage());
        mascotViewHolder.image_button_like.setImageResource(R.drawable.like_button);
        mascotViewHolder.tv_name.setText(((Mascot) arrayList.get(position)).getName());
        mascotViewHolder.img_total_likes.setImageResource(R.drawable.total_likes);
        mascotViewHolder.tv_total_like.setText(String.valueOf(((Mascot) arrayList.get(position)).getTotalLikes()));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class MascotViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView img_mascot;
        ImageButton image_button_like;
        TextView tv_name;
        ImageView img_total_likes;
        TextView tv_total_like;

        public MascotViewHolder(View itemView) {
            super(itemView);
            img_mascot = (ImageView) itemView.findViewById(R.id.img_mascot);
            image_button_like = (ImageButton) itemView.findViewById(R.id.image_button_like);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            img_total_likes = (ImageView) itemView.findViewById(R.id.img_total_likes);
            tv_total_like = (TextView) itemView.findViewById(R.id.tv_total_like);
            image_button_like.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (v == image_button_like) {
                int like = Integer.parseInt(tv_total_like.getText().toString()) + 1;
                tv_total_like.setText(String.valueOf(like));
            }
        }
    }
}
