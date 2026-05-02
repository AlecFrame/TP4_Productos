package com.vertacnik.tp4_productos;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Menu;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.appcompat.app.AppCompatActivity;

import com.vertacnik.tp4_productos.databinding.ActivityMainBinding;import com.vertacnik.tp4_productos.ui.model.Producto;import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Producto> productos = new ArrayList<>();

    static {
        productos.add(new Producto("001", "Leche", 2500));
        productos.add(new Producto("002", "Azúcar 1kg", 1200));
        productos.add(new Producto("003", "Frásco de Café", 6000));
    }
    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment_content_main);
        assert navHostFragment != null;
        // Cambio para la hamburger
        NavController navController = navHostFragment.getNavController();

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.cargarFragment,
                R.id.listaFragment
        )
                .setOpenableLayout(binding.drawerLayout)
                .build();

        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);

        binding.navView.setNavigationItemSelectedListener(item -> {

            if (item.getItemId() == R.id.nav_salir) {
                new AlertDialog.Builder(this)
                        .setTitle("Salir")
                        .setMessage("¿Estás seguro que querés cerrar la aplicación?")
                        .setPositiveButton("Sí", (dialog, which) -> finishAffinity())
                        .setNegativeButton("No", (dialog, which) -> dialog.dismiss())
                        .setCancelable(false)
                        .show();
                binding.drawerLayout.closeDrawers();
                return true;
            }

            boolean handled = NavigationUI.onNavDestinationSelected(item, navController);

            if (handled) {
                binding.drawerLayout.closeDrawers();
            }

            return handled;
        });

        /* Button Navigation - comentamos este código para dejar un ejemplo de cómo sería con el otro tipo de navegation
        binding.appBarMain.contentMain.bottomNavView.setOnItemSelectedListener(item -> {

            if (item.getItemId() == R.id.nav_salir) {

                new AlertDialog.Builder(this)
                        .setTitle("Salir")
                        .setMessage("¿Estás seguro que querés cerrar la aplicación?")
                        .setPositiveButton("Sí", (dialog, which) -> finishAffinity())
                        .setNegativeButton("No", (dialog, which) -> dialog.dismiss())
                        .setCancelable(false)
                        .show();

                return true;
            }

            return NavigationUI.onNavDestinationSelected(item, navController);
        });
        */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        boolean result = super.onCreateOptionsMenu(menu);
        // Using findViewById because NavigationView exists in different layout files
        // between w600dp and w1240dp
        NavigationView navView = findViewById(R.id.nav_view);
        if (navView == null) {
            // The navigation drawer already has the items including the items in the overflow menu
            // We only inflate the overflow menu if the navigation drawer isn't visible
            getMenuInflater().inflate(R.menu.overflow, menu);
        }
        return result;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.nav_settings) {
            NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
            navController.navigate(R.id.nav_settings);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}