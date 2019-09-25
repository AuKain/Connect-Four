package ca.cours5b5.nicolasparr.vues.controles;

import android.content.Context;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatButton;

import ca.cours5b5.nicolasparr.global.GLog;

public class VEntete extends AppCompatButton {
    public VEntete(Context context) {
        super(context);
    }

    public VEntete(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VEntete(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public VEntete(Context context, int noColonne) {

        super(context);
        GLog.appel(this);
        this.setText(noColonne + "\n\u2193");
    }
}
