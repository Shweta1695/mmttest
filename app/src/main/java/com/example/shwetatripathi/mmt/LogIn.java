package com.example.shwetatripathi.mmt;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LogIn extends AppCompatActivity implements View.OnClickListener,GoogleApiClient.OnConnectionFailedListener {

    private Button bsignup,email_sign_in_button;
    //private Button SignOut;
    private SignInButton SignIn;
    private TextView password,Email;
    Intent intent;
    String emailvalidate;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
    String passwordvalidate;
    private GoogleApiClient googleApiClient;
    private static final int REQ_CODE=9001;
    private static final String REGISTER_URL = "http://54.242.83.222:8080/MakeMyTrip/mmt/authentication/login";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        Email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        bsignup=findViewById(R.id.button_signup);
        SignIn=findViewById(R.id.button_google_login);
        email_sign_in_button=findViewById(R.id.email_sign_in_button);

        SignIn.setOnClickListener(this);




      /*  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow(); // in Activity's onCreate() for instance
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }*/


        GoogleSignInOptions signInOptions=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        googleApiClient=new GoogleApiClient.Builder(this).enableAutoManage(this,this).addApi(Auth.GOOGLE_SIGN_IN_API,signInOptions).build();

        //Register Button
        bsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent =new Intent(LogIn.this,SignUp.class);
                startActivity(homeIntent);
                finish();
            }
        });

        //Validation
        emailvalidate = Email.getText().toString();
        passwordvalidate = password.getText().toString();

    /*    if (Email.getText().toString().length() == 0)//e-mail not empty
            Email.setError("Email Id required");
    */   /* if (Email.getText().toString().length() == 0)//e-mail not empty
            Email.setError("email id required");
        else if (!emailvalidate.matches(emailPattern))//invalid email
            Email.setError("invalid email");
        else if (password.getText().toString().length() == 0)//password not empty
            password.setError("password required");
        else if (!passwordvalidate.matches(PASSWORD_PATTERN))
            password.setError("password must require 1 special character,1 number,1 capital letter,and must contain letter more than or equal to 4");
           */
        email_sign_in_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //post request


                Map<String, String> params = new HashMap();
                params.put("username", Email.getText().toString());
                params.put("password", password.getText().toString());


                JSONObject parameters = new JSONObject(params);


                JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.POST, REGISTER_URL, parameters, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(LogIn.this, "Success", Toast.LENGTH_LONG).show();
                        intent = new Intent(LogIn.this, Offers.class);
                        startActivity(intent);
                        finish();
                    }

                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(LogIn.this, "Invalid Credentials", Toast.LENGTH_LONG).show();

                    }
                }) {


                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        HashMap<String, String> headers = new HashMap<String, String>();
                        headers.put("Content-Type", "application/json; charset=utf-8");
                        return headers;
                    }

                };

                // Adding request to request queue

                Volley.newRequestQueue(LogIn.this).add(jsonRequest);
                Log.d("Json result","value--"+parameters.toString());
                //  Log.d("Json result","Request---"+jsonObjReq.toString());


            }

                    });






        }


    @Override
    public void onClick(View v) {

        switch(v.getId())
        {
            case R.id.button_google_login:
          signIn();
          break;

        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Toast.makeText(this,"ERROR",Toast.LENGTH_SHORT).show();
    }
    public void signIn()
    {
        Intent intent=Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
        startActivityForResult(intent,REQ_CODE);

    }
    private void handleResult(GoogleSignInResult result)
    {

        if(result.isSuccess())
        {
            GoogleSignInAccount account=result.getSignInAccount();
            String name=account.getDisplayName();
            String email=account.getEmail();
            String img_url=account.getPhotoUrl().toString();
                 //   Glide.with(this).load(img_url).into(Prof_Pic);
            updateUI(true);
        }
        else
            {
                updateUI(false);
        }

    }
    private void updateUI(boolean isLogin)
    {

        if(isLogin)
        {

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==REQ_CODE)
        {
            GoogleSignInResult result=Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleResult(result);

        }
    }
}
