package com.example.ashram_app.ui.gallery;

import android.app.Application;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.ashram_app.R;
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

public class ViewHolder extends RecyclerView.ViewHolder {
    SimpleExoPlayer exoPlayer;
    PlayerView playerView;
    ImageView fullscreenButton;
    boolean fullscreen = false;

    public ViewHolder(View itemView) {

        super(itemView);
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
//            fullscreenButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if(fullscreen) {
//                        fullscreenButton.setImageDrawable(ContextCompat.getDrawable(, R.drawable.ic_fullscreen_open)); /*было */
//                        ((Activity) getContext()).getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
//
//                        if(((AppCompatActivity)getActivity()).getSupportActionBar() != null){
//                            ((AppCompatActivity)getActivity()).getSupportActionBar().show();
//                        }
//                        ((AppCompatActivity)getActivity()).setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//                        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) playerView.getLayoutParams();
//                        params.width = params.MATCH_PARENT;
//                        params.height = (int) ( 200 * ((AppCompatActivity)getActivity()).getApplicationContext().getResources().getDisplayMetrics().density);
//                        playerView.setLayoutParams(params);
//                        fullscreen = false;
//                    }else{
//                        fullscreenButton.setImageDrawable(ContextCompat.getDrawable(recyclerView.getContext(), R.drawable.ic_fullscreen_close));
//                        ((Activity) getContext()).getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN
//                                |View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
//                                |View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
//                        if(((AppCompatActivity)getActivity()).getSupportActionBar() != null){
//                            ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
//                        }
//                        ((AppCompatActivity)getActivity()).setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//                        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) playerView.getLayoutParams();
//                        params.width = params.MATCH_PARENT;
//                        params.height = params.MATCH_PARENT;
//                        playerView.setLayoutParams(params);
//                        fullscreen = true;
//                    }
//                }
//            });








        } catch (Exception e) {

        }


    }


}







