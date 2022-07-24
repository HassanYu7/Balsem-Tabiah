package com.example.testloginforuserrole;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.testloginforuserrole.database.MyDatabaseHelper;
import com.example.testloginforuserrole.database.data.ReceptionistData;

public class DeleteReceptionist extends AppCompatActivity {

    EditText idPersonal;
    MyDatabaseHelper helper;
    ReceptionistData receptionistData;
    ImageView iconBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_receptionist);

        iconBack = findViewById(R.id.icon_backDeleteReceptionist);
        iconBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DeleteReceptionist.this,PageAdmin.class));
            }
        });

        helper = new MyDatabaseHelper(this);
        receptionistData = new ReceptionistData(helper);
        hideNav();
    }

    public void btn_delete_onclick_receptionist(View v){
        idPersonal = findViewById(R.id.edit_text_id_personal_del_receptionist);
        int id = Integer.parseInt(idPersonal.getText().toString());
        receptionistData.removeReceptionistById(id);
        Cursor cursor = receptionistData.readAllDataFromReceptionist();

        if (cursor.getCount() == -1)
            Toast.makeText(this,"Invalid",Toast.LENGTH_SHORT).show();
        else {
            Toast.makeText(this, "The receptionist has been successfully deleted", Toast.LENGTH_SHORT).show();

        }


    }

    private void hideNav(){
        this.getWindow().getDecorView()
                .setSystemUiVisibility(
                        View.SYSTEM_UI_FLAG_FULLSCREEN |
                                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                );
    }
}