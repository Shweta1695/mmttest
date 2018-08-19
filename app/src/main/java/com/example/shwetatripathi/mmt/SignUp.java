package com.example.shwetatripathi.mmt;

import android.content.Intent;
import android.os.Bundle;
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

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SignUp extends AppCompatActivity {

    private static final String REGISTER_URL = "http://54.242.83.222:8080/MakeMyTrip/mmt/authentication/signup";
    String emailvalidate;
    Intent intent;
    Button button_SignUp;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
    String passwordvalidate;
    private TextView fn, ln, Email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        fn = findViewById(R.id.fn);
        ln = findViewById(R.id.ln);
        Email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        button_SignUp = findViewById(R.id.button_SignUp);

        //Validation
        // fn= (TextView) fn.getText();
        //ln= (TextView) ln.getText();

        emailvalidate = Email.getText().toString();
        passwordvalidate = password.getText().toString();


      /*  StringRequest request = new StringRequest(REGISTER_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("CODE", response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(SignUp.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
*/

       /* if (fn.getText().toString().length() == 0)//First Name not empty
            fn.setError("First Name required");
        if (ln.getText().toString().length() == 0)//Last Name not empty
            ln.setError("Last Name required");
        if (Email.getText().toString().length() == 0)//e-mail not empty
            Email.setError("Email Id required");
        else if (!emailvalidate.matches(emailPattern))//invalid email
            Email.setError("Invalid email");
        else if (password.getText().toString().length() == 0)//password not empty
            password.setError("Password required");
        else if (!passwordvalidate.matches(PASSWORD_PATTERN))
            password.setError("Password must require 1 special character,1 number,1 capital letter,and must contain letter more than or equal to 4");
*/

        button_SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //post request

                if (fn.getText().toString().length() == 0)//fn not empty
                    fn.setError("First Name required");
                if (ln.getText().toString().length() == 0)//ln not empty
                    ln.setError("Last Name required");
                if (Email.getText().toString().length() == 0)//e-mail not empty
                    Email.setError("Email Id required");
                /*else if (!emailvalidate.matches(emailPattern))//invalid email
                    Email.setError("Invalid email");*/
                else if (password.getText().toString().length() == 0)//password not empty
                    password.setError("Password required");
           /*     else if (!passwordvalidate.matches(PASSWORD_PATTERN))
                    password.setError("Password must require 1 special character,1 number,1 capital letter,and must contain letter more than or equal to 8");
*/

                Map<String, String> params = new HashMap();
                params.put("fName", fn.getText().toString());
                params.put("lName", ln.getText().toString());
                params.put("username", Email.getText().toString());
                params.put("password", password.getText().toString());


                JSONObject parameters = new JSONObject(params);
/*
                JSONObject js = new JSONObject();
                try {
                   // js.put("name", "anything");
                    js.put("fName", "qw");
                    js.put("lName", "qwer");
                    js.put("username", "qwe@infogain.com");
                    js.put("password", "zxcvbnmas");
                } catch (JSONException e) {
                    e.printStackTrace();
                }*/

                // Make request for JSONObject
                /*JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST, REGISTER_URL, js,
                        new Response.Listener<JSONObject>() {*/

                JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.POST, REGISTER_URL, parameters, new Response.Listener<JSONObject>() {

                    @Override
                            public void onResponse(JSONObject response) {
                                Toast.makeText(SignUp.this, "Success", Toast.LENGTH_LONG).show();
                        intent = new Intent(SignUp.this, LogIn.class);
                        startActivity(intent);
                        finish();

                    }

                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(SignUp.this, "ERROR", Toast.LENGTH_LONG).show();

                    }
                }) {

                    /*@Override
                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("fName", fn.toString());
                        params.put("lName", ln.toString());
                        params.put("username", Email.toString());
                        params.put("password", password.toString());
                        //  params.put(KEY_MERCHANTCONFIRMPASSWORD, merchantConfirmPassword);
                        return params;
                    }*/

                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        HashMap<String, String> headers = new HashMap<String, String>();
                        headers.put("Content-Type", "application/json; charset=utf-8");
                        return headers;
                    }

                };

                // Adding request to request queue

                Volley.newRequestQueue(SignUp.this).add(jsonRequest);
                Log.d("Json result","value--"+parameters.toString());
              //  Log.d("Json result","Request---"+jsonObjReq.toString());


            }

















/*
                StringRequest stringRequest = new StringRequest(Request.Method.POST, REGISTER_URL,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Toast.makeText(SignUp.this, response, Toast.LENGTH_LONG).show();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(SignUp.this, "shweta error", Toast.LENGTH_LONG).show();
                                intent = new Intent(SignUp.this, SignUp.class);
                                startActivity(intent);
                                finish();
                            }
                        }) {
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("fName", fn.toString());
                        params.put("lName", ln.toString());
                        params.put("username", Email.toString());
                        params.put("password", password.toString());
                        //  params.put(KEY_MERCHANTCONFIRMPASSWORD, merchantConfirmPassword);
                        return params;
                    }
                   // @Override
                    public Map<String,String> getHeader() {
                        HashMap<String,String> headers = new HashMap();
                        headers.put("Content-Type","application/json;charset=UTF-8");
                        return headers;

                    }
                };
                 RequestQueue requestQueue = Volley.newRequestQueue(SignUp.this);
                requestQueue.add(stringRequest);
                intent=new Intent(SignUp.this,LogIn.class);
                startActivity(intent);
                finish();

            }
        });*/


        });
    }
}

