package labtec.br.handler;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    MyHandler h;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Opening main screen...", Toast.LENGTH_LONG).show();
                activityShow( R.layout.activity_welcome, (LinearLayout) findViewById(R.id.layoutContent));
            }
        });

        setSupportActionBar(toolbar);
        h = new MyHandler(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        try {
            switch (item.getItemId()){
                case R.id.btnInfo:
                    activityShow( R.layout.activity_info, (LinearLayout) findViewById(R.id.layoutContent));
                    getInfo();
                    break;
                case R.id.btnAbout:
                    activityShow( R.layout.activity_about, (LinearLayout) findViewById(R.id.layoutContent));
                    break;
                case R.id.btnExit:
                    Toast.makeText(this, "Quiting " + getString(R.string.app_name) + "... \nThank You!", Toast.LENGTH_LONG).show();
                    this.finishAndRemoveTask();
                    break;
                default:
                    break;
            }
        }catch (Exception e){
            Log.e("Main ActivityMenuItem",e.toString());
        }

        return super.onOptionsItemSelected(item);
    }


    private void activityShow(int activity_resource, ViewGroup p) {
        try {

            LayoutInflater layoutInflater = getLayoutInflater();
            p.removeAllViews();

            View v = layoutInflater.inflate(activity_resource, p);
            p.addView(v);

        }catch (Exception e){
            Log.e("Main activityShow",e.toString());
        }

    }

    private void getInfo() {

        try {
            //TextView txtDetails = (TextView) findViewById(R.id.txtDetails);
            //txtDetails.setText("OIOIOIOIOI");
        }catch (Exception e) {
            Log.e("Main ActivitygetInfo", e.toString());
        }
    }

}
