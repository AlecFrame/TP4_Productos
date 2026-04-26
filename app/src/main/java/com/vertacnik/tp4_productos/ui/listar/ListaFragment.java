package com.vertacnik.tp4_productos.ui.listar;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vertacnik.tp4_productos.MainActivity;
import com.vertacnik.tp4_productos.R;
import com.vertacnik.tp4_productos.databinding.FragmentListaBinding;

public class ListaFragment extends Fragment {

    private ListaViewModel vm;
    private FragmentListaBinding b;

    public static ListaFragment newInstance() {
        return new ListaFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        vm = new ViewModelProvider(this).get(ListaViewModel.class);
        b = FragmentListaBinding.inflate(getLayoutInflater());


        ProductoAdapter adapter = new ProductoAdapter(MainActivity.productos, getContext(), getLayoutInflater());
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 1, GridLayoutManager.VERTICAL, false);
        b.rvLista.setLayoutManager(manager);
        b.rvLista.setAdapter(adapter);

        return b.getRoot();
    }

}