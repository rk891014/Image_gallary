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

public class Search_Adapter extends RecyclerView.Adapter<Search_Adapter.ViewHolder> implements Filterable {

    private static final String TAG = "Search_Adapter";

    private Context mcontext;
    public List<Photo> imagelist;
    public List<Photo> imagelistfull;


    public Search_Adapter(Context mcontext, List<Photo> imagelist) {
        this.imagelist=imagelist;
        this.mcontext=mcontext;
        imagelistfull=new ArrayList<>(imagelist);

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item2, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Photo photo=imagelist.get(position);
        holder.id.setText(photo.getId());
        Glide.with(mcontext).load(photo.geturl_s()).into(holder.image1);

    }



    @Override
    public int getItemCount() {
        return imagelist.size();
    }

    @Override
    public Filter getFilter() {
        return imagefilter;
    }
    private Filter imagefilter=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Photo> filterlist=new ArrayList<>();
            if(constraint== null && constraint.length()==0){
                filterlist.addAll(imagelistfull);
            }else {
                String filterpattern=constraint.toString().toLowerCase().trim();

                for (Photo item : imagelistfull) {
                    if (item.getId().toLowerCase().contains(filterpattern)) {
                        filterlist.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filterlist;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            imagelist.clear();
            imagelist.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView id;
        ImageView image1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            id=itemView.findViewById(R.id.item1);
            image1=itemView.findViewById(R.id.image1);


        }
    }


}
