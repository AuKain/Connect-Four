package ca.cours5b5.nicolasparr.activites;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import ca.cours5b5.nicolasparr.global.GLog;

public abstract class Activite extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        GLog.valeurs(this);

        GLog.valeurs("état, " + savedInstanceState);

        super.onCreate(savedInstanceState);

        int contentViewId = getLayoutId();

        setContentView(contentViewId);
    }

    @Override
    protected void onStart() {
        GLog.valeurs(this);
        super.onStart();
    }

    @Override
    protected void onResume() {
        GLog.valeurs(this);
        super.onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        GLog.valeurs(this);
    }

    @Override
    protected void onPause() {
        GLog.valeurs(this);
        super.onPause();
    }

    @Override
    protected void onStop() {
        GLog.valeurs(this);
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        GLog.valeurs(this);
        super.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        GLog.valeurs(this);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        GLog.valeurs(this);
        super.onRestoreInstanceState(savedInstanceState);
    }

    protected abstract int getLayoutId();
}
