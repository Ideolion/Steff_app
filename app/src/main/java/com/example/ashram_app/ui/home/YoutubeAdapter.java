package com.example.ashram_app.ui.home;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ashram_app.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

import static com.example.ashram_app.Value.admin1UID;

public class YoutubeAdapter extends RecyclerView.Adapter<YoutubeViewHolder> {
    ArrayList<DataSetList> arrayList;
    Context context;
    String URL;
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

        YoutubeViewHolder.webView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                URL = current.getLink();

                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                String userid = user.getUid();
                if (userid.equals(admin1UID)) {
                    Toast.makeText(context.getApplicationContext(), "длинный ютуб", Toast.LENGTH_SHORT).show();
                    showDeleteDialog(URL);

                }


                return false;
            }
        });

 }



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




    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    private void showDeleteDialog(String url) {
        Toast.makeText(context.getApplicationContext(), "Длинный клик по ютубу", Toast.LENGTH_SHORT).show();

        AlertDialog.Builder builder = new AlertDialog.Builder(context.getApplicationContext());
        builder.setTitle("Удалить видео Youtube");
        builder.setMessage("Вы уверены что хотите удалить это видео Youtube");
//
//
//
//
//
        AlertDialog alertDialog = builder.create();
       builder.show();



    }

}


