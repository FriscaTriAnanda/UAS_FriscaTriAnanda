package com.frisca.uas.tugas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.frisca.uas.ListViewActivity;
import com.frisca.uas.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class Firebase extends AppCompatActivity {

    ActionBar aB;

    EditText nama, nim, alamat, noHp, jurusan, kelas;
    Button kirimData;

    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);

        ref = FirebaseDatabase.getInstance().getReference("Mahasiswa").push();

        nama = findViewById(R.id.nama);
        nim = findViewById(R.id.nim);
        alamat = findViewById(R.id.alamat);
        noHp = findViewById(R.id.noHp);
        jurusan = findViewById(R.id.jurusan);
        kelas = findViewById(R.id.kelas);

        aB = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        kirimData = findViewById(R.id.kirim);
        kirimData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nama.equals(null) || nim.equals(null) || alamat.equals(null) ||
                        noHp.equals(null) || jurusan.equals(null) || kelas.equals(null) ||
                        nama.equals("") || nim.equals("") || alamat.equals("") ||
                        noHp.equals("") || jurusan.equals("") || kelas.equals("")) {
                    Toast.makeText(getApplicationContext(),
                            "Data tidak boleh kosong",Toast.LENGTH_SHORT).show();
                } else {
                    KirimData(
                            nama.getText().toString(),
                            nim.getText().toString(),
                            alamat.getText().toString(),
                            noHp.getText().toString(),
                            jurusan.getText().toString(),
                            kelas.getText().toString()
                    );
                }
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

    public void KirimData(final String nama, final String nim,
                          final String alamat, final String nohp,
                          final String jurusan, final String kelas) {
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                HashMap<String, String> map = new HashMap<String, String>();

                map.put("nama", nama);
                map.put("nim", nim);
                map.put("alamat", alamat);
                map.put("nohp", nohp);
                map.put("jurusan", jurusan);
                map.put("kelas", kelas);

                ref.setValue(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(getApplicationContext(),
                                "Data berhasil dikirim",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Firebase.this, ListViewActivity.ReadActivity.class));
                        finish();
                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}