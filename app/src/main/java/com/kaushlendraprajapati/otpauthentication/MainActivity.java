package com.kaushlendraprajapati.otpauthentication;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
public class MainActivity extends AppCompatActivity {

    EditText et_otpnumber,et_phone;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestsmspermission();
        button=findViewById(R.id.getotpbutton);
        et_phone=findViewById(R.id.phoneNumberEditText);
        et_otpnumber=findViewById(R.id.verificationCodeEditText);
        new SmsReceiver().setEditText(et_otpnumber);
    }

    private void requestsmspermission() {

        String permission = Manifest.permission.RECEIVE_SMS;

        int grant = ContextCompat.checkSelfPermission(this,permission);
        if (grant != PackageManager.PERMISSION_GRANTED)
        {
            String[] permission_list = new String[1];
            permission_list[0] = permission;
            ActivityCompat.requestPermissions(this,permission_list,1);
        }
    }
}