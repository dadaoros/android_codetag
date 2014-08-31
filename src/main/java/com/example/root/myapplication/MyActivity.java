package com.example.root.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import db.ArchivoDatos;


public class MyActivity extends Activity {
    private ArchivoDatos db;
    private TextView username, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        db= new ArchivoDatos(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void acceder(View view){
        username = (EditText)findViewById(R.id.emailField);
        password = (EditText)findViewById(R.id.passField);
        if(db.validarUsuario((String)username.getText(),(String)password.getText())) {
            Intent i = new Intent(this, home.class);
            startActivity(i);
        }else
            Toast.makeText(this,"password incorrecto",Toast.LENGTH_SHORT).show();
    }
}
