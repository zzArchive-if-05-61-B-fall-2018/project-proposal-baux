package co.example.armin.myapplication.activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import co.example.armin.myapplication.R;

public class EnterReportActivity extends AppCompatActivity {
    private static final int REQUEST_READ_CONTACTS = 0;
    private static final int REQUEST_SIGNUP = 2;

    private EditText report;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_report);

        report = findViewById(R.id.report);

        Button mFinishButton = (Button) findViewById(R.id.finishButton);



    }
}
