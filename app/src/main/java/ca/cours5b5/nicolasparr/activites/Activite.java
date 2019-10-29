package ca.cours5b5.nicolasparr.activites;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import ca.cours5b5.nicolasparr.global.GLog;

public abstract class Activite extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        GLog.appel(this);

        GLog.valeurs("état, " + savedInstanceState);

        super.onCreate(savedInstanceState);

        int contentViewId = getLayoutId();

        setContentView(contentViewId);
    }

    @Override
    protected void onStart() {
        GLog.appel(this);
        super.onStart();
    }

    @Override
    protected void onResume() {
        GLog.appel(this);
        super.onResume();
    }

    @Override
    protected void onRestart() {
        GLog.appel(this);
        super.onRestart();
    }

    @Override
    protected void onPause() {
        GLog.appel(this);
        super.onPause();
    }

    @Override
    protected void onStop() {
        GLog.appel(this);
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        GLog.appel(this);
        super.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        GLog.appel(this);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        GLog.appel(this);
        super.onRestoreInstanceState(savedInstanceState);
    }

    protected abstract int getLayoutId();
}
