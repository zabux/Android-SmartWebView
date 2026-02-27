package mgks.os.swv;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (SWVContext.ASWP_BLOCK_SCREENSHOTS) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_SECURE);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void setWindowSecure(boolean secure) {
        runOnUiThread(() -> {
            if (secure) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_SECURE);
            } else if (!SWVContext.ASWP_BLOCK_SCREENSHOTS) {
                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_SECURE);
            }
        });
    }
}
