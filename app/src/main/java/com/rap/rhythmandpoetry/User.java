package com.rap.rhythmandpoetry;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by rysha on 11/27/2017.
 */

public class User {
    public String username;
    public String email;
    public String bio;

    private DatabaseReference mDatabase;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String username, String email, String bio) {
        this.mDatabase = FirebaseDatabase.getInstance().getReference();
        this.username = username;
        this.email = email;
        this.bio = bio;
    }

    private void writeNewUser(String userId, String name, String email, String bio) {
        User user = new User(name, email, bio);
        mDatabase.child("users").child(userId).setValue(user);
    }
}
