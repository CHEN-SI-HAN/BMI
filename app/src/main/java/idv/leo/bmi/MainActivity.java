package idv.leo.bmi;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;





public class MainActivity extends Activity {





    @Override


    public void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);








        Button button = (Button)findViewById(R.id.buttonCalculate);


        button.setOnClickListener(calcBMI);


    }





    @Override


    public boolean onCreateOptionsMenu(Menu menu) {


        getMenuInflater().inflate(R.menu.menu_main, menu);


        return true;


    }





    private OnClickListener calcBMI = new OnClickListener()


    {


        public void onClick(View v)


        {


            DecimalFormat nf = new DecimalFormat("0.00");


            EditText fieldheight = (EditText)findViewById(R.id.inputHeight);


            EditText fieldweight = (EditText)findViewById(R.id.inputWeight);


            double height = Double.parseDouble(fieldheight.getText().toString())/100;


            double weight = Double.parseDouble(fieldweight.getText().toString());


            double BMI = weight / (height * height);





            TextView result = (TextView)findViewById(R.id.textResult);


            result.setText("Your BMI is " + nf.format(BMI));








            TextView fieldsuggest = (TextView)findViewById(R.id.textSuggest);


            if(BMI>25){


                fieldsuggest.setText(R.string.advice_heavy);


            }else if(BMI<20){


                fieldsuggest.setText(R.string.advice_light);


            }else {


                fieldsuggest.setText(R.string.advice_average);


            }


        }


    };


}