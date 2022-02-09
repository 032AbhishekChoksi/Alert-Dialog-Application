package com.abhishekchoksi.alertdialogapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    ArrayList selectedItems;
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

    public void singleChoiceDialog(View view){
        String [] list = getResources().getStringArray(R.array.Course);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Choose Course");
        alertDialogBuilder.setItems(R.array.Course, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Selected Course is : " + list[i], Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public void openMultipleChoiceDialog(View view){
        selectedItems = new ArrayList();
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Multiple Select Course");
        alertDialogBuilder.setMultiChoiceItems(R.array.Course, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean isChecked) {
                if(isChecked){
                    selectedItems.add(i);
                } else if(selectedItems.contains(i)){
                    selectedItems.remove(i);
                }
            }
        });

        alertDialogBuilder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, selectedItems.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        alertDialogBuilder.setNegativeButton("Cencel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public void openCustomDialog(View view){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater factory = LayoutInflater.from(this);
        View myCustView = factory.inflate(R.layout.fragment_custom_dialog,null);
        alertDialogBuilder.setView(myCustView);

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

        myCustView.findViewById(R.id.btn_fragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText ed = myCustView.findViewById(R.id.edit_text);
                Toast.makeText(getApplicationContext(),ed.getText().toString(),Toast.LENGTH_LONG).show();
                alertDialog.dismiss();
            }
        });
    }
}