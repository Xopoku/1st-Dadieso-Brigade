package com.trustingbrother.a1stdadiesobrigade;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class loginmembership extends AppCompatActivity {
    EditText userName;
    EditText Password;
    Button button;
    TextView textView;
    FirebaseAuth mAuth;
    FirebaseUser firebaseUser;
    FirebaseAuth.AuthStateListener authStateListener;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginmembership);
        button = findViewById(R.id.Btnloginmembership);
        userName = findViewById(R.id.Eloginmembership);
        Password = findViewById(R.id.Ploginmembership);
        textView = findViewById(R.id.forgetmembership);
        progressBar = findViewById(R.id.loginmembershipprogressbar);
        mAuth = FirebaseAuth.getInstance();

        authStateListener = firebaseAuth -> {
            firebaseUser = firebaseAuth.getCurrentUser();
            if (firebaseUser != null){
                Intent intent = new Intent(loginmembership.this,MusicMore.class);
                startActivity(intent);
                finish();
            }
        };


        textView.setOnClickListener(v -> startActivity(new Intent((loginmembership.this),Passwordreset.class)));

        button.setOnClickListener(v -> {
            progressBar.setVisibility(View.VISIBLE);
            register();

        });
    }

    public void register(){
        String username = userName.getText().toString().trim();
        String password = Password.getText().toString().trim();
        //Toast.makeText(getApplicationContext(),"Login Successful", Toast.LENGTH_SHORT).show();
        if(checkusername(username) && checkuserpassword(password)) {
            mAuth.signInWithEmailAndPassword(username, password)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(),"Login Successful", Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.INVISIBLE);
                            startActivity(new Intent((loginmembership.this), MusicMore.class));
                            finish();

                        } else {
                            Toast.makeText(getApplicationContext(),"Login Failed due to network or incorrect credentials entered", Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.INVISIBLE);
                        }

                        // ...
                    });
        }

    }

    private boolean checkusername(String username) {
        if (TextUtils.isEmpty(username)) {
            userName.setError("Please Enter Your Username");
            progressBar.setVisibility(View.INVISIBLE);
            return false;
        }

        return true;
    }

    private boolean checkuserpassword(String password){
        if(TextUtils.isEmpty(password)){
            Password.setError("Please Enter Your Password");
            progressBar.setVisibility(View.INVISIBLE);
            return false;
        }
        else if(password.length()< 6 || password.length() > 10){
            Password.setError("Password should have 6 to 10 characters");
            progressBar.setVisibility(View.INVISIBLE);
            return false;
        }
        return true;
    }
    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(authStateListener);
    }
}