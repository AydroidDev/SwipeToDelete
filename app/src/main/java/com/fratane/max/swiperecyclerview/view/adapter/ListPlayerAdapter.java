package com.fratane.max.swiperecyclerview.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fratane.max.swiperecyclerview.R;
import com.fratane.max.swiperecyclerview.model.Player;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Max_F on 09/09/2017.
 */

public class ListPlayerAdapter extends RecyclerView.Adapter<ListPlayerAdapter.ListPlayerViewHolder>{
    private List<Player> playerList;
    private Context context;
    private ListPlayerAdapterListener listPlayerAdapterListener;

    public ListPlayerAdapter(List<Player> playerList, Context context){
        if (playerList == null){
            throw new IllegalArgumentException("playerList is null");
        }

        if (context == null){
            throw new IllegalArgumentException("context is null");
        }

        this.context = context;
        this.playerList = playerList;
    }

    @Override
    public ListPlayerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_players_list, parent, false);

        return new ListPlayerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListPlayerViewHolder holder, int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listPlayerAdapterListener != null){
                    listPlayerAdapterListener.onClickListener(holder.getAdapterPosition());
                }
            }
        });

        Player player = playerList.get(position);

        holder.playerPosition.setText(player.getPosition());
        holder.playerName.setText(player.getName());

        Picasso.with(context).load(player.getPlayerImg()).fit().centerCrop().into(holder.playerImg);
    }

    @Override
    public int getItemCount() {
        return playerList == null? 0 : playerList.size();
    }

    public void setListPlayerAdapterListener(ListPlayerAdapterListener listPlayerAdapterListener) {
        this.listPlayerAdapterListener = listPlayerAdapterListener;
    }

    public interface ListPlayerAdapterListener {
        void onClickListener(int pos);
    }

    public void remove(int pos){
        playerList.remove(pos);
        notifyItemRemoved(pos);
        notifyItemChanged(pos, playerList.size());
    }

    public void update(){
        notifyDataSetChanged();
    }

    static class ListPlayerViewHolder extends RecyclerView.ViewHolder{
        TextView playerName;
        TextView playerPosition;
        ImageView playerImg;

        public ListPlayerViewHolder(View itemView) {
            super(itemView);

            playerName = (TextView) itemView.findViewById(R.id.playerName);
            playerPosition = (TextView) itemView.findViewById(R.id.playerPosition);
            playerImg = (ImageView) itemView.findViewById(R.id.playerImg);
        }
    }
}
