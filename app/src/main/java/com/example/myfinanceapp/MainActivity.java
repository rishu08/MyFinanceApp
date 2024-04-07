package com.example.myfinanceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Investment> investments;
    private RecyclerView recyclerView;
    private InvestmentAdapter adapter;
    private int retirementAge = 60; // Default retirement age
    private int currentAge = 24; // Current age

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        investments = new ArrayList<>();
        Investment last_investment = new Investment(currentAge-1,0,0,0,0,0,0);
        for (int i = currentAge; i <= retirementAge; i++) {
            long lastCorpus;
            if(i==currentAge)
            {
                lastCorpus = 0;
            }
            else {
                lastCorpus = (long) investments.get(i-currentAge-1).getTotalCorpus();

            }
            investments.add(new Investment(i, 150000,lastCorpus)); // Default investment amount
        }

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new InvestmentAdapter(investments);
        recyclerView.setAdapter(adapter);
    }
}

//i=24  investment[0]  lastcorpus=0
//i=25  investment[1]  lastcorpus=(i-currentage-1).getCorpus();
//i=26  investment[2]  lastcorpus=