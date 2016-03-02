package com.example.sheebanraza.broadcastsender;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Sheeban Raza on 28-Feb-16.
 */
public class BroadCastValues extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "data", Toast.LENGTH_LONG).show();
        String amount = intent.getStringExtra("amount");
        String type = intent.getStringExtra("msg");

        Intent intentForSending = new Intent(context,MainActivity.class);
        intentForSending.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intentForSending.putExtra("amount",amount);
        intentForSending.putExtra("type",type);
        context.startActivity(intentForSending);
    }
}
