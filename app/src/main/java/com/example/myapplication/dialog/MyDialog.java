package com.example.myapplication.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MyDialog extends Dialog {
    private String dialogName;
    private EditText et_username;
    private EditText et_pwd;
    private Button btn_cancel;
    private Button btn_signin;

    public MyDialog (Context context,String dialogName) {
        super(context);
        this.dialogName = dialogName;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
