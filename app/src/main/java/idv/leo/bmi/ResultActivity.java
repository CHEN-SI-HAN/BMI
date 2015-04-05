package idv.leo.bmi;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 *
 */
public class ResultActivity extends ActionBarActivity {
    private TextView tvHeight , tvWeight , tvBMI;
    private Button btnBack;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        findViews();
        showResult();
    }
    public void findViews(){
        tvHeight = (TextView)findViewById(R.id.tvHeight);
        tvWeight = (TextView)findViewById(R.id.tvWeight);
        tvBMI = (TextView)findViewById(R.id.tvBMI);
        btnBack =(Button)findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ResultActivity.this.finish();
            }
        });

    }
    public void showResult(){
        Bundle bundle = this.getIntent().getExtras();
        String height = bundle.getString("height");
        String weight = bundle.getString("weight");
        double BMI = bundle.getDouble("BMI");

        tvHeight.setText("身高 (cm)" + height);
        tvWeight.setText("體重 (kg)： " + weight);
        tvBMI.setText("計算 BMI 值： " + BMI);

    }
}
