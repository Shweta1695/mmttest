package com.example.shwetatripathi.mmt;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

public class LogIn extends AppCompatActivity implements View.OnClickListener,GoogleApiClient.OnConnectionFailedListener {

    private Button bsignup;
    //private Button SignOut;
    private SignInButton SignIn;
    private TextView Name,Email;
    private GoogleApiClient googleApiClient;
    private static final int REQ_CODE=9001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        bsignup=findViewById(R.id.button_signup);

        SignIn=findViewById(R.id.button_google_login);
        SignIn.setOnClickListener(this);
        GoogleSignInOptions signInOptions=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        googleApiClient=new GoogleApiClient.Builder(this).enableAutoManage(this,this).addApi(Auth.GOOGLE_SIGN_IN_API,signInOptions).build();



        bsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent =new Intent(LogIn.this,SignUp.class);
                startActivity(homeIntent);
                finish();
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
