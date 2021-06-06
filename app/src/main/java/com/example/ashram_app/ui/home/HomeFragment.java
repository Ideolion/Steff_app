package com.example.ashram_app.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ashram_app.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.annotations.NotNull;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

import static com.example.ashram_app.Value.admin1UID;

public class HomeFragment extends Fragment {
    FirebaseFirestore db;

    RecyclerView recyclerView;
    ArrayList<DataSetList> arrayList;
    private MenuItem action_addVideo;
    private MenuItem search;
    Query query;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        db = FirebaseFirestore.getInstance();

        setHasOptionsMenu(true);
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        // Add the following lines to create RecyclerView
        recyclerView = view.findViewById(R.id.recyclerview_Home);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        arrayList = new ArrayList<>();
        db.collection("YoutubeLink")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                StringBuffer sb = new StringBuffer(document.getData().toString());
                                sb.delete(0, 12);
                                sb.setLength(sb.length() - 1);
                                DataSetList dataSetList = new DataSetList(sb.toString());
                                arrayList.add(dataSetList);
                            }
                            YoutubeAdapter youtubeAdapter = new YoutubeAdapter(arrayList, getActivity().getApplication());
                            recyclerView.setAdapter(youtubeAdapter);
                        } else {
                            Toast.makeText(getActivity(), "Ошибка загрузки данных", Toast.LENGTH_SHORT).show();

                        }
                    }
                });
        return view;
    }


    @Override
    public void onCreateOptionsMenu(@NonNull @NotNull Menu menu, @NonNull @NotNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        search = menu.findItem(R.id.search_firebase);
        action_addVideo = menu.findItem(R.id.action_addVideo);
        search.setVisible(false);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String userid = user.getUid();
        if (userid.equals(admin1UID)) {
            action_addVideo.setVisible(true);

        }
        super.onCreateOptionsMenu(menu, inflater);


    }


}
