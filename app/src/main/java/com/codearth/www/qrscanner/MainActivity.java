package com.codearth.www.qrscanner;
import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.google.zxing.integration.android.IntentIntegrator;
        import com.google.zxing.integration.android.IntentResult;

        import org.json.JSONException;
        import org.json.JSONObject;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button sc;
    IntentIntegrator qrScan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sc = findViewById(R.id.buttonScan);
        qrScan = new IntentIntegrator(this);
        sc.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int reqCode, int resCode, Intent data) {
        IntentResult r = IntentIntegrator.parseActivityResult(reqCode, resCode, data);
        if (r != null) {
            if (r.getContents() == null) {
                Toast.makeText(this, "Result Not Found", Toast.LENGTH_LONG).show();
            }
            else {
                try {

                    JSONObject obj = new JSONObject(r.getContents());
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(this, r.getContents(), Toast.LENGTH_LONG).show();
                }
            }
        }
        else {
            super.onActivityResult(reqCode, resCode, data);
        }
    }
    @Override
    public void onClick(View view) {
        qrScan.initiateScan();
    }
}

