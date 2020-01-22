package com.mohamed.egpaytask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainPresenter presenter = new MainPresenter(this,this);
        presenter.getAllModels();
    }

    @Override
    public void updateUI(List<DataModel> dataModels) {
        Log.d("res : ",dataModels.size()+"");
    }
}
