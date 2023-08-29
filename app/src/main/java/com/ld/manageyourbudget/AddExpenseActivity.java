package com.ld.manageyourbudget;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class AddExpenseActivity extends AppCompatActivity {

    private static final String TAG = "AddExpenseActivity";

    private EditText editPriceText;
    private EditText editNameText;
    private EditText editPurchaseDate;
    private TextView txtWarnPrice;
    private TextView txtWarnName;
    private Button btnSave;
    private Spinner categorySpinner;
    private ConstraintLayout constraintLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        initViews();
        
        btnSave.setOnClickListener(view -> {
            initSaveExpense();
        });
    }

    private void initSaveExpense() {
        Log.d(TAG, "initSaveExpense: Started");
        if(validateInputData()){

        }
    }

    private boolean validateInputData() {
        if(editPriceText.getText().toString().equals("")){
            txtWarnPrice.setVisibility(View.VISIBLE);
            return false;
        }

        return true;
    }

    private void initViews() {
        Log.d(TAG, "initViews: Started");
        editPriceText = findViewById(R.id.editPriceText);
        editNameText = findViewById(R.id.editNameText);
        editPurchaseDate = findViewById(R.id.editPurchaseDate);

        txtWarnName = findViewById(R.id.txtWarnName);
        txtWarnPrice = findViewById(R.id.txtWarnPrice);

        btnSave = findViewById(R.id.btnSave);

        categorySpinner = findViewById(R.id.categorySpinner);
    }
}