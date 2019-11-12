package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private InfosAdapter infosAdapter;

    @BindView(R.id.new_client_button) Button addNewUserButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        ButterKnife.bind(this);
        Intent intent = this.getIntent();
        InfosForRecyclerView infos = intent.getParcelableExtra("Infos");
        List<Info> listOfInfos = new ArrayList<>();
        listOfInfos.addAll(infos.getListOfInfos());

        recyclerView = findViewById(R.id.infos_recyclerview);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        infosAdapter = new InfosAdapter(this, listOfInfos);
        recyclerView.setAdapter(infosAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        addNewUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecyclerActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
