package com.example.final_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Sign_up extends AppCompatActivity {
    EditText fName,uName,pass,cPass,nEmail,date;
    Button registerBtn;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        fName=(EditText) findViewById(R.id.fullName);
        uName=(EditText) findViewById(R.id.user_name);
        pass=(EditText) findViewById(R.id.password);
        cPass=(EditText) findViewById(R.id.confirm_password);
        nEmail=findViewById(R.id.email);
        date=findViewById(R.id.date);
        registerBtn=(Button)findViewById(R.id.sign_upBtn);
        fAuth=FirebaseAuth.getInstance();

        if(fAuth.getCurrentUser() != null)
        {
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }


        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email= nEmail.getText().toString().trim();
                String password=pass.getText().toString().trim();

                if(TextUtils.isEmpty(email))
                {
                    nEmail.setError("Email is required");
                    return;
                }
                if(TextUtils.isEmpty(password))
                {
                    pass.setError("password is required");
                    return;

                }
                if(password.length() <6)
                {
                    pass.setError("Password is required more than 6 characters");
                    return;
                }


                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(Sign_up.this,"User Created",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        }
                        else {
                            Toast.makeText(Sign_up.this,"Error!"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();

                        }

                    }
                });
                startActivity(new Intent(Sign_up.this, second_page.class));

            }
        });

    }
}