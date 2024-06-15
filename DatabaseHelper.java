package com.blerdU.rootworkapp;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.SetOptions;
import com.firebase.geofire.GeoFire;
import com.firebase.geofire.GeoLocation;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class DatabaseHelper {
    private FirebaseFirestore firestore;
    private CollectionReference usersCollection;
    private CollectionReference appDataCollection;
    private GeoFire geoFire;

    public DatabaseHelper() {
        firestore = FirebaseFirestore.getInstance();
        usersCollection = firestore.collection("users");
        appDataCollection = firestore.collection("appData");
        DatabaseReference geoFireRef = FirebaseDatabase.getInstance().getReference("geofire");
        geoFire = new GeoFire(geoFireRef);
    }

    // Open the database (Initialization is done in the constructor)
    public void openDatabase() {
        // Initialization logic is already handled in the constructor
    }

    // Query data from a specific collection
    public void queryData(String collectionName, String documentId, final DataCallback callback) {
        firestore.collection(collectionName).document(documentId).get()
            .addOnSuccessListener(documentSnapshot -> {
                if (documentSnapshot.exists()) {
                    callback.onSuccess(documentSnapshot.getData());
                } else {
                    callback.onFailure("Document does not exist");
                }
            })
            .addOnFailureListener(e -> callback.onFailure(e.getMessage()));
    }

    // Update or set data in a specific collection
    public void updateDatabase(String collectionName, String documentId, Map<String, Object> data) {
        firestore.collection(collectionName).document(documentId).set(data, SetOptions.merge())
            .addOnSuccessListener(aVoid -> {
                // Handle success
            })
            .addOnFailureListener(e -> {
                // Handle failure
            });
    }

    // Add a geolocation entry
    public void addGeoLocation(String key, double latitude, double longitude) {
        geoFire.setLocation(key, new GeoLocation(latitude, longitude), (key1, error) -> {
            if (error != null) {
                // Handle error
            } else {
                // Handle success
            }
        });
    }

    // Query geolocation entries
    public void queryGeoLocation(double latitude, double longitude, double radius, final GeoQueryCallback callback) {
        geoFire.queryAtLocation(new GeoLocation(latitude, longitude), radius)
            .addGeoQueryEventListener(new GeoQueryEventListener() {
                @Override
                public void onKeyEntered(String key, GeoLocation location) {
                    callback.onKeyEntered(key, location);
                }

                @Override
                public void onKeyExited(String key) {
                    callback.onKeyExited(key);
                }

                @Override
                public void onKeyMoved(String key, GeoLocation location) {
                    callback.onKeyMoved(key, location);
                }

                @Override
                public void onGeoQueryReady() {
                    callback.onGeoQueryReady();
                }

                @Override
                public void onGeoQueryError(DatabaseError error) {
                    callback.onGeoQueryError(error);
                }
            });
    }

    // Callback interface for data operations
    public interface DataCallback {
        void onSuccess(Map<String, Object> data);
        void onFailure(String error);
    }

    // Callback interface for geolocation queries
    public interface GeoQueryCallback {
        void onKeyEntered(String key, GeoLocation location);
        void onKeyExited(String key);
        void onKeyMoved(String key, GeoLocation location);
        void onGeoQueryReady();
        void onGeoQueryError(DatabaseError error);
    }
}
