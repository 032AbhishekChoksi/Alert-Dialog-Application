package com.abhishekchoksi.alertdialogapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openSimpleDialog(View view){
        AlertDialog.Builder alertDialogbuilder = new AlertDialog.Builder(this);
        alertDialogbuilder.setTitle("Save");
        alertDialogbuilder.setMessage("Do you want to save changes to Alert Box?");
        alertDialogbuilder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"Save this filed Successfully.",Toast.LENGTH_LONG).show();
            }
        });
        alertDialogbuilder.setNegativeButton("Don't Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Do Not Save this file\nPlease Try Again!", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertDialog = alertDialogbuilder.create();
        alertDialog.show();
    }
}