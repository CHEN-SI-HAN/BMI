package idv.leo.bmi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;





public class MainActivity extends Activity {
    private EditText fieldheight;
    private EditText fieldweight;
    private Button calcBMI , clear;

    @Override


    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();

    }


    @Override


    public boolean onCreateOptionsMenu(Menu menu) {


        getMenuInflater().inflate(R.menu.menu_main, menu);


        return true;


    }


public void findViews() {
    fieldheight = (EditText) findViewById(R.id.inputHeight);
    fieldweight = (EditText) findViewById(R.id.inputWeight);
    clear = (Button)findViewById(R.id.clear);
    clear.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //清除
            fieldheight.setText("");
            fieldweight.setText("");
        }
    });
    calcBMI = (Button) findViewById(R.id.calcBMI);
    calcBMI.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {


            fieldheight = (EditText) findViewById(R.id.inputHeight);
            fieldweight = (EditText) findViewById(R.id.inputWeight);
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, ResultActivity.class);
            Bundle bundle = new Bundle();
            try {
                String height = fieldheight.getText().toString();
                String weight = fieldweight.getText().toString();
                //判斷字串是否為空值
                if (height.isEmpty() || weight.isEmpty()) {
                    throw new Exception();
                }

                double height1 = Double.parseDouble(fieldheight.getText().toString()) / 100;

                double weight1 = Double.parseDouble(fieldweight.getText().toString());


                double BMI = weight1 / (height1 * height1);


                bundle.putDouble("BMI",BMI);
                bundle.putString("height", height);
                bundle.putString("weight", weight);

            } catch (Exception e) {
                Toast.makeText(MainActivity.this, getString(R.string.inputError), Toast.LENGTH_SHORT).show();
                return;
            }
            intent.putExtras(bundle);
            startActivity(intent);


        }
    });
}}