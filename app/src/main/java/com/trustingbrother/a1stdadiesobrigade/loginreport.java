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

public class loginreport extends AppCompatActivity {
    EditText userName, Password;
    Button button;
    TextView textView;
    FirebaseAuth mAuth;
    ProgressBar progressBar;
    FirebaseUser firebaseUser;
    FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginreport);
        button = findViewById(R.id.Btnloginreport);
        userName = findViewById(R.id.Eloginreport);
        Password = findViewById(R.id.Ploginreport);
        textView = findViewById(R.id.forgetloginreport);
        mAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.loginreportprogressbar);



        textView.setOnClickListener(v -> startActivity(new Intent((loginreport.this),Passwordreset.class)));

         authStateListener = firebaseAuth -> {
             firebaseUser = firebaseAuth.getCurrentUser();
             if (firebaseUser != null){
                 Intent intent = new Intent(loginreport.this,AnnualReportwebview.class);
                 startActivity(intent);
                 finish();
             }
         };



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
                            startActivity(new Intent((loginreport.this), AnnualReportwebview.class));
                            finish();
                            progressBar.setVisibility(View.GONE);

                        } else {
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(getApplicationContext(),"Login Failed due to network or incorrect credentials entered", Toast.LENGTH_LONG).show();
                        }

                        // ...
                    });
        }

    }

    private boolean checkusername(String username) {
        if (TextUtils.isEmpty(username)) {
            userName.setError("Please Enter Your Username");
            progressBar.setVisibility(View.GONE);
            return false;
        }

        return true;
    }




    private boolean checkuserpassword(String password){
        if(TextUtils.isEmpty(password)){
            Password.setError("Please Enter Your Password");
            progressBar.setVisibility(View.GONE);
            return false;
        }
        else if(password.length()< 6 || password.length() > 10){
            Password.setError("Password should have 6 to 10 characters");
            progressBar.setVisibility(View.GONE);
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