package com.example.administrator.demo_1;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class login_handle extends AppCompatActivity {
    private EditText passwd_text,phone_text;
    private Button eyes,login_button;
    private Boolean showPassword = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_handle);

        // 返回按钮
        Button back_button=(Button)findViewById(R.id.back_button);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent();
                it.setClass(login_handle.this,login.class);
                startActivity(it);
                login_handle.this.finish();
            }
        });
        phone_text=(EditText)findViewById(R.id.phone_text);
        passwd_text=(EditText)findViewById(R.id.passwd_text);
        Button empty_phone=(Button)findViewById(R.id.empty_phone);
        empty_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phone_text.setText("");
            }
        });
        Button empty_passwd=(Button)findViewById(R.id.empty_passwd);
        empty_passwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passwd_text.setText("");
            }
        });
        eyes=(Button)findViewById(R.id.eyes);
        eyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (showPassword) {// 显示密码
                    Drawable drawable= getResources().getDrawable(R.drawable.open_eyes);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    eyes.setCompoundDrawables(drawable,
                            null,null,null);
                    passwd_text.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    passwd_text.setSelection(passwd_text.getText().toString().length());
                    showPassword = !showPassword;
                } else {// 隐藏密码
                    Drawable drawable= getResources().getDrawable(R.drawable.blind_eyes);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    eyes.setCompoundDrawables(drawable,
                            null,null,null);
                    passwd_text.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    passwd_text.setSelection(passwd_text.getText().toString().length());
                    showPassword = !showPassword;
                }
            }
        });
        login_button=(Button)findViewById(R.id.login_button);
    }

    public void login(View view){
        login_button.setClickable(false);
        login_button.setBackgroundResource(R.drawable.button_1_click);
        Log.v("test","123");
        login_button.setClickable(true);
    }

    public void register(View view){
        Intent it=new Intent();
        it.setClass(login_handle.this,register.class);
        startActivity(it);
    }

    public void forget(View view){
        Intent it=new Intent();
        it.setClass(login_handle.this,forget.class);
        startActivity(it);
    }
}
