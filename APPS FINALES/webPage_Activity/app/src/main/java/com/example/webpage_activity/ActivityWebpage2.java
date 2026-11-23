package com.example.webpage_activity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityWebpage2 extends AppCompatActivity {
    WebView wv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webpage2);
        wv1 = (WebView)findViewById(R.id.wv1);

        String URL = getIntent().getStringExtra("sitioweb");
        wv1.setWebViewClient(new WebViewClient());
        wv1.loadUrl("http://" + URL);

    }

    public void finalizar(View view) {
        finish();
    }

}