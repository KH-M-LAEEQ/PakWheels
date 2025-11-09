package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class SignUpPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextView login=findViewById(R.id.BottomSignUpText);
        login.setOnClickListener(v->{
            Intent intent= new Intent(SignUpPage.this , LoginPage.class);
            startActivity(intent);
        });

        Button signup=findViewById(R.id.SignUpButton);
        signup.setOnClickListener(v->{
            Intent intent=new Intent(SignUpPage.this , LoginPage.class);
            startActivity(intent);
        });
    }
}
