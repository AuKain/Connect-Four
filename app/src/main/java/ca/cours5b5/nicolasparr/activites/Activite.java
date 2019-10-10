package ca.cours5b5.nicolasparr.activites;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import ca.cours5b5.nicolasparr.global.GLog;

public abstract class Activite extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        int contentViewId = getLayoutId();

        setContentView(contentViewId);

        GLog.valeurs(this);
        GLog.valeurs("état, " + savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        GLog.valeurs(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        GLog.valeurs(this);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        GLog.valeurs(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        GLog.valeurs(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        GLog.valeurs(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        GLog.valeurs(this);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        GLog.valeurs(this);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        GLog.valeurs(this);
    }

    protected abstract int getLayoutId();
}
