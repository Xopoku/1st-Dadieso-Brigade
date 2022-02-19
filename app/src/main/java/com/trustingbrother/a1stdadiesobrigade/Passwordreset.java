package com.trustingbrother.a1stdadiesobrigade;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
public class Passwordreset extends AppCompatActivity {
    Button button;
    EditText editText;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passwordreset);
        button = findViewById(R.id.Btnpasswordreset);
        editText = findViewById(R.id.Epasswordreset);
        progressBar = findViewById(R.id.passwprdresetprogressbar);

        button.setOnClickListener(v -> {
            FirebaseAuth auth = FirebaseAuth.getInstance();
            String emailAddress = editText.getText().toString().trim();
            progressBar.setVisibility(View.VISIBLE);

            if (checkusername(emailAddress)) {
                auth.sendPasswordResetEmail(emailAddress)
                        .addOnCompleteListener(task -> {
                            if (task.isSuccessful()) {
                                Toast.makeText(getApplicationContext(), "Password Reset link have been sent to your email", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(getApplicationContext(), "Email does not Exit", Toast.LENGTH_LONG).show();
                            }
                            progressBar.setVisibility(View.GONE);
                        }).addOnFailureListener(e -> {
                            Toast.makeText(getApplicationContext(), "Please Check your network connection well and make sure you enter correct email address", Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                        });
            }
        });

    }

    private boolean checkusername(String username) {
        if (TextUtils.isEmpty(username)) {
            editText.setError("Please Enter Your Email Address");
            progressBar.setVisibility(View.GONE);
            return false;
        }

        return true;
    }

}