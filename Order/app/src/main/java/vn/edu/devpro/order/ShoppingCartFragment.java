package vn.edu.devpro.order;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ShoppingCartFragment extends Fragment{

    Item item1;
    ArrayList<Item> itemArrayList;
    ShoppingCartAdapter shoppingCartAdapter;
    RecyclerView recyclerView;

    public static ShoppingCartFragment newInstance() {
        
        Bundle args = new Bundle();
        args.putString("data", null);
        ShoppingCartFragment fragment = new ShoppingCartFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public static ShoppingCartFragment getInstance(){
        return new ShoppingCartFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shopping_cart, container, false);

        recyclerView = view.findViewById(R.id.rvShoppingCart);

        itemArrayList = new ArrayList<>();
//        item1 = new Item("1", 1.1);
//        itemArrayList.add(item1);
        Bundle bundle = getArguments();
        if(bundle != null){
            String name = bundle.getString("nameOfProduct");
            double price = bundle.getDouble("priceOfProduct");

            itemArrayList.add(new Item(name, price));
        }
        else{
            Toast.makeText(getContext(), "Chưa có đơn đặt hàng", Toast.LENGTH_SHORT).show();
        }

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);

        shoppingCartAdapter = new ShoppingCartAdapter(itemArrayList);
        recyclerView.setAdapter(shoppingCartAdapter);
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }

}
