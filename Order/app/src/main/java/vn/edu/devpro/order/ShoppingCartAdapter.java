package vn.edu.devpro.order;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ShoppingCartAdapter extends RecyclerView.Adapter<ShoppingCartAdapter.Viewholder> {

    ArrayList<Item> itemArrayList;

    public ShoppingCartAdapter(ArrayList<Item> itemArrayList) {
        this.itemArrayList = itemArrayList;
    }

    @NonNull
    @Override
    public ShoppingCartAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item, parent, false);
        Viewholder vh = new Viewholder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ShoppingCartAdapter.Viewholder holder, int position) {
        Item item = itemArrayList.get(position);

        holder.textView.setText(item.getName());
    }

    @Override
    public int getItemCount() {
        return itemArrayList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView textView;
        public Viewholder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.tvProductName);
        }
    }
}
