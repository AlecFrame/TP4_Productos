package com.vertacnik.tp4_productos.ui.cargar;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vertacnik.tp4_productos.R;
import com.vertacnik.tp4_productos.databinding.FragmentCargarBinding;

public class CargarFragment extends Fragment {

    private CargarViewModel vm;
    private FragmentCargarBinding b;

    public static CargarFragment newInstance() {
        return new CargarFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        vm = new ViewModelProvider(this).get(CargarViewModel.class);
        b = FragmentCargarBinding.inflate(getLayoutInflater());

        vm.getError().observe(getActivity(), error -> {
            b.tvError.setText(error);
        });
        vm.getColor().observe(getActivity(), color -> {
            b.tvError.setTextColor(color);

            if (color==0xFF0BE449) {
                // Limpiamos los campos si el producto se cargó exitosamente verificando el color verde.
                b.etCodigo.setText("");
                b.etDesc.setText("");
                b.etPrecio.setText("");
            }
        });

        b.btCargar.setOnClickListener(v -> {
            vm.cargarProducto(
                    b.etCodigo.getText().toString(),
                    b.etDesc.getText().toString(),
                    b.etPrecio.getText().toString()
            );
        });

        return b.getRoot();
    }

}