package co.example.armin.myapplication.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import co.example.armin.myapplication.R;

public class EnterHoursActivity extends AppCompatActivity {

    private static final int REQUEST_SIGNUP = 2;

    //Foreman-Name
    private AutoCompleteTextView nameForeman;

    //Worker-Names
    private AutoCompleteTextView nameWorker1;
    private AutoCompleteTextView nameWorker2;
    private AutoCompleteTextView nameWorker3;
    private AutoCompleteTextView nameWorker4;

    //Enter-Hours Foreman
    private AutoCompleteTextView ehForeman;

    //Enter-Hours Worker
    private AutoCompleteTextView ehWorker1;
    private AutoCompleteTextView ehWorker2;
    private AutoCompleteTextView ehWorker3;
    private AutoCompleteTextView ehWorker4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_hours);

        nameForeman = findViewById(R.id.foreman);
        nameWorker1 = findViewById(R.id.worker1);
        nameWorker2 = findViewById(R.id.worker2);
        nameWorker3 = findViewById(R.id.worker3);
        nameWorker4 = findViewById(R.id.worker4);

        ehForeman = findViewById(R.id.ehForeman);
        ehWorker1 = findViewById(R.id.worker1);
        ehWorker2 = findViewById(R.id.worker2);
        ehWorker3 = findViewById(R.id.worker3);
        ehWorker4 = findViewById(R.id.worker4);

        Button mEnterButton = (Button) findViewById(R.id.enterHoursButton);

        mEnterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EnterReportActivity.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
            }
        });
    }
}
