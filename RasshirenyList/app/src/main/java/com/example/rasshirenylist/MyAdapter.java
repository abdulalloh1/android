package com.example.rasshirenylist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<String> mData;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        Button deleteButton;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.item_text);
            deleteButton = itemView.findViewById(R.id.delete_button);
        }
    }

    public MyAdapter(List<String> data) {
        mData = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String item = mData.get(position);
        holder.textView.setText(item);

        // Удаление элемента
        holder.deleteButton.setOnClickListener(view -> {
            mData.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, mData.size());
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    // Метод для добавления элемента
    public void addItem(String item) {
        mData.add(item);
        notifyItemInserted(mData.size() - 1);
    }
}
