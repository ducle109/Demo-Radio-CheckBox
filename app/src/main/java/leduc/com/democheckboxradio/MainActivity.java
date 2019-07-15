package leduc.com.democheckboxradio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private CheckBox    checkBox1, checkBox2, checkBox3;
    private RadioButton radioButton1, radioButton2, radioButton3;
    private RadioGroup radioGroup;
    private TextView    textView1;
    private Button      button1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        button1.setOnClickListener(this);

        // HÀM CHECK BOX
        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    showToast("Bạn Đã Chọn " + checkBox1.getText());
                    textView1.setText(checkBox1.getText() + "");
                } else {
                    showToast("Bạn Đã Bỏ Chọn " + checkBox1.getText());
                    textView1.setText("Bạn Định Làm Gì ???");
                }
            }
        });


        // HÀM RADIO
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                switch (id) {
                    case R.id.radioButton1:
                        showToast("Ok " + radioButton1.getText());
                        break;
                    case R.id.radioButton2:
                        showToast("Ok " + radioButton2.getText());
                        break;
                    case R.id.radioButton3:
                        showToast("Ok " + radioButton3.getText());
                        break;
                }
            }
        });
    }

    // click và check và check radio vào button
    @Override
    public void onClick(View view) {
        // check box
        String str = "";
        if(checkBox1.isChecked()) {
            str += checkBox1.getText() + "\n";
        }
        if(checkBox2.isChecked()) {
            str += checkBox2.getText() + "\n";
        }
        if(checkBox3.isChecked()) {
            str += checkBox3.getText() + "\n";
        }
        if(!checkBox1.isChecked() && !checkBox2.isChecked() && !checkBox3.isChecked()) {
            showToast("Vui Lòng Ra Quyết Định Sớm");
        } else {
            textView1.setText("Cuối cùng bạn đã quyết định: \n" + str);
        }


        // check radio
        if(radioButton1.isChecked()) {
            str += radioButton1.getText() + "\n";
        }
        if(radioButton2.isChecked()) {
            str += radioButton2.getText() + "\n";
        }
        if(radioButton3.isChecked()) {
            str += radioButton3.getText() + "\n";
        }
        if(!radioButton1.isChecked() && !radioButton2.isChecked() && !radioButton3.isChecked()) {
                showToast("Vui Lòng Ra Quyết Định Sớm");
        } else {
            textView1.setText("Cuối cùng bạn đã quyết định: \n" + str);
        }
    }

    public void init() {
        textView1       = (TextView) findViewById(R.id.textView1);
        button1         = (Button) findViewById(R.id.button1);

        checkBox1       = (CheckBox) findViewById(R.id.checkBox1);
        checkBox2       = (CheckBox) findViewById(R.id.checkBox2);
        checkBox3       = (CheckBox) findViewById(R.id.checkBox3);

        radioGroup       = (RadioGroup) findViewById(R.id.btnRadioGroup);
        radioButton1     = (RadioButton) findViewById(R.id.radioButton1);
        radioButton2     = (RadioButton) findViewById(R.id.radioButton2);
        radioButton3     = (RadioButton) findViewById(R.id.radioButton3);

    }

    public void showToast(String msg) {
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
    }


}
