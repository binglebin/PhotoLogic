package com.JungleBin.PhotoLojic;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class OptionActivity extends AppCompatActivity {

    SharedPreferences pref;
    ToggleButton btn_toggle1,btn_toggle2 ;
    TextView textView1,textView2 ;
    AudioManager aManager;
    NotificationManager notificationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);

        btn_toggle1 = (ToggleButton) findViewById(R.id.btn_toggle1);
        btn_toggle2 = (ToggleButton) findViewById(R.id.btn_toggle2);
        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        aManager = (AudioManager) getApplicationContext().getSystemService(Context.AUDIO_SERVICE);



        pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        if(pref.getString("choice", "").equals("1")){
            textView1.setText("Sound ON");
            textView2.setText("Vibration OFF");

        } else if(pref.getString("choice", "").equals("0")){
            textView1.setText("Sound OFF");
            textView2.setText("Vibration ON");

        }else if(pref.getString("choice", "").equals("2")){
            textView1.setText("Vibration ON");
            textView1.setText("Sound OFF");

        }else if(pref.getString("choice", "").equals("3")){
            textView1.setText("Sound OFF");
            textView2.setText("Vibration ON");

        }
        btn_toggle1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton arg0, boolean isChecked) {
                if(isChecked == true){
                    textView1.setText("Sound ON");
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("choice", "1");
                    btn_toggle2.setChecked(false);
                    aManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                    Toast.makeText(OptionActivity.this,"소리모드 입니다.",Toast.LENGTH_SHORT).show();
                    editor.commit();
                } else {
                    textView1.setText("Sound OFF");
                    System.out.println("토글버튼 해제");
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("choice", "0");
                    btn_toggle2.setChecked(true);
                    aManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
                    Toast.makeText(OptionActivity.this,"진동모드 입니다.",Toast.LENGTH_SHORT).show();
                    editor.commit();
                }
            }
        });
        btn_toggle2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton arg0, boolean isChecked) {
                if(isChecked == true){
                    textView2.setText("Vibration ON");
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("choice", "2");
                    btn_toggle1.setChecked(false);
                    aManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
                    Toast.makeText(OptionActivity.this,"진동모드 입니다.",Toast.LENGTH_SHORT).show();
                    editor.commit();
                } else {
                    textView2.setText("Vibration OFF");
                    System.out.println("토글버튼 해제");
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("choice", "3");
                    btn_toggle1.setChecked(true);
                    aManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                    Toast.makeText(OptionActivity.this,"소리모드 입니다.",Toast.LENGTH_SHORT).show();
                    editor.commit();
                }
            }
        });


    }

}
