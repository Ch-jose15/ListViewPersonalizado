package com.example.listviewpersonalizado;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView tvTitle;
    private TextView tvColorSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);
        tvTitle = findViewById(R.id.tvTitle); // Título de la app
        tvColorSelected = findViewById(R.id.tvColorSelected); // TextView para el color seleccionado

        // Lista de colores
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(R.drawable.color_rojo, "ROJO", "Esto es el color rojo"));
        items.add(new Item(R.drawable.color_verde, "VERDE", "Esto es el color verde"));
        items.add(new Item(R.drawable.color_azul, "AZUL", "Esto es el color azul"));
        items.add(new Item(R.drawable.color_amarillo, "AMARILLO", "Esto es el color amarillo"));
        items.add(new Item(R.drawable.color_naranja, "NARANJA", "Esto es el color naranja"));

        CustomAdapter adapter = new CustomAdapter(this, items, tvColorSelected);
        listView.setAdapter(adapter);
    }
}