package com.example.pk.test;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by PK on 30.09.2017.
 */

public class FriendsAdapter extends RecyclerView.Adapter<FriendsAdapter.UserViewHolder> {

    private List<FriendsModel> list;

    public FriendsAdapter(List<FriendsModel> list) {
        this.list = list;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new FriendsAdapter.UserViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.friend_item, parent, false));
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        final FriendsModel friend = list.get(position);
        holder.textName.setText(friend.name);
        holder.textId.setText(friend.id+1 + " ");

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {
        TextView textName, textId;

        public UserViewHolder(View itemView) {
            super(itemView);
            textId = (TextView) itemView.findViewById(R.id.friends_id);
            textName = (TextView) itemView.findViewById(R.id.friends_name);

        }
    }
}
