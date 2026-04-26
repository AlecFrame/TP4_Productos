package com.vertacnik.tp4_productos.ui.listar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vertacnik.tp4_productos.MainActivity;
import com.vertacnik.tp4_productos.R;
import com.vertacnik.tp4_productos.ui.model.Producto;

import java.util.ArrayList;
import java.util.Comparator;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ProductoHolder> {
    private Context context;
    private LayoutInflater inflater;
    private ArrayList<Producto> lista;

    public ProductoAdapter(ArrayList<Producto> productos, Context context, LayoutInflater inflater) {
        this.context = context;
        this.inflater = inflater;
        this.lista = productos;

        lista.sort(Comparator.comparing(Producto::getDesc));
    }

    @NonNull
    @Override
    public ProductoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = inflater.inflate(R.layout.item, parent, false);
        return new ProductoHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoHolder holder, int position) {
        Producto p = lista.get(position);

        holder.codigo.setText("Código: "+p.getCodigo());
        holder.desc.setText("Descripción: "+p.getDesc());
        holder.precio.setText("Precio: $"+p.getPrecio());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ProductoHolder extends RecyclerView.ViewHolder {
        private final TextView codigo, desc, precio;

        public ProductoHolder(@NonNull View itemView) {
            super(itemView);

            codigo = itemView.findViewById(R.id.tvICodigo);
            desc = itemView.findViewById(R.id.tvIDesc);
            precio = itemView.findViewById(R.id.tvIPrecio);
        }
    }
}
