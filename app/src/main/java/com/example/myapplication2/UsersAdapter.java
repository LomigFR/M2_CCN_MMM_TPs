package com.example.myapplication2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UsersViewHolder> {

    Context context;
    List<User> listOfUsers;

    public static class UsersViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView firstname;

        public UsersViewHolder(@NonNull View itemView) {
            super(itemView);
            this.name = itemView.findViewById(R.id.nameTextView);
            this.firstname = itemView.findViewById(R.id.firstNameTextView);
        }
    }

    public UsersAdapter(Context context, List<User> listOfUsers) {
        this.context = context;
        this.listOfUsers = listOfUsers;
    }

    @NonNull
    @Override
    public UsersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_user, parent, false);
        UsersAdapter.UsersViewHolder usersViewHolder = new UsersViewHolder(view);
        return usersViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UsersViewHolder holder, final int position) {
        User user = listOfUsers.get(position);
        holder.name.setText(user.getName());
        holder.firstname.setText(user.getFirstName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "This is your "
                        + listOfUsers.get(position).getName()
                        + " : "
                        + listOfUsers.get(position).getFirstName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listOfUsers.size();
    }
}
