package com.example.triviant;

import android.content.Intent;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.slider.Slider;

import java.util.Locale;

public class Settings extends AppCompatActivity {

    ImageView Spanish;
    ImageView English;
    TextView Confirm;
    ImageView Cancel;
    ImageView buttonBack;
    Slider Music;
    Slider Volume;
    Switch Vibrations;
    Switch Effects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_settings);

        Spanish = findViewById(R.id.spain);
        English = findViewById(R.id.uk);
        Music = findViewById(R.id.SliderMusic);
        Volume = findViewById(R.id.SliderVolume);
        Vibrations = findViewById(R.id.vibrationSwitch);
        Effects = findViewById(R.id.soundSwitch);
        Confirm = findViewById(R.id.buttonConfirm);
        Cancel = findViewById(R.id.buttonCancel);
        buttonBack = findViewById(R.id.back);

        Spanish.setOnClickListener(v -> changeLanguage(new Locale("es")));
        English.setOnClickListener(v -> changeLanguage(new Locale("en")));
        Music.addOnChangeListener((slider, value, fromUser) -> adjustMusicVolume(value));
        Volume.addOnChangeListener((slider, value, fromUser) -> adjustGeneralVolume(value));
        Vibrations.setOnCheckedChangeListener((buttonView, isChecked) -> toggleVibration(isChecked));
        Effects.setOnCheckedChangeListener((buttonView, isChecked) -> toggleEffects(isChecked));
        Confirm.setOnClickListener(v ->
        {
            openBack();
        });
        Cancel.setOnClickListener(v ->
        {
            openBack();
        });
        buttonBack.setOnClickListener(v ->
        {
            openBack();
        });

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

    private void toggleVibration(boolean isChecked) {
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        if (isChecked) {
            vibrator.vibrate(500);
        } else {
            vibrator.cancel();
        }
    }

    private void toggleEffects(boolean isChecked) {
        AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        if (isChecked) {
            audioManager.setStreamMute(AudioManager.STREAM_SYSTEM, false);
        } else {
            audioManager.setStreamMute(AudioManager.STREAM_SYSTEM, true);
        }
    }

    void openBack() {
        Intent intent = new Intent(this, Title.class);

        startActivity(intent);
    }

}