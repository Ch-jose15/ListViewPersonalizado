package com.example.listviewpersonalizado;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
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

        ImageView imagen = convertView.findViewById(R.id.item_image);
        TextView titulo = convertView.findViewById(R.id.item_title);
        TextView descripcion = convertView.findViewById(R.id.item_description);
        RadioButton boton = convertView.findViewById(R.id.rb);

        imagen.setImageResource(item.getImageResource());
        titulo.setText(item.getTitle());
        descripcion.setText(item.getDescription());

        boton.setChecked(position == selectedPosition);
        boton.setOnClickListener(v -> {
            selectedPosition = position;
            notifyDataSetChanged();

            tvColorSelected.setText("HAS SELECCIONADO EL COLOR: " + item.getTitle());

            // Cambiar el fondo de la actividad según el color seleccionado
            switch (item.getTitle()) {
                case "ROJO":
                    ((MainActivity) context).getWindow().getDecorView().setBackgroundColor(Color.RED);
                    break;
                case "VERDE":
                    ((MainActivity) context).getWindow().getDecorView().setBackgroundColor(Color.GREEN);
                    break;
                case "AZUL":
                    ((MainActivity) context).getWindow().getDecorView().setBackgroundColor(Color.BLUE);
                    break;
                case "AMARILLO":
                    ((MainActivity) context).getWindow().getDecorView().setBackgroundColor(Color.YELLOW);
                    break;
                case "NARANJA":
                    ((MainActivity) context).getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FFA500")); // Naranja
                    break;
            }
        });

        return convertView;
    }
}
