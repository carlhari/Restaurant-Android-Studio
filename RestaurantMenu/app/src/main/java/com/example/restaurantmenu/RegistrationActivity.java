package com.example.restaurantmenu;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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

public class RegistrationActivity extends AppCompatActivity {

    private TextInputEditText editEmail, editPassword;
    private TextView clickToLogin;
    private Button buttonRegister;
    private ProgressBar progressBar;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        mAuth = FirebaseAuth.getInstance();
        editEmail = findViewById(R.id.txtRegEmail);
        editPassword = findViewById(R.id.txtRegpassword);
        buttonRegister = findViewById(R.id.btnRegister);
        clickToLogin = findViewById(R.id.txtLogin);

        clickToLogin.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);

        });

        buttonRegister.setOnClickListener(view -> {

            String email, password;
            email = editEmail.getText().toString();
            password = editPassword.getText().toString();

            if(TextUtils.isEmpty(email)){
                Toast.makeText(RegistrationActivity.this, "Please enter your email", Toast.LENGTH_SHORT).show();
                return;
            }
            if(TextUtils.isEmpty(password)){
                Toast.makeText(RegistrationActivity.this, "Please enter your password", Toast.LENGTH_SHORT).show();
                return;
            }

            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(task -> {

                        if (task.isSuccessful()) {
                            /*
                             Sign in success, update UI with the signed-in user's information
                             Log.d(TAG, "createUserWithEmail:success");
                             FirebaseUser user = mAuth.getCurrentUser();
                            */
                            Toast.makeText(RegistrationActivity.this, "Account created.",
                                    Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
                            startActivity(intent);
                        } else {
                            // If sign in fails, display a message to the user.
                            // Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(RegistrationActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    });
        });
    }
}