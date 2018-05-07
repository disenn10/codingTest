package com.example.disen.codingtest.utilities;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.disen.codingtest.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by disen on 5/6/2018.
 */

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.userAdapter> {
    Context context;
    ArrayList<Users> users_list;

    public UsersAdapter(Context context, ArrayList<Users>users_list){
        this.context = context;
        this.users_list = users_list;
    }
    @Override
    public UsersAdapter.userAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.show_users_layout,parent,false);
        return new userAdapter(view);
    }

    @Override
    public void onBindViewHolder(UsersAdapter.userAdapter holder, int position) {
        holder.name.setText(users_list.get(position).first_name+" "+users_list.get(position).last_name);
        Picasso.with(context).load(users_list.get(position).getAvatar()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        if(users_list==null){return 0;};
        return users_list.size();
    }
    public class userAdapter extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name;
        public userAdapter(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.avatar);
            name = itemView.findViewById(R.id.name);
        }
    }
}
