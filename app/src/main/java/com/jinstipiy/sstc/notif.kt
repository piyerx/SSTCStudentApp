package com.jinstipiy.sstc

import android.content.Context
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class notif : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.notif)


        // WebView setup for the Notifications Activity

        val webView = findViewById<WebView>(R.id.webViewNotif)
        webView.settings.javaScriptEnabled = true
        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://sstc.ac.in/notifications")
    }
}

