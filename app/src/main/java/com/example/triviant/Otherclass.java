package com.example.triviant;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class Otherclass extends AppCompatActivity {

    private Button changeLanguageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otherclass);

        changeLanguageButton = findViewById(R.id.change_language_button);

        changeLanguageButton.setOnClickListener(v -> {
            Locale current = getResources().getConfiguration().locale;
            Locale newLocale = current.equals(new Locale("es")) ? new Locale("en") : new Locale("es");
            changeLanguage(newLocale);
        });
    }

    private void changeLanguage(Locale newLocale) {
        Locale.setDefault(newLocale);
        Configuration config = new Configuration();
        config.locale = newLocale;
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
        recreate();
    }
}

