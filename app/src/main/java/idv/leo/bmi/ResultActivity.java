package idv.leo.bmi;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

/**
 *
 */
public class ResultActivity extends ActionBarActivity {
    private TextView tvHeight , tvWeight , tvBMI, textResult , textSuggest;
    private Button btnBack;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //new Activity 要先在onCreate方法內 setContentView
        setContentView(R.layout.result);
        findViews();
        showResult();
    }
    public void findViews(){
        tvHeight = (TextView)findViewById(R.id.tvHeight);
        tvWeight = (TextView)findViewById(R.id.tvWeight);
        tvBMI = (TextView)findViewById(R.id.tvBMI);
        textResult=(TextView)findViewById(R.id.textResult);
        textSuggest=(TextView)findViewById(R.id.textSuggest);
        btnBack =(Button)findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //返回
                ResultActivity.this.finish();
            }
        });

    }
    public void showResult(){
        DecimalFormat nf = new DecimalFormat("0.00");

        Bundle bundle = this.getIntent().getExtras();
        String height = bundle.getString("height");
        String weight = bundle.getString("weight");
        double BMI = bundle.getDouble("BMI");

        tvHeight.setText("身高 (cm)：" + height);
        tvWeight.setText("體重 (kg)： " + weight);
        tvBMI.setText(" BMI： " + BMI);
        textResult.setText("Your BMI is " + nf.format(BMI));
        if (BMI > 25) {

            textSuggest.setText(R.string.advice_heavy);

        } else if (BMI < 20) {

            textSuggest.setText(R.string.advice_light);

        } else {

            textSuggest.setText(R.string.advice_average);

        }
    }
}
