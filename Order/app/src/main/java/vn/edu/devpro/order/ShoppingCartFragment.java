package vn.edu.devpro.order;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ShoppingCartFragment extends Fragment {
    TextView tv;
    Item item;
    public static ShoppingCartFragment newInstance() {
        
        Bundle args = new Bundle();

        ShoppingCartFragment fragment = new ShoppingCartFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shopping_cart, container, false);
        tv = view.findViewById(R.id.tv);


        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        item = (Item) getArguments().getSerializable("item");
        tv.setText(String.valueOf(item.getAmount()));
//        item = new Item("abc", 3);
//        tv.setText(String.valueOf(item.getAmount()));
    }
}
