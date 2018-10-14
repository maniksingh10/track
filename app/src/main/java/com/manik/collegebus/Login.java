package com.manik.collegebus;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.concurrent.TimeUnit;

public class Login extends AppCompatActivity {

    private Button send_bt;
    private TextInputEditText nickname_et, course_et, mobile_et;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    private ConstraintLayout root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        if (currentUser != null) {
            Intent intent = new Intent(Login.this, MainActivity.class);
            finish();
            startActivity(intent);
        }
        databaseReference = FirebaseDatabase.getInstance().getReference("users");

        nickname_et = findViewById(R.id.username);
        course_et = findViewById(R.id.course);
        mobile_et = findViewById(R.id.phone);
        send_bt = findViewById(R.id.sendcodebt);
        root= findViewById(R.id.loginact);

        send_bt.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           saveInfo();
                                       }
                                   }
        );


    }
    private void saveInfo(){
        String name= nickname_et.getText().toString();
        String couse = course_et.getText().toString();
        String mobile = mobile_et.getText().toString();

        if(name.isEmpty() ||couse.isEmpty()|| mobile.length() !=10 ){
            showError();

        } else{
            sendverifycode("+91"+mobile);

        }
    }
    private void showError() {

        Snackbar snackbar = Snackbar.make(getCurrentFocus(), "Error", Snackbar.LENGTH_LONG);
        View snackBarView = snackbar.getView();
        snackBarView.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.red,null));
        snackBarView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        snackbar.show();
    }


    private void verifyCode(String code) {
        PhoneAuthCredential phoneAuthCredential = PhoneAuthProvider.getCredential(verifyID,code);
        signinwiithcreditndial(phoneAuthCredential);
    }


    private void signinwiithcreditndial(PhoneAuthCredential phoneAuthCredential) {
        firebaseAuth.signInWithCredential(phoneAuthCredential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                String name= nickname_et.getText().toString();
                String couse = course_et.getText().toString();
                String mobile = mobile_et.getText().toString();

                if(task.isSuccessful()){

                    String key = databaseReference.push().getKey();
                    UserInfo userInfo = new UserInfo(name, couse,mobile,firebaseAuth.getUid());
                    databaseReference.child("+91"+mobile).setValue(userInfo);
                    alertDialog.dismiss();
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(Login.this, "Not Success"+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                }
            }
        });
    }



    private void sendverifycode(String phone) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phone, 60, TimeUnit.SECONDS, TaskExecutors.MAIN_THREAD, mCallBack


        );
    }
    private AlertDialog alertDialog;

    private String verifyID;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallBack = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            verifyID = s;
            Toast.makeText(Login.this, "Code Sent", Toast.LENGTH_SHORT).show();
            alertDialog = new AlertDialog.Builder(
                    Login.this).create();

            // Setting Dialog Title
            alertDialog.setTitle("Verifying "+ nickname_et.getText().toString());

            // Setting Dialog Message
            alertDialog.setMessage("");

            // Setting Icon to Dialog
            alertDialog.setIcon(R.drawable.common_google_signin_btn_icon_dark);


            // Showing Alert Message
            alertDialog.show();
        }

        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
            String code = phoneAuthCredential.getSmsCode();
            if(code != null){
                verifyCode(code);
            }
        }

        @Override
        public void onVerificationFailed(FirebaseException e) {
            Toast.makeText(Login.this, e.getMessage(), Toast.LENGTH_SHORT).show();

        }
    };

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.


    }
}
