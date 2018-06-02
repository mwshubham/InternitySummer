package in.internity.internitysummer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, FragmentTwo.FragmentTwoListener {
    private static final String TAG = "MainActivity";
    public static final int REQUEST_CODE_PICK_TEXT = 101;

    private Button mSampleBtn;
    public TextView mSampleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        init();
        initControl();

    }

    private void init() {
        getSupportFragmentManager().beginTransaction().add(R.id.fl_one, FragmentOne.newInstance("one")).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.fl_two, new FragmentTwo()).commit();


    }

    private void initControl() {
    }

    private void initView() {
        mSampleText = findViewById(R.id.tv_label);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.btn_sample:
//                Intent intent = new Intent(this, NextActivity.class);
//                startActivityForResult(intent, REQUEST_CODE_PICK_TEXT);
//                break;
//        }
    }

    @Override
    public void onBtnPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(FragmentOne.TAG);
        ((FragmentOne) fragment).fragmentTwoBtnPressed();
        mSampleText.setText("Btn CLicked");
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        switch (requestCode) {
//            case REQUEST_CODE_PICK_TEXT:
//                switch (resultCode) {
//                    case Activity.RESULT_OK:
//                        Toast.makeText(this, "SUCESS: " + data.getStringExtra("name"), Toast.LENGTH_SHORT).show();
//                        break;
//
//                    case Activity.RESULT_CANCELED:
//                        Toast.makeText(this, "CANCELLED", Toast.LENGTH_SHORT).show();
//                        break;
//                }
//                break;
//        }
//    }
}
