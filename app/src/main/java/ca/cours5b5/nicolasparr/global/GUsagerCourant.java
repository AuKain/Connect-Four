package ca.cours5b5.nicolasparr.global;

import com.google.firebase.auth.FirebaseAuth;

public class GUsagerCourant {

    public static boolean siConnecte() {
        return getId() != null;
    }

    public static String getId() {
        return FirebaseAuth.getInstance().getCurrentUser().getUid();
    }
}
