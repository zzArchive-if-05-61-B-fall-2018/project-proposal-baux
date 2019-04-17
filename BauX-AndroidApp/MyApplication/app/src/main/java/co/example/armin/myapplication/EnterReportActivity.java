package co.example.armin.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class EnterReportActivity extends AppCompatActivity {
    private static final int REQUEST_READ_CONTACTS = 0;
    private static final int REQUEST_SIGNUP = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_report);
    }
}
