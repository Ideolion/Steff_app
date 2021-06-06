package com.example.ashram_app.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ashram_app.R;

import java.util.ArrayList;

public class YoutubeAdapter extends RecyclerView.Adapter<YoutubeViewHolder> {
    ArrayList<DataSetList> arrayList;
    Context context;

    public YoutubeAdapter(ArrayList<DataSetList> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public YoutubeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.video_item_home,parent,false);
        return new YoutubeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull YoutubeViewHolder holder, int position) {
        final DataSetList current = arrayList.get(position);


        YoutubeViewHolder.webView.loadUrl(current.getLink());


//        YoutubeViewHolder.button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent i = new Intent(context,Youtube_fullscreen.class);
//                i.putExtra("link",current.getLink());
//                context.startActivity(i);
//
//
//            }
//        });


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
