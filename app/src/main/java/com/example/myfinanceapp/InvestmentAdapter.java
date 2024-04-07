package com.example.myfinanceapp;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class InvestmentAdapter extends RecyclerView.Adapter<InvestmentAdapter.ViewHolder> {
    private List<Investment> investments;

    public InvestmentAdapter(List<Investment> investments) {
        this.investments = investments;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_investment, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Investment investment = investments.get(position);
        holder.age.setText(String.valueOf(investment.getAge()));
        holder.amountAfterReturns.setText(String.valueOf(investment.getAmountAfterReturns()));
        holder.totalCorpus.setText(String.valueOf(investment.getTotalCorpus()));
        holder.currentDayValueOfCorpus.setText(String.valueOf(investment.getCurrentDayValueOfCorpus()));

        // Set default values
        holder.amountInvested.setText(String.valueOf(investment.getAmountInvested()));
        holder.returnPercentage.setText(String.valueOf(investment.getReturnPercentage()));
        holder.inflationPercentage.setText(String.valueOf(investment.getInflationPercentage()));
    }

    @Override
    public int getItemCount() {
        return investments.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView age;
        EditText amountInvested;
        EditText returnPercentage;
        EditText inflationPercentage;
        TextView amountAfterReturns;
        TextView totalCorpus;
        TextView currentDayValueOfCorpus;

        public ViewHolder(View itemView) {
            super(itemView);
            age = itemView.findViewById(R.id.textViewAge);
            amountInvested = itemView.findViewById(R.id.editTextAmountInvested);
            returnPercentage = itemView.findViewById(R.id.editTextReturnPercentage);
            inflationPercentage = itemView.findViewById(R.id.editTextInflationPercentage);
            amountAfterReturns = itemView.findViewById(R.id.textViewAmountAfterReturns);
            totalCorpus = itemView.findViewById(R.id.textViewTotalCorpus);
            currentDayValueOfCorpus = itemView.findViewById(R.id.textViewCurrentDayValueOfCorpus);

            // Disable editing for non-editable fields
            amountAfterReturns.setEnabled(false);
            totalCorpus.setEnabled(false);
            currentDayValueOfCorpus.setEnabled(false);
        }
    }
}
