package com.example.final_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class third extends AppCompatActivity {
    Button button, loginBtn;
    EditText nEmail, nPass;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        nEmail = findViewById(R.id.Email);
        nPass = findViewById(R.id.Password);
        fAuth = FirebaseAuth.getInstance();
        loginBtn = findViewById(R.id.login_button);

        loginBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String email= nEmail.getText().toString().trim();
                String password=nPass.getText().toString().trim();

                if(TextUtils.isEmpty(email))
                {
                    nEmail.setError("Email is required");
                    return;
                }
                if(TextUtils.isEmpty(password))
                {
                    nPass.setError("password is required");
                    return;

                }

                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(third.this,"Logged in",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        }else {
                            Toast.makeText(third.this,"Error!"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();

                        }

                    }
                });

                startActivity(new Intent(third.this, home_page.class));

            }
        });



        button = (Button) findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                startActivity(new Intent(third.this, Sign_up.class));


            }

        });




    }
}