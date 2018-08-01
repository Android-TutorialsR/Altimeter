package com.vishal.altimeter;

import android.Manifest;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.vishal.altimeter.walkie.Conecctions;

public class MainActivity extends AppCompatActivity {

    Button btn_do_it,btn_pending_notification,btn_send,btn_am_network_location,
            btn_radio;
    EditText et_time;
    MyReceiver myReceiver;
    public static Location loc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_do_it = findViewById(R.id.btn_do_it);
        btn_pending_notification = findViewById(R.id.btn_pending_notification);
        et_time = findViewById(R.id.et_time);
        btn_send = findViewById(R.id.btn_send);
        btn_am_network_location = findViewById(R.id.btn_am_network_location);
        btn_radio = findViewById(R.id.btn_radio);

        btn_do_it.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationCompat.Builder mbuilder = new NotificationCompat.Builder(getApplicationContext())
                        .setSmallIcon(R.mipmap.ic_launcher).setContentTitle("My Text").setContentText("Hii how are you");
                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

                notificationManager.notify(001,mbuilder.build());
            }
        });

        btn_pending_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationCompat.Builder mBuilder =
                        new NotificationCompat.Builder(getApplicationContext());

                //Create the intent that’ll fire when the user taps the notification//

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.androidauthority.com/"));
                PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, 0);
//                if we give here some requestcode to pending intent then we can work in onactivityresult

                mBuilder.setContentIntent(pendingIntent);

                mBuilder.setSmallIcon(R.mipmap.ic_launcher);
                mBuilder.setContentTitle("My notification");
                mBuilder.setContentText("Hello World!");

                NotificationManager mNotificationManager =

                        (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

                mNotificationManager.notify(001, mBuilder.build());
            }
        });

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                myReceiver = new MyReceiver();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(MyService.MY_ACTION);
                registerReceiver(myReceiver, intentFilter);

                //Start our own service
                Intent intent = new Intent(getApplicationContext(),
                        com.vishal.altimeter.MyService.class);
                intent.putExtra("INIT_DATA", et_time.getText().toString());
                startService(intent);

            }
        });

        btn_am_network_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyLocation.LocationResult locationResult = new MyLocation.LocationResult(){
                    @Override
                    public void gotLocation(final Location location){
                        loc=location;
//                        System.out.println("Latitude: "+loc.getLatitude());
//                        System.out.println("Longitude: "+loc.getLongitude());
                        Toast.makeText(MainActivity.this, "lat= "+ String.valueOf(loc.getLatitude())+"long= "+String.valueOf(loc.getLongitude()), Toast.LENGTH_SHORT).show();
                    }
                };

                MyLocation myLocation = new MyLocation();
                myLocation.getLocation(MainActivity.this, locationResult);
            }
        });

        double distance = getDistanceFromLatLonInKm(28.612712,77.377737,28.623986,77.361349);
        Toast.makeText(this, String.valueOf(distance) , Toast.LENGTH_SHORT).show();


        btn_radio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Conecctions.class));
            }
        });

    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub

        //Register BroadcastReceiver
        //to receive event from our service
        super.onStart();
    }

    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
//        unregisterReceiver(myReceiver);
        super.onStop();
    }

    private class MyReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context arg0, Intent arg1) {
            // TODO Auto-generated method stub
//            int datapassed = arg1.getIntExtra("DATAPASSED", 0);
            String orgData = arg1.getStringExtra("DATA_BACK");

            Toast.makeText(getApplicationContext(),
                    "Triggered by Service!\n"+"\n"
                            + "original Data: " + orgData,
                    Toast.LENGTH_LONG).show();

            NotificationCompat.Builder mbuilder = new NotificationCompat.Builder(getApplicationContext())
                    .setSmallIcon(R.mipmap.ic_launcher).setContentTitle("My Text").setContentText("Hii how are you");
            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

            notificationManager.notify(001,mbuilder.build());

        }
    }

    public double getDistanceFromLatLonInKm(double lat1, double lon1, double lat2, double lon2) {
        double R = 6371;
        double dLat = deg2rad(lat2-lat1);
        double dLon = deg2rad(lon2-lon1);
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                        Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) *
                                Math.sin(dLon/2) * Math.sin(dLon/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        double d = R * c;
        return d;
    }

    public double deg2rad(double deg){
        return deg *(Math.PI/180);
    }
}
