package com.mohamed.egpaytask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainPresenter presenter = new MainPresenter(this, this);
        presenter.getAllModels();
    }

    @Override
    public void updateUI(List<DataModel> dataModels) {
        Log.d("res : ", dataModels.size() + "");
        LinearLayout layout = linearContainer();
        for (int i = 0; i < dataModels.size(); i++) {
            DataModel model = dataModels.get(i);
            if (model.type.equals("string")) {
                EditText editText = new EditText(this);
                editText.setHint(model.name);
                editText.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
                editText.setId(model.id);
                layout.addView(editText);
            } else if (model.type.equals("number")) {
                EditText editText = new EditText(this);
                editText.setHint(model.name);
                editText.setInputType(InputType.TYPE_CLASS_NUMBER);
                editText.setId(model.id);
                layout.addView(editText);
            } else if (model.type.equals("date")) {

            } else if (model.type.equals("textarea")) {

            } else if (model.type.equals("select")) {

            }
        }
        Button button = new Button(this);
        button.setText("Submit");
        layout.addView(button);
        setContentView(layout);
    }

    private LinearLayout linearContainer() {
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        layout.setLayoutParams(params);
        return layout;
    }

    enum Type {
        string, number, date, textarea, select
    }
}
