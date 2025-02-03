package com.example.triviant;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class Settings extends AppCompatActivity {

    ImageView Spanish = findViewById(R.id.spain);
    ImageView English = findViewById(R.id.uk);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_settings);

        Spanish.setOnClickListener(v -> changeLanguage(new Locale("es")));
        English.setOnClickListener(v -> changeLanguage(new Locale("en")));

    }

    private void changeLanguage(Locale newLocale) {
        Locale.setDefault(newLocale);
        Configuration config = new Configuration();
        config.locale = newLocale;
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
        recreate();
    }

}