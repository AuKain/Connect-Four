package ca.cours5b5.nicolasparr.activites;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;

import javax.microedition.khronos.opengles.GL;

import ca.cours5b5.nicolasparr.donnees.EntrepotDeDonnees;
import ca.cours5b5.nicolasparr.global.GLog;

public abstract class Activite extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        GLog.appel(this);
        GLog.valeurs("état", savedInstanceState);

        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

    }

    protected abstract int getLayoutId();


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        GLog.appel(this);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onResume() {
        GLog.appel(this);
        super.onResume();
    }

    @Override
    protected void onPause() {
        GLog.appel(this);
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        GLog.appel(this);
        super.onDestroy();
    }

    protected File repertoireDonnees(){
        GLog.appel(EntrepotDeDonnees.class);

        return getDataDir();
    }

}
