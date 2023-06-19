package com.example.restaurantmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText editEmail, editPassword;
    private TextView clickToRegister;
    private Button buttonLogin;

    FirebaseAuth mAuth;


    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent checkIntent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(checkIntent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        editEmail = findViewById(R.id.txtLoginEmail);
        editPassword = findViewById(R.id.txtLoginPassword);
        clickToRegister = findViewById(R.id.txtRegister);
        buttonLogin = findViewById(R.id.btnLogin);


        clickToRegister.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), RegistrationActivity.class);
            startActivity(intent);
            finish();
        });

        buttonLogin.setOnClickListener(v -> {

            String email, password;
            email = editEmail.getText().toString();
            password = editPassword.getText().toString();

            if (TextUtils.isEmpty(email)) {
                Toast.makeText(LoginActivity.this, "Please enter your email", Toast.LENGTH_SHORT).show();
                return;
            }
            if (TextUtils.isEmpty(password)) {
                Toast.makeText(LoginActivity.this, "Please enter your password", Toast.LENGTH_SHORT).show();
                return;
            }

            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(task -> {

                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                            startActivity(intent);


                        } else {
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    });
        });
    }
}