package com.example.sales_partner_v21;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class ClientesActivity extends AppCompatActivity {

    public static String CLIENTES_FLAG_KEY = "CLIENTES_FLAG_KEY";
    public static final int CLIENTES_REQUEST_CODE = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent( ClientesActivity.this, MainActivity.class);
        ClientesActivity.super.finish();
        startActivityForResult(intent , MainActivity.PRINCIPAL_REQUEST_CODE);
    }
}