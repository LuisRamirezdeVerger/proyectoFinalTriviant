package com.example.triviant;

import android.content.res.Configuration;
import android.media.AudioManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.slider.Slider;

import java.util.Locale;

public class Settings extends AppCompatActivity {

    ImageView Spanish = findViewById(R.id.spain);
    ImageView English = findViewById(R.id.uk);
    Slider Music = findViewById(R.id.SliderMusic);
    Slider Volume = findViewById(R.id.SliderVolume);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_settings);

        Spanish.setOnClickListener(v -> changeLanguage(new Locale("es")));
        English.setOnClickListener(v -> changeLanguage(new Locale("en")));
        Music.addOnChangeListener((slider, value, fromUser) -> adjustMusicVolume(value));
        Volume.addOnChangeListener((slider, value, fromUser) -> adjustGeneralVolume(value));

    }

    private void changeLanguage(Locale newLocale) {
        Locale.setDefault(newLocale);
        Configuration config = new Configuration();
        config.locale = newLocale;
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
        recreate();
    }

    private void adjustMusicVolume(float value) {
        AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int newVolume = (int) (value * maxVolume / 100);
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, newVolume, 0);
    }

    private void adjustGeneralVolume(float value) {
        AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_SYSTEM);
        int newVolume = (int) (value * maxVolume / 100);
        audioManager.setStreamVolume(AudioManager.STREAM_SYSTEM, newVolume, 0);
    }

}