package com.rohit.image_gallary;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class List_Adapter extends RecyclerView.Adapter<List_Adapter.ViewHolder> {

    private static final String TAG = "List_Adapter";

    private Context mcontext;
    public List<Photo> imagelist;
    public List<Photo> imagelistfull;


    public List_Adapter(Context mcontext, List<Photo> imagelist) {
        this.imagelist=imagelist;
        this.mcontext=mcontext;
        imagelistfull=new ArrayList<>(imagelist);

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Photo photo=imagelist.get(position);
        holder.id.setText(photo.getId());
        holder.title.setText(photo.getTitle());
        Log.d(TAG, "onBindViewHolder: "+photo.toString());
        Glide.with(mcontext).load(photo.geturl_s()).into(holder.image_profile);
        Log.d(TAG, "onBindViewHolder2: "+photo.geturl_s());

    }



    @Override
    public int getItemCount() {
        return imagelist.size();
    }




    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image_profile;
        TextView id,title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image_profile=itemView.findViewById(R.id.image);
            id=itemView.findViewById(R.id.id);
            title=itemView.findViewById(R.id.title);


        }
    }


}
