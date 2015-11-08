package adamwoollen.gmail.com.water_reporter;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Boolean loggedIn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Code to check login
        //if logged in...
        //set full name
        //set profile picture
        //set reputation

        if(loggedIn){
            TextView txt_userName = (TextView) findViewById(R.id.txt_userName);
            txt_userName.setText("It's working!");
        } else{
            Intent intent = new Intent(this, LoginActivity.class);
            startActivityForResult(intent, 1);
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                TextView name = (TextView) findViewById(R.id.txt_userName);
                TextView rep = (TextView) findViewById(R.id.txt_userRep);
                ImageView proPic = (ImageView) findViewById(R.id.img_profilePic);
                name.setText(data.getStringExtra("name"));
                rep.setText("Level " + data.getStringExtra("rep"));
                proPic.setImageResource(R.drawable.profile_pic_adam);
            } else{
                //nothing here, leave as is
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //////////////////////////////////////////////////////////////////

    public void launchReportProblem(View view){
        Intent intent = new Intent(this, ReportProblemMain.class);
        startActivity(intent);
    }

    public void launchMap(View view){
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

    public void moreInfo(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.stwater.co.uk/aboutus"));
        startActivity(browserIntent);
    }

    public void contactUs(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.stwater.co.uk/mt/severntrentwater.custhelp.com/?un_jtt_v_help=yes"));
        startActivity(browserIntent);
    }
}