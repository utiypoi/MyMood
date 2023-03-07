package com.example.mymood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private TextInputEditText login, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        login = findViewById(R.id.emailEditText);
        password = findViewById(R.id.passwordEditText);
    }
    public void backLoginActivity(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
    public void registration(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        if(password.getText().toString().length() <8){
            Toast.makeText(this,"Пароль должен содержать не менее 8 символов", Toast.LENGTH_SHORT).show();
        }else if(password.getText().toString().length()==0 || login.getText().toString().length()==0){
            Toast.makeText(this,"Проверьте заполнение полей", Toast.LENGTH_SHORT).show();
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(login.getText().toString()).matches() || login.equals(password)){
            Toast.makeText(this,"Проверьте корректность вводимых данных", Toast.LENGTH_SHORT).show();
        }
        else {
            intent.putExtra("login", login.getText().toString());
            intent.putExtra("password", password.getText().toString());
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }

}