package com.frisca.uas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.frisca.uas.adapter.DataDiriAdapter;
import com.frisca.uas.adapter.ListAdapter;
import com.frisca.uas.databinding.ActivityListViewBinding;
import com.frisca.uas.model.DataDiriModel;
import com.frisca.uas.tugas.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    ActionBar aB;

    ActivityListViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        aB = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        int[] imageId = {R.drawable.nui, R.drawable.frisca, R.drawable.estu};

        String[] name = {"Nui J Simanjunta", "Frisca Tri Ananda", "Estu Renatalia"};

        String[] lastMessage = {"Bams", "Fisca", "Estu"};

        String[] lastmsgTime = {"12.11 am", "01.11 pm", "02:11 am", "01:11 pm"};

        String[] phoneNo = {"081111", "082222" , "083333" , "084444"};

        String[] country = {"Indonesia", "Jamaica" , "Jepang" , "Amerika Serikat"};

        ArrayList<User> userArrayList = new ArrayList<>();

        for (int i=0; i<imageId.length; i++) {

            User user = new User(name[i], lastMessage[i], lastmsgTime[i], phoneNo[i], country[i], imageId[i]);
            userArrayList.add(user);

        }

        ListAdapter listAdapter = new ListAdapter(ListViewActivity.this, userArrayList);

        binding.listView.setAdapter(listAdapter);
        binding.listView.setClickable(true);
        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(ListViewActivity.this, UserActivity.class);
                i.putExtra("name", name[position]);
                i.putExtra("phone", phoneNo[position]);
                i.putExtra("country", country[position]);
                i.putExtra("imageid", imageId[position]);
                startActivity(i);

            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public static class ReadActivity extends AppCompatActivity {

        ActionBar aB;

        DataDiriAdapter adapter;
        ArrayList<DataDiriModel> listData;

        RecyclerView recyclerView;
        LinearLayoutManager manager;

        DatabaseReference ref;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_read);

            recyclerView = findViewById(R.id.rv_read);
            recyclerView.setHasFixedSize(true);

            aB = getSupportActionBar();
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            manager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
            recyclerView.setLayoutManager(manager);

            AmbilData();
        }

        @Override
        public boolean onSupportNavigateUp() {
            onBackPressed();
            return true;
        }

        @Override
        public void onBackPressed() {
            super.onBackPressed();
        }

        public void AmbilData() {
            listData = new ArrayList<>();

            ref = FirebaseDatabase.getInstance().getReference("Mahasiswa");
            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    listData.clear();
                    for (DataSnapshot datsnap:snapshot.getChildren()) {
                        DataDiriModel model = datsnap.getValue(DataDiriModel.class);

                        model.setKey(model.getKey());
                        listData.add(model);

                    }
                    adapter = new DataDiriAdapter(getApplicationContext(), listData);
                    recyclerView.setAdapter(adapter);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }

        public void fab(View view) {
            startActivity(new Intent(ReadActivity.this, Firebase.class));
        }
    }
}