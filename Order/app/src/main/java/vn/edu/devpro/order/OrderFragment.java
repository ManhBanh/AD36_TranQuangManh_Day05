package vn.edu.devpro.order;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OrderFragment extends Fragment {
    RecyclerView recyclerView;
    ShoppingAdapter shoppingAdapter;

    Item item1, item2, item3, item4, item5,item6;
    ArrayList<Item> itemArrayList;
    public static OrderFragment newInstance() {

        Bundle args = new Bundle();

        OrderFragment fragment = new OrderFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order, container, false);

        recyclerView = view.findViewById(R.id.recyclerview);

        itemArrayList = new ArrayList<>();

        item1 = new Item("Pizza Panda", 0);
        item2 = new Item("KFC Super", 0);
        item3 = new Item("Bread Eggs", 0);
        item4 = new Item("Coca Cola", 0);
        item5 = new Item("Chicken Super", 0);
        item6 = new Item("Cup Cake", 0);

        itemArrayList.add(item1);
        itemArrayList.add(item2);
        itemArrayList.add(item3);
        itemArrayList.add(item4);
        itemArrayList.add(item5);
        itemArrayList.add(item6);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        shoppingAdapter = new ShoppingAdapter(itemArrayList);
        recyclerView.setAdapter(shoppingAdapter);
        recyclerView.setLayoutManager(layoutManager);

        shoppingAdapter.setiOnClick(new IOnClick() {
            @Override
            public void onClickName(String name) {
                Bundle args = new Bundle();
                switch (name){
                    case "Pizza Panda":
                        int amount = item1.getAmount() + 1;
                        item1.setAmount(amount);
                        Toast.makeText(getContext(), String.valueOf(item1.getAmount()), Toast.LENGTH_SHORT).show();
                        args.putSerializable("item1", item1);
                        setArguments(args);
                        break;
                    case "KFC Super":
                        item2.setAmount(item2.getAmount() + 1);
//                        args = new Bundle();
                        args.putSerializable("item2", item2);
                        break;

                }
            }
        });
        return view;
    }
}
