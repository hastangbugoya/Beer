package com.coolcats.kotlin102app.view

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

import com.coolcats.kotlin102app.R
import com.coolcats.kotlin102app.model.QuoteResponseItem
import com.coolcats.kotlin102app.util.DebugTools
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.quote_item_layout.view.*

class QuoteAdapter(private var quoteList: List<QuoteResponseItem>) :
    RecyclerView.Adapter<QuoteAdapter.QuoteViewHolder>() {
    inner class QuoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    fun updateQuotes(quoteList: List<QuoteResponseItem>) {
        this.quoteList = quoteList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.quote_item_layout, parent, false)
        return QuoteViewHolder(itemView)
    }

    fun String.fromHtmlToString(): String =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(this, Html.FROM_HTML_MODE_LEGACY).toString()
        } else {
            Html.fromHtml(this).toString()
        }

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        quoteList[position].let {
            holder.itemView.apply {
                author_textview.text = it.a
                quote_textview.text = it.q
                Glide.with(holder.itemView)
                        .applyDefaultRequestOptions(RequestOptions.centerCropTransform())
                        .load("https://picsum.photos/900/900?grayscale")
                        .into(card_item_background_imageview);
                item_cardview.setOnClickListener(View.OnClickListener { view ->
                    Toast.makeText(this.context,it.a + ": " + it.q,Toast.LENGTH_SHORT).show();
                    val bundle: Bundle = Bundle();
                    bundle.putString("author", it.a);
                    bundle.putString("quote", it.q);
                    bundle.putString("html_string", it.h);
                    val fragment = ItemDetailsFragment()
                    fragment.arguments = bundle
                    DebugTools.logThis(bundle.toString())
                    fragment.fragmentManager?.beginTransaction()
                        ?.replace(item_details_frame.id,fragment)
                        ?.commit()
                })
            }
        }
    }

    override fun getItemCount(): Int = quoteList.size
}