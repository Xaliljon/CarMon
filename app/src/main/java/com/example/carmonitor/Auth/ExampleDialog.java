package com.example.carmonitor.Auth;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.carmonitor.R;

public class ExampleDialog extends AppCompatDialogFragment {

    private Button btnDone;
    private EditText editTextCod;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());


        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.phone_auth_dialog, null);
        builder.setView(view)
                .setTitle("Verify Cod");

        editTextCod = view.findViewById(R.id.editTextCode);
        btnDone = view.findViewById(R.id.verfy_code);

        return builder.create();


    }
}
