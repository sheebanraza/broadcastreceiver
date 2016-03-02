package com.example.sheebanraza.broadcastsender;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void convert(View view){
        if(view.getId() == R.id.conversion) {
            int amount = Integer.parseInt(getIntent().getExtras().getString("amount"));
            String currencyType = getIntent().getExtras().getString("type");

            switch (currencyType) {
                case "Indian Rupee":
                    Intent intent = new Intent();
                    intent.setAction("sheebanraza.custom.intent.RECIEVE");
                    intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
                    intent.putExtra("type", currencyType);
                    intent.putExtra("amount", Integer.toString(amount * 68));
                    sendBroadcast(intent);

                    break;

                case "British Pound":

                    Intent intentForPound = new Intent();
                    intentForPound.setAction("sheebanraza.custom.intent.RECIEVE");
                    intentForPound.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
                    intentForPound.putExtra("type", currencyType);
                    intentForPound.putExtra("amount", Integer.toString(amount * 2));
                    sendBroadcast(intentForPound);
                    break;

                case "Euro":

                    Intent intentForEuro = new Intent();
                    intentForEuro.setAction("sheebanraza.custom.intent.RECIEVE");
                    intentForEuro.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
                    intentForEuro.putExtra("ConvertedType", currencyType);
                    intentForEuro.putExtra("convertedAmount", Integer.toString(amount * 3));
                    sendBroadcast(intentForEuro);
                    break;
            }
        }
    }

    public void onPress(View view){
        int amount = Integer.parseInt(getIntent().getExtras().getString("amount"));
        String currencyType = getIntent().getExtras().getString("type");
        TextView textViewAmount = (TextView) findViewById(R.id.amountRecieved);
        TextView textViewType = (TextView) findViewById(R.id.coversionTo);
        textViewAmount.setText(Integer.toString(amount));
        textViewType.setText(currencyType);
    }



    @Override
    protected void onResume() {
        super.onResume();
    }


}
