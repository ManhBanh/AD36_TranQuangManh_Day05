package vn.edu.devpro.order;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ShoppingAdapter extends RecyclerView.Adapter<ShoppingAdapter.Viewholder> {

    ArrayList<Item> itemArrayList;
    IOnClick iOnClick;

    public ShoppingAdapter(ArrayList<Item> itemArrayList) {
        this.itemArrayList = itemArrayList;
    }

    public void setiOnClick(IOnClick iOnClick) {
        this.iOnClick = iOnClick;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item, parent, false);
        Viewholder vh = new Viewholder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ShoppingAdapter.Viewholder holder, int position) {
        final Item item = itemArrayList.get(position);

        holder.tvProductName.setText(item.getName());

        holder.tvProductName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iOnClick.onClickName(item.getName(), item.getPrice());
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemArrayList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView tvProductName;
        public Viewholder(@NonNull View itemView) {
            super(itemView);

            tvProductName = itemView.findViewById(R.id.tvProductName);
        }
    }
}
