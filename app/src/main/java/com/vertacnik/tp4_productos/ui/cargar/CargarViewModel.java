package com.vertacnik.tp4_productos.ui.cargar;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.navigation.Navigation;

import com.vertacnik.tp4_productos.MainActivity;
import com.vertacnik.tp4_productos.ui.model.Producto;

public class CargarViewModel extends AndroidViewModel {

    private MutableLiveData<String> error;
    private MutableLiveData<Integer> color;
    public CargarViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<String> getError() {
        if (error==null) {
            error = new MutableLiveData<>();
        }
        return error;
    }

    public LiveData<Integer> getColor() {
        if (color==null) {
            color = new MutableLiveData<>();
        }
        return color;
    }

    public void cargarProducto(String codigo, String desc, String precio) {
        double precioDouble;

        if (codigo.trim().isEmpty() || desc.trim().isEmpty() || precio.trim().isEmpty() ) {
            error.setValue("Todos los campos son obligatorios");
            color.setValue(0xFFDC0D0D);
            return;
        }

        try {
            precioDouble = Double.parseDouble(precio.trim());
        } catch(Exception ignored) {
            error.setValue("El campo del precio no es un número válido");
            color.setValue(0xFFDC0D0D);
            return;
        }

        if (precioDouble <= 0) {
            error.setValue("El precio no puede ser 0 o un número inferior");
            color.setValue(0xFFDC0D0D);
            return;
        }

        for (Producto p: MainActivity.productos) {
            if (p.getCodigo().equals(codigo)) {
                error.setValue("Código existente, intente ingresar otro");
                color.setValue(0xFFDC0D0D);
                return;
            }
        }

        MainActivity.productos.add(new Producto(codigo, desc, precioDouble));
        error.setValue("Carga Exitosa!");
        color.setValue(0xFF0BE449);
    }
}