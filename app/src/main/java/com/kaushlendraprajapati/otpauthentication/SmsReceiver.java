package com.kaushlendraprajapati.otpauthentication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.widget.EditText;

public class SmsReceiver extends BroadcastReceiver {

    private  static EditText editText;
    public  void setEditText(EditText editText)
    {
        SmsReceiver.editText = editText;
    }
    @Override
    public void onReceive(Context context, Intent intent) {

        SmsMessage[] messages = Telephony.Sms.Intents.getMessagesFromIntent(intent);
        for (SmsMessage sms : messages)
        {
            String messageBody = sms.getMessageBody();
            editText.setText(messageBody);
        }
    }
}
