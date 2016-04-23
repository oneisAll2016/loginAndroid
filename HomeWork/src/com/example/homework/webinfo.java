package com.example.homework;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

public class webinfo  extends Activity {
	private WebView webView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.web_layout);
		initview();
	}

	private void initview() {
		webView=(WebView) findViewById(R.id.web);
	    Intent intent=getIntent();
	    String stringExtra = intent.getStringExtra("URL");
	    webView.loadUrl(stringExtra);
	}

}
