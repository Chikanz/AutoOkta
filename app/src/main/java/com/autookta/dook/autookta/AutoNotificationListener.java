package com.autookta.dook.autookta;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.IBinder;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.app.Notification.Action;
import android.util.Log;

public class AutoNotificationListener extends NotificationListenerService
{
    @Override
    public IBinder onBind(Intent intent) {
        return super.onBind(intent);
    }

    @Override
    public void onNotificationPosted(StatusBarNotification sbn)
    {
        if(!sbn.getPackageName().equals("com.okta.android.auth")) return; //only want dat okta

        Action[] buttons = sbn.getNotification().actions;
        for(int i = 0; i < buttons.length ; i++)
        {
            try {
                buttons[0].actionIntent.send();
            } catch (PendingIntent.CanceledException e) {
                e.printStackTrace();
            }
        }
    }

}
