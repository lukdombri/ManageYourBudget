package com.ld.manageyourbudget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ExpensesRecViewAdapter extends RecyclerView.Adapter<ExpensesRecViewAdapter.ViewHolder> {

    private List<Expense> expenses = new ArrayList<>();
    private Context context;
    public ExpensesRecViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.expenses_list_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtName.setText(expenses.get(position).getName());
        holder.categoryName.setText(expenses.get(position).getCategory());
        holder.totalPrice.setText(expenses.get(position).getTotalPrice().toString());

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, expenses.get(holder.getAdapterPosition()).getName() + " Selected", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return expenses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView txtName;
        private TextView categoryName;
        private TextView totalPrice;
        private CardView parent;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            categoryName = itemView.findViewById(R.id.categoryName);
            totalPrice = itemView.findViewById(R.id.totalPrice);
            parent=itemView.findViewById(R.id.parent);
        }
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
        notifyDataSetChanged();
    }
}
