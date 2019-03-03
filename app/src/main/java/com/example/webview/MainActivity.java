package com.example.webview;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    private WebView myWebView;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        myWebView = new WebView(getApplicationContext());
        setContentView(R.layout.activity_main);
//        setContentView(myWebView);

        myWebView = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        MyWebViewClient myWebViewClient = new MyWebViewClient();
        myWebView.setWebViewClient(myWebViewClient);
        myWebView.addJavascriptInterface(new WebAppInterface(this), "Android");
        myWebView.loadUrl("http://www.prakashjavadekar.com");
        /**not working*/
        myWebView.evaluateJavascript("javascript:document.getElementsByClassName('header')[0].style.display='none'",null);

        drawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // close drawer when item is tapped
                        drawerLayout.closeDrawers();

                        switch (menuItem.getItemId()) {
                            case R.id.Home:
                                myWebView.loadUrl("http://www.prakashjavadekar.com");
                                break;
                            case R.id.know_me_better:
                                break;
                            case R.id.my_journey:
                                break;
                            case R.id.media_coverage:
                                myWebView.loadUrl("http://www.prakashjavadekar.com/media-coverage/");
                                break;
                            case R.id.multimedia:
                                break;
                            case R.id.year_achievement_3:
                                myWebView.loadUrl("http://www.prakashjavadekar.com/3-year-achievements/");
                                break;
                            case R.id.year_achievement_4:
                                myWebView.loadUrl("http://www.prakashjavadekar.com/4-year-achievements/");
                                break;
                            case R.id.newslatter:
                                myWebView.loadUrl("http://www.prakashjavadekar.com/newsletter/");
                                break;
                            case R.id.blog:
                                myWebView.loadUrl("http://www.prakashjavadekar.com/blog-on-marathi-movie-gulamjaam/");
                                break;
                            case R.id.contact_me:
                                myWebView.loadUrl("http://www.prakashjavadekar.com/contact-us");
                                break;
                        }

                        return true;
                    }
                });


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()) {
            myWebView.goBack();
            return true;
        }
        // If it wasn't the Back key or there's no web page history, bubble up to the default
        // system behavior (probably exit the activity)
        return super.onKeyDown(keyCode, event);
    }
}
