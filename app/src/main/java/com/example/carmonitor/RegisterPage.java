package com.example.carmonitor;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.carmonitor.Auth.AuthActivity;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.DoubleBounce;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RegisterPage extends AppCompatActivity {
    EditText  editFullname, editPassword;
    Button btnNext;
    ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_page);

        editFullname = findViewById(R.id.edit_fullname);
        editPassword = findViewById(R.id.edit_password);
        btnNext = findViewById(R.id.btn_next);


        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                final ProgressDialog mDialog = new ProgressDialog(RegisterPage.this);
//                mDialog.setMessage("Please waiting...");
//                mDialog.show();

                mDialog = new ProgressDialog(RegisterPage.this);
                //Show dialog

                mDialog.show();
                //Set Content View

                mDialog.setContentView(R.layout.progress_dialog);
                //Set transparent Background
                mDialog.getWindow().setBackgroundDrawableResource(
                        android.R.color.transparent
                );


                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.child(editFullname.getText().toString()).exists()) {
                            mDialog.dismiss();
                            Intent intent = new Intent(RegisterPage.this, AuthActivity.class);
                            startActivity(intent);
                            finish();


                        } else {
                            mDialog.dismiss();
                            User user = new User(editFullname.getText().toString(), editPassword.getText().toString());
                            table_user.child(editFullname.getText().toString()).setValue(user);

                            finish();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });


    }
}
