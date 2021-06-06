package com.example.ashram_app.ui.meditation;

public class DurationTime {
    public static String convertation (Long duration){
        long minutes = (duration/1000)/60;
        long seconds = (duration/1000)%60;
        String converted = String.format("%d:%02d",minutes,seconds);
        return converted;


    }
}
