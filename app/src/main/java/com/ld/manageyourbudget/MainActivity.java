package com.ld.manageyourbudget;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView expensesRecView;
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        floatingActionButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, AddExpenseActivity.class);
            startActivity(intent);
        });

        List<Expense> expenses = new ArrayList<>();
        expenses.add(new Expense("biedronka", "grocery", LocalDate.now(), BigDecimal.valueOf(41.20)));
        expenses.add(new Expense("lidl", "grocery", LocalDate.now(), BigDecimal.valueOf(149.80)));
        expenses.add(new Expense("rent", "home", LocalDate.now(), BigDecimal.valueOf(800)));
        expenses.add(new Expense("netflix", "services", LocalDate.now(), BigDecimal.valueOf(49)));
        expenses.add(new Expense("cinema", "entertainment", LocalDate.now(), BigDecimal.valueOf(60)));

        ExpensesRecViewAdapter adapter = new ExpensesRecViewAdapter(this);
        adapter.setExpenses(expenses);

        expensesRecView.setAdapter(adapter);
        expensesRecView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initViews(){
        expensesRecView = findViewById(R.id.expensesView);
        floatingActionButton = findViewById(R.id.floatingActionButton);
    }
} 