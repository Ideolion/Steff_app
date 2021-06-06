package com.example.ashram_app.ui.meditation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ashram_app.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Audio_Adapter extends RecyclerView.Adapter<Audio_Adapter.ViewHolderAudio> {
    private int selectedPosition;
   Context context;
    List<AudioProperties> audioList;
    private RecyclerListener Listener;

    public Audio_Adapter(Context context, List<AudioProperties> audioList, RecyclerListener listener) {
        this.context = context;
        this.audioList = audioList;
        Listener = listener;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolderAudio onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
     View view = LayoutInflater.from(context).inflate(R.layout.audio_item,parent,false);



        return new ViewHolderAudio(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolderAudio holder, int position) {
    AudioProperties AudioProperties = audioList.get(position);
    if(AudioProperties!= null){
        if(selectedPosition == position) {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.Color1));
            holder.play.setVisibility(View.VISIBLE);
        }else{
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.Color3));
            holder.play.setVisibility(View.INVISIBLE);
        }
    }
        holder.audio_name.setText(AudioProperties.getAudioName());
       String duration = DurationTime.convertation(Long.parseLong(AudioProperties.getAudioDuration()));
        holder.duration.setText(duration);
        holder.bind(AudioProperties, Listener);

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(context,)
//
//            }
//        });





    }

    @Override
    public int getItemCount() {
        return audioList.size();
    }



    public interface RecyclerListener {
        void onClickListener (AudioProperties audio, int position);


    }
    public class ViewHolderAudio extends RecyclerView.ViewHolder {
        private TextView audio_name, duration;
        ImageView play;


        public ViewHolderAudio(@NonNull @NotNull View itemView) {
            super(itemView);
            audio_name = itemView.findViewById(R.id.audio_name);
            duration = itemView.findViewById(R.id.duration);
            play = itemView.findViewById(R.id.play);


        }

        public void bind(AudioProperties audioProperties, RecyclerListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClickListener(audioProperties,getBindingAdapterPosition());/*изменил устаревший метод*/
                }
            });


        }
    }

    public int getSelectedPosition() {
        return selectedPosition;
    }

    public void setSelectedPosition(int selectedPosition) {
        this.selectedPosition = selectedPosition;
    }
}



