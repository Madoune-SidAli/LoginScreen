

package com.example.sid_ali.loginscreen2;

import android.content.Intent;
import android.database.Cursor;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    Database halper = new Database(this);

    RelativeLayout relativ1,relativ2;
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            relativ1.setVisibility(View.VISIBLE);
            relativ2.setVisibility(View.VISIBLE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        relativ1 = (RelativeLayout)  findViewById(R.id.relativ1);
        relativ2 = (RelativeLayout)  findViewById(R.id.relativ2);

        handler.postDelayed(runnable,2000 );
    }





    public void OnLogin(View view) {

        EditText ETname = findViewById(R.id.uname);
        String name= ETname.getText().toString();
        EditText ETpassword = findViewById(R.id.upassword);
        String pass= ETpassword.getText().toString();

        String password = halper.searchpass(name);

        if (pass.equals(password)){
            Intent i = new Intent(this,HomeActivity.class);
            startActivity(i);

        }
        else{
            Toast.makeText(this,"Password or UserName don't match",Toast.LENGTH_LONG).show();
        }

    }

    public void OnSignUp(View view) {
        Intent i = new Intent(this,SignUp.class);
        startActivity(i);
    }
}
