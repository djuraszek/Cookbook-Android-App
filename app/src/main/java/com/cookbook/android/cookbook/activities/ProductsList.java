package com.cookbook.android.cookbook.activities;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.cookbook.android.cookbook.DatabaseHelper;
import com.cookbook.android.cookbook.R;
import com.cookbook.android.cookbook.adapters.ProductsFragment;
import com.cookbook.android.cookbook.adapters.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ProductsList extends AppCompatActivity {
    TextView categoryTV;
    ListView productLV;
    ViewPager viewPager;
    Button searchButton;
    private List<String> categoriesList;
    public DatabaseHelper db ;

    public ViewPagerAdapter adapter;
    List<Integer> chosenIngredients;
    //todo this activity shows all produts availble
    //todo fragment manager?
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_list);
        db = new DatabaseHelper(getApplicationContext());
        //todo get all categories
        categoriesList = db.getDistinctCategories();
        Log.e("ProductsList","caegoriesList.size() "+categoriesList.size());

        //todo get PageViewer
        viewPager = (ViewPager)findViewById(R.id.productListVP);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        searchButton = (Button)findViewById(R.id.prodListButton);

        for(int i=0; i<categoriesList.size(); i++) {
            Bundle args = new Bundle();

            String categoryName = categoriesList.get(i);
            args.putString("categoryName", categoryName);
            ProductsFragment fragment = new ProductsFragment(db, categoryName);
            fragment.setArguments(args);
            adapter.addFragment(fragment, categoryName);
        }
        viewPager.setAdapter(adapter);
        createIngredientsList();
        showFilteredRecipes();
    }

//    public void setVals(){
//        categoryTV = (TextView)findViewById(R.id.categoryTV);
//        productLV = (ListView)findViewById(R.id.productLV);
//        //TODO get list of products for category
//        ProductsListAdapter adapter = new ProductsListAdapter(getApplicationContext(),null);
//        productLV.setAdapter(adapter);
//    }

    public void createIngredientsList() {
        this.chosenIngredients = new ArrayList<>();
        chosenIngredients.add(10);
        chosenIngredients.add(11);
        chosenIngredients.add(55);
    }

    public void showFilteredRecipes() {
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), RecipesListActivity.class);
                intent.putExtra("showFilteredList", true);
                intent.putIntegerArrayListExtra("chosenIngredients", (ArrayList<Integer>) chosenIngredients);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("ProductsList","onDestroy()");
//        Intent intent = new Intent(getApplicationContext(), Menu.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        startActivity(intent);
    }

    @Override
    protected void onStart() {
        Log.d("ProductsList","onStart()");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.d("ProductsList","onStop()");
        super.onStop();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.d("ProductsList","onRestoreInstanceState()");
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onRestart() {
        Log.d("ProductsList","onRestart()");
        super.onRestart();
    }

    @Override
    public void onAttachedToWindow() {
        Log.d("ProductsList","onAttachedToWindow()");
        super.onAttachedToWindow();
    }

    @Override
    public void onDetachedFromWindow() {
        Log.d("ProductsList","onDetachedFromWindow()");
        super.onDetachedFromWindow();
    }
}