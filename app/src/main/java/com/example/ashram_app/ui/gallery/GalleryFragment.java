package com.example.ashram_app.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ashram_app.AddVideo.VideoProperties;
import com.example.ashram_app.R;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.storage.StorageReference;

public class GalleryFragment extends Fragment {
    FirebaseFirestore db;
    RecyclerView recyclerView;
    StorageReference storageReference;
    Query query;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);
        // Add the following lines to create RecyclerView
        recyclerView = view.findViewById(R.id.recyclerview_Gallery);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

    query = FirebaseFirestore.getInstance()
                .collection("Video");



        return view;

    }

    @Override
    public void onStart() {
        super.onStart();



            FirestoreRecyclerOptions<VideoProperties> response = new FirestoreRecyclerOptions.Builder<VideoProperties>()
                    .setQuery(query, VideoProperties.class)
                    .build();



        FirestoreRecyclerAdapter<VideoProperties, ViewHolder> adapter = new FirestoreRecyclerAdapter
                <VideoProperties, ViewHolder>(response) {

            @NonNull
            @Override
            public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                   View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.video_item, parent, false);
                return new ViewHolder(view);

            }

            @Override
            protected void onBindViewHolder(ViewHolder viewHolder, int i, VideoProperties videoProperties) {


                viewHolder.setExoplayer(getActivity().getApplication(), videoProperties.getName(), videoProperties.getVideourl());

            }

        };
        adapter.startListening();
        recyclerView.setAdapter(adapter);

    }


}



