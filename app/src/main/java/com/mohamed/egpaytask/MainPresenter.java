package com.mohamed.egpaytask;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainPresenter implements IPresenter{

    private Context context;
    MainView mainView;

    public MainPresenter(Context context,MainView mainView){
        this.context = context;
        this.mainView = mainView;
    }

    public String readJsonFromFile(){

        String json;
        try {
            InputStream inputStream = context.getAssets().open("data.json");
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return  null;
        }
        return json;
    }

    @Override
    public void getAllModels(){
        ArrayList<DataModel> dataModels = new ArrayList<>();
        try {
            JSONArray json = new JSONArray(readJsonFromFile());
            for (int i = 0; i < json.length(); i++) {

                JSONObject object = json.getJSONObject(i);
                DataModel model = new DataModel(
                        object.getInt(Constants.id),
                        object.getString(Constants.name),
                        object.getString(Constants.type),
                        object.getString(Constants.default_value),
                        object.getString(Constants.multiple),
                        object.getString(Constants.sort),
                        object.getString(Constants.required).equals("yes")
                );
                dataModels.add(model);
            }
            mainView.updateUI(dataModels);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
