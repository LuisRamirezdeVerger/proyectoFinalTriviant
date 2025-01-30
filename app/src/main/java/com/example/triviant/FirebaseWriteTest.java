package com.example.triviant;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseWriteTest {

    public void writeData() {
        // Initialize Firebase Database
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://rollyourchoice-default-rtdb.europe-west1.firebasedatabase.app/");
        DatabaseReference myRef = database.getReference("testMessage");

        // Escribe un mensaje en la ruta "testMessage"
        myRef.setValue("Hola, Firebase!");
    }
}
