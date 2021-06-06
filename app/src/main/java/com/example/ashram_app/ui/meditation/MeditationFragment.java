package com.example.ashram_app.ui.meditation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ashram_app.R;
import com.example.jean.jcplayer.model.JcAudio;
import com.example.jean.jcplayer.view.JcPlayerView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import static com.example.ashram_app.Value.admin1UID;

public class MeditationFragment extends Fragment {
    private MenuItem action_addVideo;
    private MenuItem search;
    RecyclerView recyclerView;
    FirebaseFirestore db;
    ProgressBar progressBar;
    boolean checkin = false;
    List<AudioProperties> mupload;
    Audio_Adapter adapter;
    ValueEventListener valueEventListener;
    JcPlayerView jcPlayerView;
    ArrayList<JcAudio> jcAudios = new ArrayList<>();
    private int currentIndex;
  //  Query query;
    DatabaseReference databaseReference;




    public MeditationFragment(){
        super(R.layout.fragment_meditation);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);

        View view = inflater.inflate(R.layout.fragment_meditation, container, false);

        recyclerView = view.findViewById(R.id.recyclerview_Audio);
        progressBar = view.findViewById(R.id.progressBarrAudio);
        jcPlayerView = view.findViewById(R.id.jcplayer);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        mupload = new ArrayList<>();
        recyclerView.setAdapter(adapter);
        adapter = new Audio_Adapter(getActivity().getApplication(), mupload, new Audio_Adapter.RecyclerListener() {
            @Override
            public void onClickListener(AudioProperties audio, int position) {
                jcPlayerView.playAudio(jcAudios.get(position));
                jcPlayerView.setVisibility(View.VISIBLE);
                jcPlayerView.createNotification();

            }
        });

        databaseReference = FirebaseDatabase.getInstance().getReference("Audio");


        valueEventListener = databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                mupload.clear();
                for(DataSnapshot dss: snapshot.getChildren()){
                    AudioProperties audioProperties = dss.getValue(AudioProperties.class);
                    audioProperties.setmKey(dss.getKey());
                    currentIndex = 0;
                    final String s = getActivity().getIntent().getExtras().getString("");


                }
                adapter.setSelectedPosition(0);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                progressBar.setVisibility(View.GONE);
                if(checkin){
                    jcPlayerView.initPlaylist(jcAudios,null);

                }else{
                    Toast.makeText(getContext(),"Нет аудио для воспроизведения", Toast.LENGTH_SHORT).show();
                }




            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                progressBar.setVisibility(View.GONE);

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
        String userid=user.getUid();
        if(userid.equals(admin1UID)){
            action_addVideo.setVisible(true);

        }
        super.onCreateOptionsMenu(menu, inflater);


    }






}