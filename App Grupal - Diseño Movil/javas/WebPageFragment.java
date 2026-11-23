package com.example.btnnavbarapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class WebPageFragment extends Fragment {

    private EditText editTextDomain;
    private WebView webView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_web_page, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        editTextDomain = view.findViewById(R.id.editTextDomain);
        Button buttonGo = view.findViewById(R.id.buttonGo);
        webView = view.findViewById(R.id.webView);


        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient()); // Abrir enlaces dentro del WebView


        buttonGo.setOnClickListener(v -> {
            String domain = editTextDomain.getText().toString().trim();

            if (!domain.isEmpty()) {
                String url = "https://www." + domain;
                webView.loadUrl(url);
            } else {
                Toast.makeText(getContext(), "Por favor ingrese un dominio", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
