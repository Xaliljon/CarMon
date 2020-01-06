package com.example.carmonitor.Auth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carmonitor.MainScreen;
import com.example.carmonitor.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class AuthActivity extends AppCompatActivity {
    FirebaseAuth mAuth;
    EditText editTextPhone, editTextCode;
    TextView cnttext;


    String codeSent;
    ProgressDialog mmDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        mAuth = FirebaseAuth.getInstance();

        editTextPhone = findViewById(R.id.edittext_phone);
        cnttext = findViewById(R.id.connecting_text);
        editTextCode = findViewById(R.id.editTextCode);


        findViewById(R.id.getVerificationCode).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


//                getWindow().setFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM,WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);


                sendVerificationCode();
                editTextCode.setVisibility(View.VISIBLE);
                findViewById(R.id.sigin).setVisibility(View.VISIBLE);
                editTextPhone.setVisibility(View.GONE);
                findViewById(R.id.getVerificationCode).setVisibility(View.GONE);


            }
        });

        findViewById(R.id.sigin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mmDialog = new ProgressDialog(AuthActivity.this);
                //Show dialog

                mmDialog.show();
                //Set Content View

                mmDialog.setContentView(R.layout.progress_dialog);
                //Set transparent Background
                mmDialog.getWindow().setBackgroundDrawableResource(
                        android.R.color.transparent
                );
                verifySignInCode();
            }
        });

        findViewById(R.id.btndone).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AuthActivity.this, MainScreen.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void verifySignInCode() {
        String code = editTextCode.getText().toString();
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(codeSent, code);

        signInWithPhoneAuthCredential(credential);

    }


    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            mmDialog.dismiss();
                            Toast.makeText(getApplicationContext(),
                                    "Login Succesfull", Toast.LENGTH_LONG).show();
                            findViewById(R.id.btndone).setVisibility(View.VISIBLE);
                            findViewById(R.id.attantion).setVisibility(View.VISIBLE);
                            editTextCode.setVisibility(View.GONE);
                            findViewById(R.id.sigin).setVisibility(View.GONE);
                            editTextPhone.setVisibility(View.GONE);
                            findViewById(R.id.getVerificationCode).setVisibility(View.GONE);


                        } else {
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                Toast.makeText(getApplicationContext(),
                                        "Incorrect Verification Code", Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                });
    }


    private void sendVerificationCode() {

        String phone = editTextPhone.getText().toString();

        if (phone.isEmpty()) {
            editTextPhone.setError("Phone number is required");
            editTextPhone.requestFocus();
            return;
        }

        if (phone.length() < 12) {
            editTextPhone.setError("Please enter a valid phone");
            editTextPhone.requestFocus();
            return;
        }

        PhoneAuthProvider.getInstance().verifyPhoneNumber("+" +
                        phone,        // Phone number to verify
                60,                 // Timeout duration
                TimeUnit.SECONDS,   // Unit of timeout
                this,               // Activity (for callback binding)
                mCallbacks);        // OnVerificationStateChangedCallbacks


    }


    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

        }

        @Override
        public void onVerificationFailed(@NonNull FirebaseException e) {

        }

        @Override
        public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);

            codeSent = s;

        }
    };


    private void dialogView() {
        ExampleDialog exampleDialog = new ExampleDialog();
        exampleDialog.show(getSupportFragmentManager(), "example dialog");
    }
}
