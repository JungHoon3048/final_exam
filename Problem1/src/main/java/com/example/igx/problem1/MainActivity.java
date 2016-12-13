package com.example.igx.problem1;

import android.content.Context;
import android.content.Intent;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    double longitude;
    double latitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MyLocationListener ml = new MyLocationListener();
        final LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        Button btn_getLocation = (Button) findViewById(R.id.btn_getLocation);
        Button btn_getSensors = (Button) findViewById(R.id.btn_getSensors);
        Button btn_sendMessage = (Button) findViewById(R.id.btn_sendMessage);

        final TextView text_selectedData = (TextView) findViewById(R.id.text_selectedData);
        final TextView text_selectedType = (TextView) findViewById(R.id.text_selectedType);
        final EditText edit_phoneNumber = (EditText) findViewById(R.id.edit_phoneNumber);

        btn_getLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10000, 0, ml);
                    lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 10000, 0 , ml);
                }
                catch (SecurityException se){}

                Intent intent = new Intent(getApplicationContext(), Map.class);
                intent.putExtra("latitude", latitude);
                intent.putExtra("longitude", longitude);
                startActivity(intent);
            }
        });

        btn_getSensors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Pedometer.class);
            }
        });

        btn_sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pNumber = edit_phoneNumber.getText().toString();
                Intent intent = new Intent(Intent.ACTION_SEND, Uri.parse("tel:"+pNumber));
                startActivity(intent);
            }
        });
    }
    class MyLocationListener implements LocationListener {


        public void onLocationChanged(android.location.Location loc) {

            longitude = loc.getLongitude();
            latitude = loc.getLatitude();
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
        }

        @Override
        public void onProviderEnabled(String provider) {
        }

        @Override
        public void onProviderDisabled(String provider) {
        }

    }
}


