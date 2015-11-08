package adamwoollen.gmail.com.water_reporter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View view){
        EditText username = (EditText) findViewById(R.id.editTxt_username);
        EditText password = (EditText) findViewById(R.id.editTxt_password);
        TextView xpass = (TextView) findViewById(R.id.txt_incorrectLogin);
        if(username.getText().toString().equals("Adzwoolly") && password.getText().toString().equals("Password123!")){
            xpass.setVisibility(View.GONE);
            Intent intent = new Intent();
            intent.putExtra("name","Adam Woollen");
            intent.putExtra("rep", "∞");
            setResult(RESULT_OK, intent);
            finish();
        } else{
            xpass.setVisibility(View.VISIBLE);
        }
    }

    public void skip(View view){
        xpass.setVisibility(View.GONE);
        Intent intent = new Intent();
        setResult(RESULT_CANCELED, intent);
        finish();
    }
}
