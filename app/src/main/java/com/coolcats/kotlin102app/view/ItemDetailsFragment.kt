package com.coolcats.kotlin102app.view

import android.content.Context
import android.os.Bundle
import android.util.DebugUtils
import android.util.Log
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.coolcats.kotlin102app.R
import com.coolcats.kotlin102app.util.DebugTools
import kotlinx.android.synthetic.main.item_details_layout.view.*
import kotlinx.android.synthetic.main.quote_item_layout.view.*
import kotlinx.android.synthetic.main.quote_item_layout.view.author_textview
import kotlinx.android.synthetic.main.quote_item_layout.view.quote_textview

class ItemDetailsFragment() : Fragment() {

//    companion object {
//        const val TAG = "SimpleDialog"
//
//        private const val AUTHOR = ""
//        private const val QUOTE = ""
//        private const val HTML = ""
//
//        fun newInstance(author: String, quote: String, html: String): ItemDetailsFragment {
//            val args = Bundle()
//            DebugTools.logThis("$author $quote $html")
//            args.putString(AUTHOR, author)
//            args.putString(QUOTE, quote)
//            args.putString(HTML,html)
//            val fragment = ItemDetailsFragment()
//            fragment.arguments = args
//            return fragment
//        }
//
//    }


override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
): View? {
    return inflater.inflate(R.layout.item_details_layout, container, false)
}

override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    setupView(view)
    setupClickListeners(view)
}

override fun onStart() {
    super.onStart()
}

private fun setupView(view: View) {
//    view.author_textview.setText(AUTHOR)
//    view.quote_textview.setText(QUOTE)
//    view.html_textview.setText(HTML)
    DebugTools.logThis("setupView")
}

private fun setupClickListeners(view: View) {

}


}
