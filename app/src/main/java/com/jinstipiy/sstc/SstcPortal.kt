package com.jinstipiy.sstc

import android.content.Context
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class SstcPortal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sstc_portal)


        saveCredentials(this, "123456", "01-01-2000")


        // WebView setup for the SSTC Portal
        val webView = findViewById<WebView>(R.id.webView)
        webView.settings.javaScriptEnabled = true
        webView.webViewClient = WebViewClient()

        // Load the portal URL
        val (enrollmentNumber, password) = loadCredentials(this)

        if (enrollmentNumber != null && password != null) {
            // Auto-fill credentials using JavaScript
            webView.loadUrl("https://sstcstudent.conicworks.com/login.php")
            webView.evaluateJavascript(
                """
                document.getElementById('enrollmentField').value = '$enrollmentNumber';
                document.getElementById('passwordField').value = '$password';
                document.getElementById('loginButton').click();
                """.trimIndent(),
                null
            )
        } else {
            // No credentials saved, just load the login page
            webView.loadUrl("https://sstcstudent.conicworks.com/login.php")
        }
    }

    // Save credentials
    fun saveCredentials(context: Context, enrollmentNumber: String, password: String) {
        val sharedPreferences = context.getSharedPreferences("SSTC_Preferences", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("ENROLLMENT_NUMBER", enrollmentNumber)
        editor.putString("PASSWORD", password)
        editor.apply() // Commit changes
    }

    // Load credentials
    fun loadCredentials(context: Context): Pair<String?, String?> {
        val sharedPreferences = context.getSharedPreferences("SSTC_Preferences", Context.MODE_PRIVATE)
        val enrollmentNumber = sharedPreferences.getString("ENROLLMENT_NUMBER", null)
        val password = sharedPreferences.getString("PASSWORD", null)
        return Pair(enrollmentNumber, password)
    }

    // Reset credentials
    fun resetCredentials(context: Context) {
        val sharedPreferences = context.getSharedPreferences("SSTC_Preferences", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.clear() // Removes all saved data
        editor.apply()
    }
}
