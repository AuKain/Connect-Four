package ca.cours5b5.nicolasparr.vues.controles;

import android.content.Context;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatButton;

import ca.cours5b5.nicolasparr.global.GLog;

public class VCase extends AppCompatButton {
    public VCase(Context context) {
        super(context);
    }

    public VCase(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VCase(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public VCase(Context context, int noColonne, int noCase) {
        super(context);
        GLog.appel(this);
        this.setText(noColonne + "," + noCase);
    }
}
