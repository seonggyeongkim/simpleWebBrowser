package kr.hs.emirim.duckbill0316.simplewebbrowser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editUrl;
    Button butMove,butPrev;
    WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setContentView(R.layout.activity_main);
        editUrl=(EditText) findViewById(R.id.edit_url);
        butMove=(Button)findViewById(R.id.but_move);
        butPrev=(Button)findViewById(R.id.but_prev);
        web=(WebView)findViewById(R.id.web);

        butMove.setOnClickListener(this); //event handler 연결!!
        butMove.setOnClickListener(this); // -> 연결을 해줘야! onClick 클래스 사용 가능!!

        web.setWebViewClient(new WebViewClient());
        WebSettings webSet=web.getSettings();
        webSet.setBuiltInZoomControls(true);
        webSet.setJavaScriptEnabled(true);
        //web.loadUrl("http://www.naver.com");
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {

        String url=null;

        switch (v.getId()){
            case R.id.but_move :
                url=editUrl.getText().toString();
                if(!url.contains("http://"))
                    url="http://"+url;
                web.loadUrl(url);
                //web.loadUrl(editUrl.getText().toString())//Stirng 값으로 변환!!
                break;
            case R.id.but_prev :
                web.goBack(); //이전 페이지로 이동!
                break;
        }

    }
}
