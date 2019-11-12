package com.example.myapplication2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerActivityUser extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private UsersAdapter usersAdapter;
    private List<User> listOfUsers = new ArrayList<>();

    @BindView(R.id.new_client_button_from_list) Button addNewUserButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_user);

        ButterKnife.bind(this);

        Intent intent =getIntent();
        final UsersForRecyclerView users = intent.getParcelableExtra("Users");

        listOfUsers.addAll(users.getListOfUsers());

        recyclerView = findViewById(R.id.users_recyclerview);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        usersAdapter = new UsersAdapter(this, listOfUsers);
        recyclerView.setAdapter(usersAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        addNewUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecyclerActivityUser.this, MainActivity.class);
                setResult(RESULT_OK,intent);
                finish();
            }
        });

        ItemTouchHelper.Callback itemTouchHelperCallback = new ItemTouchHelper.Callback() {
            @Override
            public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
                int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
                int swipeFlags = ItemTouchHelper.START | ItemTouchHelper.END;
                return makeMovementFlags(dragFlags, swipeFlags);
            }

            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                Collections.swap(usersAdapter.listOfUsers, viewHolder.getAdapterPosition(), target.getAdapterPosition());
                usersAdapter.notifyItemMoved(viewHolder.getAdapterPosition(), target.getAdapterPosition());
                return true;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                usersAdapter.listOfUsers.remove(position);
                usersAdapter.notifyItemRemoved(position);
            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemTouchHelperCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle extra = data.getExtras();
        User user = extra.getParcelable("User");
        listOfUsers.add(user);
    }
}
