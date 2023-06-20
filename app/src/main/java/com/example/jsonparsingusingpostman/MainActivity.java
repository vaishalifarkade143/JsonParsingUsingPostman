package com.example.jsonparsingusingpostman;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
   // ListView list;
    RecyclerView recycle;

    int[] arr_img ={R.drawable.person};
    ArrayList<String> arrNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        recycle_view = (RecyclerView) findViewById(R.id.recycle_view);

        //aise data lekar jayenge MyAdapter ke constructor me data set Karenge
        MyAdapter myAdapter = new MyAdapter(arr_img,arrNames);  //ye data MyAdapter  ke instance me set ho gaye using constructor

        //4. use of LinearLayout for verticle
        recycle_view.setLayoutManager(new LinearLayoutManager(this));
        recycle_view.setAdapter(myAdapter);



        //list =(ListView) findViewById(android.R.id.list);
        recycle = (RecyclerView)findViewById(R.id.recycle);
        MyAdapter myAdapter1 = new MyAdapter(img,name);

        String url = "https://jsonplaceholder.typicode.com/comments";  //get

        //ArrayList<String> arrNames = new ArrayList<>();

        arrNames = new ArrayList<>();

        AndroidNetworking.initialize(this);//getContext
        AndroidNetworking.get(url)
                .setPriority(Priority.HIGH)
                .build()//actual api hit n connect to server
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("RES",response.toString());
                        //parsing
                        try {
                            for(int i = 0 ; i < response.length() ; i++)
                            {
                                JSONObject objResult = response.getJSONObject(i);
                                String name = objResult.getString("name");
                                //String email = objResult.getString("email");

                                arrNames.add(name);

                               // ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,arrNames);
                                // list.setAdapter(arrayAdapter);



                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onError(ANError anError) {
                        anError.printStackTrace();
                        Log.e("ERROR",anError.toString());
                    }
                });
    }
}