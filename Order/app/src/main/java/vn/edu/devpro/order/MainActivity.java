package vn.edu.devpro.order;

import androidx.annotation.LongDef;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OrderFragment.IOnClickItem {

    private static final String TAG = "MainActivity";
    BottomNavigationView bnv;

    ShoppingCartFragment shoppingCartFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bnv = findViewById(R.id.bnv);
        final String welcome = getIntent().getStringExtra("Username");
        getFragment(OrderFragment.newInstance(welcome));
        shoppingCartFragment = new ShoppingCartFragment();

        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.mnHome:
                        getFragment(OrderFragment.newInstance(welcome));
                        break;
                    case R.id.mnCart:
                        getFragment(shoppingCartFragment);
                        break;
                }
                return false;
            }
        });
    }

    public void getFragment(Fragment fragment){
        try{
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit();
        }catch (Exception e){
            e.printStackTrace();
            Log.d(TAG, "getFrament: " + e.getMessage());
        }
    }

    @Override
    public void onClickItem(String name, Double price) {
        shoppingCartFragment = new ShoppingCartFragment();
        Bundle bundle = new Bundle();
        bundle.putString("nameOfProduct", name);
        bundle.putDouble("priceOfProduct", price);
        shoppingCartFragment.setArguments(bundle);
    }
}
