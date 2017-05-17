package com.example.franz_dpc.fhf_salarybreakup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class AddItemActivity extends Activity {


    private class OnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_additem);
        OnClickListener clickListener = new OnClickListener();
        Button btnSave = (Button) findViewById(R.id.btn_save);
        btnSave.setOnClickListener(clickListener);
    }

}