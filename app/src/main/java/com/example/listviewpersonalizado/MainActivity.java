package com.example.listviewpersonalizado;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView tvTitle;
    private TextView tvColorSelected;
    private ListView listView;
    private CustomAdapter adapter;
    private ArrayList<Item> items;
    private DatabaseHelper databaseHelper;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTitle = findViewById(R.id.tvTitle);
        tvColorSelected = findViewById(R.id.tvColorSelected);
        listView = findViewById(R.id.listView);
        Button btnInsert = findViewById(R.id.btnInsert);
        Button btnDelete = findViewById(R.id.btnDelete);
        Button btnList = findViewById(R.id.btnList);

        databaseHelper = new DatabaseHelper(this);
        items = new ArrayList<>();
        adapter = new CustomAdapter(this, items, tvColorSelected);
        listView.setAdapter(adapter);

        btnInsert.setOnClickListener(v -> {
            databaseHelper.insertData("ROJO", "Esto es el color rojo");
            databaseHelper.insertData("VERDE", "Esto es el color verde");
            databaseHelper.insertData("AZUL", "Esto es el color azul");
            databaseHelper.insertData("AMARILLO", "Esto es el color amarillo");
            databaseHelper.insertData("NARANJA", "Esto es el color naranja");
        });

        btnDelete.setOnClickListener(v -> {
            databaseHelper.deleteAllData();
            items.clear();
            adapter.notifyDataSetChanged();
            tvColorSelected.setText("Todos los colores han sido eliminados.");
        });

        btnList.setOnClickListener(v -> {
            items.clear();
            items.addAll(databaseHelper.getAllData());
            adapter.notifyDataSetChanged();
            tvColorSelected.setText("Colores listados.");
        });
    }
}