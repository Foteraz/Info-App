package com.example.wmp_finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    private Button buttonLogin;
    private EditText userLogin, userPass;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        buttonLogin = findViewById(R.id.button2);
        userLogin = findViewById(R.id.username);
        userPass = findViewById(R.id.password);

        auth = FirebaseAuth.getInstance();

        buttonLogin.setOnClickListener(v -> {
            String username = userLogin.getText().toString();
            String password = userPass.getText().toString();
            if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
                Toast.makeText(Login.this, "Input username and password", Toast.LENGTH_SHORT).show();
            } else {
                signInWithEmail(username, password);
            }
        });
    }

    public void next(View view){
        Intent intent = new Intent(Login.this, Register.class);
        startActivity(intent);
    }

    private void signInWithEmail(String username, String password) {
        auth.signInWithEmailAndPassword(username, password).addOnCompleteListener(task -> {
            if (task.isSuccessful()){
                Intent intent = new Intent(Login.this, NewsUpdate.class);
                startActivity(intent);
                Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(Login.this, "Login Failed", Toast.LENGTH_SHORT).show();
            }
        });

    }


}