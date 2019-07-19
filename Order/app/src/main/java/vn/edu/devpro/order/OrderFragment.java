package vn.edu.devpro.order;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
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

    IOnClickItem iOnClickItem;

    TextView tvUsername;

    public interface IOnClickItem{
        public void onClickItem(String name, Double price);
    }

    Item item1, item2, item3, item4, item5,item6;
    ArrayList<Item> itemArrayList;
    public static OrderFragment newInstance(String welcome) {

        Bundle args = new Bundle();
        args.putString("welcome", welcome);
        OrderFragment fragment = new OrderFragment();
        fragment.setArguments(args);
        return fragment;
    }

//    public OrderFragment(){
//
//    }
//    public static OrderFragment getInstance(){
//        return new OrderFragment();
//    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order, container, false);

        recyclerView = view.findViewById(R.id.recyclerview);
        tvUsername = view.findViewById(R.id.tvUsername);
        String username = getArguments().getString("welcome");

        tvUsername.setText(tvUsername.getText().toString() + " " + username);
        itemArrayList = new ArrayList<>();

        item1 = new Item("Pizza Panda", 0.0);
        item2 = new Item("KFC Super", 0.0);
        item3 = new Item("Bread Eggs", 0.0);
        item4 = new Item("Coca Cola", 0.0);
        item5 = new Item("Chicken Super", 0.0);
        item6 = new Item("Cup Cake", 0.0);

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
            public void onClickName(String name, Double price) {
                iOnClickItem.onClickItem(name, price);
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof IOnClickItem){
            iOnClickItem = (IOnClickItem) context;
        }
        else{
            throw new RuntimeException(context.toString());
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        iOnClickItem = null;
    }
}
