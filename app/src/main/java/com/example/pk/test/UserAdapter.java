package com.example.pk.test;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by PK on 29.09.2017.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private List<UsersModel> list;

    public UserAdapter(List<UsersModel> list) {
        this.list = list;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new UserViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item, parent, false));
    }

    @Override
    public void onBindViewHolder(final UserViewHolder holder, final int position) {
        final UsersModel user = list.get(position);
        holder.textName.setText(user.name);
        holder.textAge.setText(user.age+"");
        holder.textCompany.setText(user.company);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context, Info_Users.class);
                intent.putExtra("name",user.name.toString());
                intent.putExtra("company",user.company.toString());
                intent.putExtra("gender",user.gender.toString());
                intent.putExtra("address",user.address.toString());
                intent.putExtra("about",user.about.toString());
                intent.putExtra("email",user.email.toString());
                intent.putExtra("eyeColor",user.eyeColor.toString());
                intent.putExtra("favoriteFruit",user.favoriteFruit.toString());
                intent.putExtra("phone",user.phone.toString());
                intent.putExtra("registered",user.registered.toString());
                intent.putExtra("balance",user.balance.toString());
                intent.putExtra("age",user.age+ " ");
                intent.putExtra("isActive",user.isActive);
                intent.putExtra("position",position);
                intent.putExtra("picture",user.picture);

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {
        TextView textName, textCompany, textAge;

        public UserViewHolder(View itemView) {
            super(itemView);
            textName = (TextView) itemView.findViewById(R.id.text_name);
            textAge = (TextView) itemView.findViewById(R.id.text_age);
            textCompany = (TextView) itemView.findViewById(R.id.text_company);
        }
    }
}
