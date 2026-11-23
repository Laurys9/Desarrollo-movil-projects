package com.example.btnnavbarapp;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.btnnavbarapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            binding = ActivityMainBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());

            replaceFragment(new UserWelcomeFragment());
            binding.btnNavigationView.setBackground(null);

        binding.btnNavigationView.setOnItemSelectedListener(item -> {

            int itemId = item.getItemId(); // Obtener el ID del elemento seleccionado

            if (itemId == R.id.user) {
                replaceFragment(new UserWelcomeFragment());
            } else if (itemId == R.id.calculate) {
                replaceFragment(new CalculateFragment());
            } else if (itemId == R.id.controlUser) {
                replaceFragment(new UserControllerFragment());
            } else if (itemId == R.id.webPage) {
                replaceFragment(new WebPageFragment());
            }

            return true;

        });

    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }

}