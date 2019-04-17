package co.example.armin.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class EnterHoursActivity extends AppCompatActivity {

    private static final int REQUEST_READ_CONTACTS = 0;
    private static final int REQUEST_SIGNUP = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_hours);

        Button mEnterButton = (Button) findViewById(R.id.enterHours);
        mEnterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EnterReportActivity.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
            }
        });
    }
}
