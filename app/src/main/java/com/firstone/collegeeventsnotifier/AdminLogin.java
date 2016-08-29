package com.firstone.collegeeventsnotifier;



import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AdminLogin extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "AdminLogin";

    public static final String LOGIN_URL = "http://shubhamjha.16mb.com/login.php";

    public static final String KEY_USERNAME="username";
    public static final String KEY_PASSWORD="password";
    private static final int REQUEST_SIGNUP = 0;

    private EditText adminName ;
    private EditText adminPassword;
    private Button adminButtonLogin;



    private String username;
    private String password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        adminName = (EditText) findViewById(R.id.adminName);
        adminPassword = (EditText) findViewById(R.id.adminPassword);


        adminButtonLogin = (Button) findViewById(R.id.adminButtonLogin);


        adminButtonLogin.setOnClickListener(this);




    }


    private void userLogin() {

        Log.d(TAG, "Login");

        if (!validate()) {
            onLoginFailed();
            return;

        }

        adminButtonLogin.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(AdminLogin.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();


        username = adminName.getText().toString().trim();
        password = adminPassword.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, LOGIN_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.trim().equals("success")){
                            openProfile();
                        }else{
                            Toast.makeText(AdminLogin.this,response,Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(AdminLogin.this,error.toString(),Toast.LENGTH_LONG ).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<String,String>();
                map.put(KEY_USERNAME,username);
                map.put(KEY_PASSWORD,password);
                return map;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onLoginSuccess or onLoginFailed
                        onLoginSuccess();
                        // onLoginFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }

    private void openProfile(){
        Intent intent = new Intent(this, NoticeListAdmin.class);
        intent.putExtra(KEY_USERNAME, username);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        userLogin();
    }


    public void onLoginSuccess() {
        adminButtonLogin.setEnabled(true);
        finish();
    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        adminButtonLogin.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String name = adminName.getText().toString().trim();
        String password = adminPassword.getText().toString().trim();

        if (name.isEmpty() || name.length() < 3) {
            adminName.setError("at least 3 characters");
            valid = false;
        } else {
            adminName.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            adminPassword.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            adminPassword.setError(null);
        }

        return valid;
    }
}