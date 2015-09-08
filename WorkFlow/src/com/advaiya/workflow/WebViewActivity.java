package com.advaiya.workflow;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebViewActivity extends Activity {
	 @Override
	   public void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.webviewxml);

	      WebView webView = (WebView) findViewById(R.id.webView1);
	      webView.getSettings().setJavaScriptEnabled(true);
	      webView.loadUrl("http://testmanishkmwt.blogspot.in/2015/06/blog-post.html");

	 }
	}
