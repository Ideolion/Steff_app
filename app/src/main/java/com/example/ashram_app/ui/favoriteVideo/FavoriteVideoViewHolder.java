package com.example.ashram_app.ui.favoriteVideo;

import android.app.Application;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.ashram_app.R;
import com.example.ashram_app.ui.gallery.ViewHolder;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;

public class FavoriteVideoViewHolder extends RecyclerView.ViewHolder{

    SimpleExoPlayer exoPlayer;
    PlayerView playerView;
    ImageView fullscreenButton;
    boolean fullscreen = false;
    private ViewHolder.ClickListener mClickListener;

    public FavoriteVideoViewHolder(View itemView) {

        super(itemView);

        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                mClickListener.OnItemLongClick(view,getAdapterPosition());
                return false;
            }
        });

    }


    public void setExoplayer(Application application, String name, String videourl) {
        TextView textView = itemView.findViewById(R.id.fb_video_name);
        playerView = itemView.findViewById(R.id.exoplayer_item);

        textView.setText(name);
        try {
            BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter.Builder(application).build();
            TrackSelector trackSelector = new DefaultTrackSelector(new AdaptiveTrackSelection.Factory(bandwidthMeter));
            exoPlayer = ExoPlayerFactory.newSimpleInstance(application);
            Uri video = Uri.parse(videourl);
            DefaultHttpDataSourceFactory dataSourceFactory = new DefaultHttpDataSourceFactory("video");
            ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();
            MediaSource mediaSource = new ExtractorMediaSource(video, dataSourceFactory, extractorsFactory, null, null);
            playerView.setPlayer(exoPlayer);
            exoPlayer.prepare(mediaSource);
            exoPlayer.setPlayWhenReady(false);
            fullscreenButton = itemView.findViewById(R.id.exo_fullscreen_icon);
        } catch (Exception e) {
        }
    }



    public interface ClickListener {
        void OnItemLongClick(View view, int position);
    }

    public void SetOnClickListener(ViewHolder.ClickListener clickListener) {
        mClickListener = clickListener;
    }
}










