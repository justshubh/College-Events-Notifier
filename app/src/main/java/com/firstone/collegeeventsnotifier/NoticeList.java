package com.firstone.collegeeventsnotifier;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Iterator;
import java.util.List;

public class NoticeList extends AppCompatActivity {
    private TextView textView;
    private List<Events> data;
    public static final String EVENTS_TITLE="eventsTitle";
    public static final String EVENTS_DESC="eventsDesc";
    public static final String EVENT_TIME="eventtime";
    public static final int DETAIL_REQUEST_CODE=1001;
    boolean back_press_clicked_once;

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
        setContentView(R.layout.activity_notice_list);

        data = DataProvider.getData();
        ArrayAdapter<Events> eventsArrayAdapter = new ArrayAdapter<Events>(this, android.R.layout.simple_list_item_1, data);
        ListView listView = (ListView) findViewById(android.R.id.list);
        listView.setAdapter(eventsArrayAdapter);

        listView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Events events = data.get(position);
                displayDetail(events);

            }


        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

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

            Intent i = new Intent(NoticeList.this,WelcomeActivity.class);
            Toast.makeText(NoticeList.this,"Logout Successful",Toast.LENGTH_LONG).show();
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private void displayDetail(Events events) {

        Intent intent=new Intent(this,DisplayList.class);
        intent.putExtra(EVENTS_TITLE,events.getTitle());
        intent.putExtra(EVENTS_DESC,events.getDescription());
        intent.putExtra(EVENT_TIME,events.getDate());
        startActivityForResult(intent,DETAIL_REQUEST_CODE);


    }




//        Iterator<Events> iterator=data.iterator();
//        StringBuilder builder=new StringBuilder();
//
//        while(iterator.hasNext()){
//            Events events=iterator.next();
//            builder.append(events.getTitle())
//                    .append("\n");
//        }
//        TextView tv= (TextView) findViewById(R.id.EventsList);
//        tv.setText(builder.toString());



    class CourseArrayAdapter extends ArrayAdapter<Events> {

        Context context;
        List<Events> objects;
        public CourseArrayAdapter(Context context, int resource, List<Events> objects) {
            super(context, resource, objects);
            this.context=context;
            this.objects=objects;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            Events events=objects.get(position);
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            View view=inflater.inflate(R.layout.events_item,null);

            TextView tv=(TextView) view.findViewById(R.id.tvTitle);
            tv.setText(events.getTitle());

            return view;
        }
    }

    @Override
    public void onBackPressed()
    {
        if (back_press_clicked_once)
        {
            moveTaskToBack(true);
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        }
        back_press_clicked_once=true;
        Toast.makeText(this, "Press back to exit.", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                back_press_clicked_once= false;
            }
        }, 2000);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }




}



