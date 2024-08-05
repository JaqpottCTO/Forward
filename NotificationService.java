package com.blerdU.rootworkapp;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;

import java.util.HashMap;
import java.util.Map;

public class NotificationService {
    private static final String CHANNEL_ID = "rootwork_notifications";
    private Context context;
    private NotificationManager notificationManager;
    private Map<String, PendingIntent> scheduledReminders;

    public NotificationService(Context context) {
        this.context = context;
        this.notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        this.scheduledReminders = new HashMap<>();
        createNotificationChannel();
    }

    // Send an in-app or push notification
    public void sendNotification(String title, String message, Intent intent) {
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        Notification notification = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.notification_icon)
                .setContentTitle(title)
                .setContentText(message)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .build();
        notificationManager.notify((int) System.currentTimeMillis(), notification);
    }

    // Schedule a reminder notification
    public void scheduleReminder(String reminderId, long triggerAtMillis, String title, String message, Intent intent) {
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        // Add your scheduling logic here (e.g., using AlarmManager)
        // This is a placeholder for the actual scheduling logic
        scheduledReminders.put(reminderId, pendingIntent);

        // Implement AlarmManager or JobScheduler logic here for actual scheduling
        // Example: AlarmManager, WorkManager, etc.
    }

    // Customize alert settings
    public void customizeAlerts(String alertType, boolean enable) {
        // Implement customization logic based on alertType
        // This may include enabling/disabling specific types of notifications
        // Example: Enable/disable reminders, updates, new objectives notifications, etc.
    }

    // Send notification specific to Door objectives
    public void sendDoorObjectiveNotification(String doorId, String objectiveId, String title, String message) {
        // Create an intent that opens the objective details when the notification is clicked
        Intent intent = new Intent(context, ObjectiveDetailsActivity.class);
        intent.putExtra("doorId", doorId);
        intent.putExtra("objectiveId", objectiveId);
        sendNotification(title, message, intent);
    }

    // Send notification for expert feedback received
    public void sendExpertFeedbackNotification(String feedbackId, String title, String message) {
        // Create an intent that opens the feedback details when the notification is clicked
        Intent intent = new Intent(context, FeedbackDetailsActivity.class);
        intent.putExtra("feedbackId", feedbackId);
        sendNotification(title, message, intent);
    }

    // Create a notification channel for Android O and above
    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Rootwork Notifications";
            String description = "Channel for Rootwork app notifications";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
