package com.example.assignmnentpart2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper mydb;
    EditText id, name, age, phone;
    Button saveBtn, deleteBtn, fetchBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mydb = new DatabaseHelper(this);
        name =findViewById(R.id.nameEditText);
        age=findViewById(R.id.ageEditText);
        phone= findViewById(R.id.phoneEditText);
        id= findViewById(R.id.idEditText);

        saveBtn=findViewById(R.id.save);
        fetchBtn=findViewById(R.id.fetch);
        deleteBtn=findViewById(R.id.deleteButton);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInserted = mydb.addItems(name.getText().toString(),age.getText().toString(),
                        phone.getText().toString());
                if (isInserted == true) {
                    Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Data not Inserted ", Toast.LENGTH_SHORT).show();
                }
            }
        });

        fetchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent= new Intent(getApplication(), FetchActivity.class);
                startActivity(intent);
            }
        });
    }
    public  void ShowMessage(String error, String s) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(error);
        builder.setCancelable(true);
        builder.setMessage(s);
        builder.show();
    }
}