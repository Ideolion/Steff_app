package com.example.ashram_app.ui.meditation;

public class AudioProperties {
  String audioName, audioURL, audioDuration, mKey;

    public AudioProperties() {
    }

    public AudioProperties(String audioName, String audioURL, String audioDuration) {
        this.audioName = audioName;
        this.audioURL = audioURL;
        this.audioDuration = audioDuration;
    }

    public String getAudioName() {
        return audioName;
    }

    public void setAudioName(String audioName) {
        this.audioName = audioName;
    }

    public String getAudioURL() {
        return audioURL;
    }

    public void setAudioURL(String audioURL) {
        this.audioURL = audioURL;
    }

    public String getAudioDuration() {
        return audioDuration;
    }

    public void setAudioDuration(String audioDuration) {
        this.audioDuration = audioDuration;
    }

    public String getmKey() {
        return mKey;
    }

    public void setmKey(String mKey) {
        this.mKey = mKey;
    }
}
