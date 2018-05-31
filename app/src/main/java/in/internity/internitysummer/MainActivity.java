package in.internity.internitysummer;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    public static final int REQUEST_CODE_PICK_TEXT = 101;

    private Button mSampleBtn;
    private TextView mSampleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");
        initView();
        initControl();

    }

    private void initControl() {
        mSampleBtn.setOnClickListener(this);
    }

    private void initView() {
        mSampleBtn = findViewById(R.id.btn_sample);
        mSampleText = findViewById(R.id.tv_sample);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_sample:
                Intent intent = new Intent(this, NextActivity.class);
                startActivityForResult(intent, REQUEST_CODE_PICK_TEXT);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_CODE_PICK_TEXT:
                switch (resultCode) {
                    case Activity.RESULT_OK:
                        Toast.makeText(this, "SUCESS: " + data.getStringExtra("name"), Toast.LENGTH_SHORT).show();
                        break;

                    case Activity.RESULT_CANCELED:
                        Toast.makeText(this, "CANCELLED", Toast.LENGTH_SHORT).show();
                        break;
                }
                break;
        }
    }
}
