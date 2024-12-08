package com.jinstipiy.sstc

import android.content.Context
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class SemTT : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sem_timetable)
        supportActionBar?.hide()


        // WebView setup for the Semester Time Table
        val webView = findViewById<WebView>(R.id.webViewTimeTable)
        webView.settings.javaScriptEnabled = true
        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://docs.google.com/spreadsheets/d/e/2PACX-1vQEsaot0I3dx-7FxjDjPMcWsXVCKJDk0fb-Y5rMgaxEHXlo8j1ld8M5T-hM7KPTLtrkgIW_M9yYtdaj/pubhtml")
    }
}
