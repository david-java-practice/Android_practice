package com.example.final_project_lottery;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class NumberWebsiteActivity extends AppCompatActivity {
    private WebView wWebView; //웹뷰 선언
    private WebSettings wWebSettings; // 웹뷰셋팅

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.number_website);
        setTitle("동행복권 홈페이지");

        //웹뷰 시작
        wWebView = (WebView) findViewById(R.id.webView);

        wWebView.setWebViewClient(new WebViewClient()); //클릭시 새창 안뜨게
        wWebSettings = wWebView.getSettings(); // 세부 셋팅 등록
        wWebSettings.setJavaScriptEnabled(true); //웹페이지 자바스크립트 허용여부
        wWebSettings.setSupportMultipleWindows(false); //새창 띄우기 허용 여부
        wWebSettings.setJavaScriptCanOpenWindowsAutomatically(false); //자바스크림트 새창 띄우기(멀티뷰) 허용
        wWebSettings.setLoadWithOverviewMode(true); //메타태그 허용 여부
        wWebSettings.setUseWideViewPort(true); //화면 사이즈 맞추기 허용 여부
        wWebSettings.setSupportZoom(false); //화면 줌 허용 여부
        wWebSettings.setBuiltInZoomControls(false); //화면 확대 축소 허용 여부
        wWebSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN); //컨텐츠 사이즈 맞추기
        wWebSettings.setCacheMode(WebSettings.LOAD_NO_CACHE); //브라우저 캐시 허용 여부
        wWebSettings.setDomStorageEnabled(true); //로컬저장소 허용 여부

        wWebView.loadUrl("https://dhlottery.co.kr/common.do?method=main");
    }

}
