package com.example.pageviewactivity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class MyFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstance: Bundle?): View? {

        val message = arguments!!.getString(EXTRA_MESSAGE)

        val v = inflater.inflate(R.layout.myfragment_layout, container, false)

        val messageTextView = v.findViewById<View>(R.id.captain) as TextView
        messageTextView.text = message

        val webView = v.findViewById<View>(R.id.webview) as WebView
        webView.loadUrl("https://en.wikipedia.org/wiki/Splinter_(Teenage_Mutant_Ninja_Turtles)")
        val webSettings = webView.settings
        webView.webViewClient = WebViewClient()
        if (message!!.toLowerCase().contains("master splinter")) {
            webView.loadUrl("https://en.wikipedia.org/wiki/Splinter_(Teenage_Mutant_Ninja_Turtles)")
        }
        if (message.toLowerCase().contains("leonardo")) {
            webView.loadUrl("https://en.wikipedia.org/wiki/Leonardo_(Teenage_Mutant_Ninja_Turtles)")
        }
        if (message.toLowerCase().contains("donatello")) {
            webView.loadUrl("https://en.wikipedia.org/wiki/Donatello_(Teenage_Mutant_Ninja_Turtles)")
        }
        if (message.toLowerCase().contains("raphael")) {
            webView.loadUrl("https://en.wikipedia.org/wiki/Raphael_(Teenage_Mutant_Ninja_Turtles)")
        }
        if (message.toLowerCase().contains("michelangelo")) {
            webView.loadUrl("https://en.wikipedia.org/wiki/Michelangelo_(Teenage_Mutant_Ninja_Turtles)")
        }

        val img = arguments!!.getInt(IMAGE_MESSAGE)
        val image = v.findViewById<View>(R.id.img_view) as ImageView
        image.setImageResource(img)

        return v
    }

    companion object {

        val EXTRA_MESSAGE = "EXTRA MESSAGE"
        val IMAGE_MESSAGE = "IMAGE MESSAGE"

        fun newInstance(message: String, img: Int): MyFragment {
            val fragment = MyFragment()
            val bdl = Bundle()
            bdl.putString(EXTRA_MESSAGE, message)
            bdl.putInt(IMAGE_MESSAGE, img)
            fragment.arguments = bdl
            return fragment
        }
    }

}
