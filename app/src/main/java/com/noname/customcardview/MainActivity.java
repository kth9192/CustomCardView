package com.noname.customcardview;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;

import com.noname.customcardview.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activtyMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activtyMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        ArrayList<CustomModel> list = new ArrayList<>();
        list.add(new CustomModel("one"));
        list.add(new CustomModel("two"));

        TempleteAdapter adapter = new TempleteAdapter(list);
        activtyMainBinding.recycler.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        activtyMainBinding.recycler.setLayoutManager(linearLayoutManager);

        //item divider
//        DividerItemDecoration dividerItemDecoration =
//                new DividerItemDecoration(getApplicationContext(),new LinearLayoutManager(this).getOrientation());
//        activtyMainBinding.recycler.addItemDecoration(dividerItemDecoration);

    }
}
