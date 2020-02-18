package com.rohit.image_gallary;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    private static final String TAG = "HomeFragment";
    ApiInterface apiInterface;
    List<Photo> imagelist;
    List_Adapter adapter;
    RecyclerView recyclerView;


    public HomeFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_home, container, false);
        imagelist=new ArrayList<>();
        recyclerView=view.findViewById(R.id.recyclerview);

            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

            apiInterface=ApiClient.getApiClient().create(ApiInterface.class);
        Call<Model> call= apiInterface.getImage();
       call.enqueue(new Callback<Model>() {
           @Override
           public void onResponse(Call<Model> call, Response<Model> response) {
               imagelist=response.body().getPhotos().getPhoto();
               adapter=new List_Adapter(getContext(),imagelist);
               recyclerView.setAdapter(adapter);
               Log.e(TAG, "onResponse: "+response.body());
           }

           @Override
           public void onFailure(Call<Model> call, Throwable t) {

           }
       });
        return view;
    }


}

