package com.firstone.collegeeventsnotifier;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
public class DisplayList extends ActionBarActivity {
    protected String eventstitle;
    protected String eventsDesc;
    protected String eventtime;

    public static final int DETAIL_REQUEST_CODE=1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setMessage("Loading Notices....");
        progressDialog.setIndeterminate(true);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progressDialog.cancel();
            }
        }, 2500);
        progressDialog.setCanceledOnTouchOutside(true);
        progressDialog.show();
        setContentView(R.layout.activity_display_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        eventstitle=getIntent().getStringExtra(NoticeList.EVENTS_TITLE);
        TextView tvTitle=(TextView) findViewById(R.id.tvTitle);
        tvTitle.setText(eventstitle);

        eventsDesc=getIntent().getStringExtra(NoticeList.EVENTS_DESC);
        TextView tvDesc=(TextView) findViewById(R.id.tvDescription);
        tvDesc.setText(eventsDesc);

        eventtime=getIntent().getStringExtra(NoticeList.EVENT_TIME);
        TextView tvTime=(TextView)findViewById(R.id.editText);
        tvTime.setText(eventtime);





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        getMenuInflater().inflate(R.menu.add_share, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.student_logout) {
            Intent i = new Intent(DisplayList.this,WelcomeActivity.class);
            Toast.makeText(DisplayList.this,"Logout Successful",Toast.LENGTH_LONG).show();
            startActivity(i);
            return true;
        }
        if(id==R.id.Share){
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Events");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "I have participated in "+eventstitle+" click here to visit https://jamiahamdard.ac.in/ ");
            startActivity(Intent.createChooser(sharingIntent, "Share via"));

        }
        else if(id==android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }


    public void RegisterActivity(View view) {

        Toast.makeText(DisplayList.this,"Congratulations!! You Are Registered for "+eventstitle,Toast.LENGTH_LONG).show();


        finish();
    }


    }


