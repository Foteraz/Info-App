package com.example.wmp_finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class EventRegister extends AppCompatActivity {
    private EditText insertName, insertBatch, insertEmail, insertPhone;

    private RadioButton CSGO, SOSPRO, COMPSTUD, COMPDAY, COMPSPHERE;
    private Button submit;
    private ImageView buttonBack;

    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_event);

        // Initialize Firebase
        db = FirebaseFirestore.getInstance();

        // Initialize views
        insertName = findViewById(R.id.insertName);
        insertBatch = findViewById(R.id.insertBatch);
        insertEmail = findViewById(R.id.insertEmail);
        insertPhone = findViewById(R.id.insertPhone);
        buttonBack = findViewById(R.id.back);

        CSGO = findViewById(R.id.CSGO);
        SOSPRO = findViewById(R.id.SOSPRO);
        COMPSTUD = findViewById(R.id.COMPSTUD);
        COMPDAY = findViewById(R.id.COMPDAY);
        COMPSPHERE = findViewById(R.id.COMPSPHERE);

        submit = findViewById(R.id.submit);

        // Set onClickListener for the submit button
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitUserData();
            }
        });
    }
    private void submitUserData() {
        // Get user input
        String name = insertName.getText().toString().trim();
        String batch = insertBatch.getText().toString().trim();
        String email = insertEmail.getText().toString().trim();
        String phone = insertPhone.getText().toString().trim();

        // Validate email
        if (!isValidEmail(email)) {
            Toast.makeText(this, "Invalid email format", Toast.LENGTH_SHORT).show();
            return;
        }

        // Check if the user has selected an event
        boolean isCSGOChecked = CSGO.isChecked();
        boolean isSOSPROChecked = SOSPRO.isChecked();
        boolean isCompStudChecked = COMPSTUD.isChecked();
        boolean isCompDayChecked = COMPDAY.isChecked();
        boolean isCompSphereChecked = COMPSPHERE.isChecked();

        // Ensure only one event is selected
        if (!(isCSGOChecked ^ isSOSPROChecked ^ isCompStudChecked ^ isCompDayChecked ^ isCompSphereChecked)) {
            // More than one or no event selected
            Toast.makeText(this, "Please select exactly one event", Toast.LENGTH_SHORT).show();
            return;
        }

        String selectedEvent;
        if (isCSGOChecked) {
            selectedEvent = "CSGO";
        } else if (isSOSPROChecked) {
            selectedEvent = "Social Project";
        } else if (isCompStudChecked) {
            selectedEvent = "Comparative Study";
        } else if (isCompDayChecked) {
            selectedEvent = "Computing Day";
        } else {
            selectedEvent = "Compsphere";
        }

        addDataToFirestore(name, batch, email, phone, selectedEvent);
    }

    private void addDataToFirestore(String name, String batch, String email, String phone, String selectedEvent) {

        // creating a collection reference
        // for our Firebase Firestore database.
        CollectionReference dbParticipants = db.collection("Participants");

        // adding our data to our courses object class.
        Participants participants = new Participants(name, batch, email, phone, selectedEvent);

        // below method is use to add data to Firebase Firestore.
        dbParticipants.add(participants).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                // after the data addition is successful
                // we are displaying a success toast message.
                Toast.makeText(EventRegister.this, "Participants been added to the Database", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                // this method is called when the data addition process is failed.
                // displaying a toast message when data addition is failed.
                Toast.makeText(EventRegister.this, "Fail to add Participants \n" + e, Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void BackButton(View view) {
        Intent intent = new Intent(EventRegister.this , EventCalendar.class);
        startActivity(intent);
    }

    private boolean isValidEmail(String email) {
        // Add your email validation logic here
        return email.endsWith("@student.president.ac.id");
    }

}
