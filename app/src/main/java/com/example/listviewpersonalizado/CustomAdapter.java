package com.example.listviewpersonalizado;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {

    private Context context;
    private List<Item> items;
    private int selectedPosition = -1;
    private TextView tvColorSelected;

    public CustomAdapter(Context context, List<Item> items, TextView tvColorSelected) {
        this.context = context;
        this.items = items;
        this.tvColorSelected = tvColorSelected;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.lista_items, parent, false);
        }

        Item item = items.get(position);

        TextView titulo = convertView.findViewById(R.id.item_title);
        TextView descripcion = convertView.findViewById(R.id.item_description);
        RadioButton boton = convertView.findViewById(R.id.rb);

        titulo.setText(item.getTitle());
        descripcion.setText(item.getDescription());

        boton.setChecked(position == selectedPosition);
        boton.setOnClickListener(v -> {
            selectedPosition = position;
            notifyDataSetChanged();

            tvColorSelected.setText("HAS SELECCIONADO EL COLOR: " + item.getTitle());

            // Obtener referencias a los botones
            Button btnInsert = ((MainActivity) context).findViewById(R.id.btnInsert);
            Button btnDelete = ((MainActivity) context).findViewById(R.id.btnDelete);
            Button btnList = ((MainActivity) context).findViewById(R.id.btnList);

            // Cambiar el color de fondo de los botones
            switch (item.getTitle()) {
                case "ROJO":
                    btnInsert.setBackgroundColor(Color.RED);
                    btnDelete.setBackgroundColor(Color.RED);
                    btnList.setBackgroundColor(Color.RED);
                    break;
                case "VERDE":
                    btnInsert.setBackgroundColor(Color.GREEN);
                    btnDelete.setBackgroundColor(Color.GREEN);
                    btnList.setBackgroundColor(Color.GREEN);
                    break;
                case "AZUL":
                    btnInsert.setBackgroundColor(Color.BLUE);
                    btnInsert.setTextColor(Color.WHITE);
                    btnDelete.setBackgroundColor(Color.BLUE);
                    btnDelete.setTextColor(Color.WHITE);
                    btnList.setBackgroundColor(Color.BLUE);
                    btnList.setTextColor(Color.WHITE);
                    break;
                case "AMARILLO":
                    btnInsert.setBackgroundColor(Color.YELLOW);
                    btnDelete.setBackgroundColor(Color.YELLOW);
                    btnList.setBackgroundColor(Color.YELLOW);
                    break;
                case "NARANJA":
                    btnInsert.setBackgroundColor(Color.parseColor("#FFA500"));
                    btnDelete.setBackgroundColor(Color.parseColor("#FFA500"));
                    btnList.setBackgroundColor(Color.parseColor("#FFA500"));
                    break;
            }
        });

        return convertView;
    }
}