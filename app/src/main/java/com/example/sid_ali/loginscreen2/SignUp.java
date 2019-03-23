package com.example.sid_ali.loginscreen2;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.sid_ali.loginscreen2.Database.COLUMME_2;
import static com.example.sid_ali.loginscreen2.Database.COLUMME_3;
import static com.example.sid_ali.loginscreen2.Database.COLUMME_4;
import static com.example.sid_ali.loginscreen2.Database.TABLE_NAME;

public class SignUp extends AppCompatActivity {
    Database halper = new Database(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);
    }

    public void OnsignUp(View view) {

       EditText ETname = findViewById(R.id.name);
       EditText ETemail = findViewById(R.id.email);
       EditText ETpass1 = findViewById(R.id.pass1);
       EditText Etpass2 = findViewById(R.id.pass2);




        String name=ETname.getText().toString();
        String email=ETemail.getText().toString();
        String password=ETpass1.getText().toString();
        String password1=ETpass1.getText().toString();


        if (!password.equals(password1)){
           Toast.makeText(this,"Password don't match!",Toast.LENGTH_SHORT).show();
       }
       else{
           halper.db=halper.getWritableDatabase();
           ContentValues values = new ContentValues();
           values.put(COLUMME_2,name);
           values.put(COLUMME_3,email);
           values.put(COLUMME_4,password);

           halper.db.insert(TABLE_NAME,null,values);

           Toast.makeText(this,"User added succefely",Toast.LENGTH_SHORT).show();

           Intent i = new Intent(this,HomeActivity.class);
           startActivity(i);
       }

    }
}
