package com.vli.activities;

import com.vli.vlwords.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainMenuActivity extends Activity implements OnClickListener{

	public Button btPlay, btOptions, btConnect;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        
        btPlay = (Button)findViewById(R.id.bt_play);
        btOptions =(Button)findViewById(R.id.bt_options);
        btConnect = (Button)findViewById(R.id.bt_connect);
       
        btPlay.setOnClickListener(this);
        btOptions.setOnClickListener(this);
        btConnect.setOnClickListener(this);

    }

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.bt_play:
				Intent intent = new Intent(this, GameActivity.class);
				startActivity(intent);
				break;
			case R.id.bt_options:
				
				break;
			case R.id.bt_connect:
		
				break;
	
			default:
				break;
		}
	}
}
