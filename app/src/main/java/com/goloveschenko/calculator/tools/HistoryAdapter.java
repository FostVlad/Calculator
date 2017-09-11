package com.goloveschenko.calculator.tools;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.goloveschenko.calculator.R;
import com.goloveschenko.calculator.entity.HistoryItem;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>{
    private final static String SYMBOL_EQUALS = " = ";

    private List<HistoryItem> historyItems;

    static class HistoryViewHolder extends RecyclerView.ViewHolder {
        private TextView dateTextView;
        private TextView expressionTextView;
        private TextView commentTextView;

        private HistoryViewHolder(View v) {
            super(v);
            dateTextView = (TextView) v.findViewById(R.id.history_date);
            expressionTextView = (TextView) v.findViewById(R.id.history_expression);
            commentTextView = (TextView) v.findViewById(R.id.history_comment);
        }
    }

    public HistoryAdapter(List<HistoryItem> historyItems) {
        this.historyItems = historyItems;
    }

    @Override
    public HistoryAdapter.HistoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_item, parent, false);
        return new HistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HistoryViewHolder holder, int pos) {
        holder.dateTextView.setText(historyItems.get(pos).getDate());
        holder.expressionTextView.setText(historyItems.get(pos).getExpression() + SYMBOL_EQUALS + historyItems.get(pos).getResult());
        holder.commentTextView.setText(historyItems.get(pos).getComment());
    }

    @Override
    public int getItemCount() {
        return historyItems.size();
    }
}