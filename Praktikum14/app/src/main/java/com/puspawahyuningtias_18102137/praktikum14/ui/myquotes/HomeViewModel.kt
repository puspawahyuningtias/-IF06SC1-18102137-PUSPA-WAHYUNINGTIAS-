package com.puspawahyuningtias_18102137.praktikum14.ui.myquotes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.puspawahyuningtias_18102137.praktikum14.R

class HomeViewModel : Fragment() {

    private lateinit var myQuotesFragment: MyQuotesFragment

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        myQuotesFragment =
                ViewModelProvider(this).get(MyQuotesFragment::class.java)
        val root = inflater.inflate(R.layout.fragment_my_quotes, container, false)
        val textView: TextView = root.findViewById(R.id.text_notifications)
        myQuotesFragment.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}