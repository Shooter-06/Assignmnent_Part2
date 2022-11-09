
package com.example.assignmnentpart2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FetchActivity extends AppCompatActivity {

    DatabaseHelper db;
    EditText idTxt, nameTxt, ageTxt, phoneTxt;
    Button delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch);

//        idTxt =findViewById(R.id.idEditText);
        nameTxt= findViewById(R.id.nameEditText);
        ageTxt= findViewById(R.id.ageEditText);
        phoneTxt =findViewById(R.id.phoneEditText);

        delete=findViewById(R.id.deleteButton);

        db= new DatabaseHelper(this);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer isDeleted = db.deleteItems(nameTxt.getText().toString());
                if(isDeleted >0){
                    Toast.makeText(getApplicationContext(), "Item deleted", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Item not deleted", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}