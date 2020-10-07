package com.example.dashboarduidesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

public class CustomNotificationActivity extends AppCompatActivity {

    public static final String CHANNEL_ID = "NotificationChannelForMe";
    public final int NOTIFICATION_ID = 1000;
    Button btnShow;
    Button btnShowSimple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_notification);

        btnShow = findViewById(R.id.btnShow);
        btnShowSimple = findViewById(R.id.btnShowSimple);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomNotification();
            }
        });
        btnShowSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleNotification();
            }
        });


    }

    public void SimpleNotification() {
        notificationChannel();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID);
        builder.setSmallIcon(R.drawable.ic_education);
        builder.setContentTitle("Simple Title");
        builder.setContentText("Simple Content");
        builder.setPriority(NotificationCompat.PRIORITY_HIGH);
        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
        managerCompat.notify(NOTIFICATION_ID, builder.build());
    }

    public void CustomNotification() {
        notificationChannel();
        RemoteViews remoteView = new RemoteViews(getPackageName(), R.layout.custome_notification);
        remoteView.setTextViewText(R.id.txtUserName, "Ali Hasan Alwan");
        remoteView.setTextViewText(R.id.txtEmail, "ali@gmail.com");
        remoteView.setTextViewText(R.id.txtPhone, "07800953399");
        remoteView.setTextViewText(R.id.txtContact1, "0123456789");
        remoteView.setTextViewText(R.id.txtContact2, "0321654789");
        remoteView.setTextViewText(R.id.txtContact3, "6598741230");
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID);
        builder.setContentTitle("Notification Title");
        builder.setContentText("Pull down to see!");
        builder.setSmallIcon(R.drawable.ic_fitness);
        builder.setPriority(NotificationCompat.PRIORITY_HIGH);
        builder.setStyle(new NotificationCompat.DecoratedCustomViewStyle());
        builder.setCustomBigContentView(remoteView);
        builder.setContentIntent(PendingIntent.getActivity(this, 0, new Intent(this, CustomNotificationActivity.class), 0));

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(123, builder.build());
    }

    public void notificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence charSequence = "Notification";
            String NotificationDesc = "Your Notification Description ";
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, charSequence, NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel.setDescription(NotificationDesc);
            NotificationManager notificationManager = (NotificationManager) getSystemService((NOTIFICATION_SERVICE));
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }
}