package com.example.wmp_finalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class Register extends AppCompatActivity {
    private Button register;
    private FirebaseAuth auth;

    private EditText insertEmail, insertPassword;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        auth = FirebaseAuth.getInstance();

        insertEmail = findViewById(R.id.insertEmail);
        insertPassword = findViewById(R.id.insertPassword);
        register = findViewById(R.id.button);

        register.setOnClickListener(v -> {
            String username = insertEmail.getText().toString();
            String password = insertPassword.getText().toString();

            if (!isValidEmail(username)|| TextUtils.isEmpty(password)){
                Toast.makeText(Register.this, "Input username and password", Toast.LENGTH_SHORT).show();
            } else {
                registerUser(username, password);
            }
        });
    }

    private void registerUser(String username, String password) {
        auth.createUserWithEmailAndPassword(username, password).addOnCompleteListener(task -> {
            if (task.isSuccessful()){
                Intent intent = new Intent(Register.this, NewsUpdate.class);
                startActivity(intent);
                Toast.makeText(Register.this, "Register Successful", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(Register.this, "Register Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean isValidEmail(String email) {
        // Add your email validation logic here
        return email.endsWith("@student.president.ac.id");
    }

}