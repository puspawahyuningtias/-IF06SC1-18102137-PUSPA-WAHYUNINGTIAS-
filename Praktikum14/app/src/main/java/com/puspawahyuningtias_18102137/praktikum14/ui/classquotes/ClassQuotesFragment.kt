package com.puspawahyuningtias_18102137.praktikum14.ui.classquotes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.puspawahyuningtias_18102137.praktikum14.CoroutineContextProvider
import com.puspawahyuningtias_18102137.praktikum14.QuoteAdapter
import com.puspawahyuningtias_18102137.praktikum14.R
import com.puspawahyuningtias_18102137.praktikum14.TokenPref
import com.puspawahyuningtias_18102137.praktikum14.`interface`.MainView
import com.puspawahyuningtias_18102137.praktikum14.api.MainPresenter
import com.puspawahyuningtias_18102137.praktikum14.databinding.FragmentClassQuotesBinding
import com.puspawahyuningtias_18102137.praktikum14.model.Login
import com.puspawahyuningtias_18102137.praktikum14.model.Quote
import com.puspawahyuningtias_18102137.praktikum14.model.Token
import kotlinx.android.synthetic.main.fragment_class_quotes.*
import org.jetbrains.anko.support.v4.onRefresh

class ClassQuotesFragment : Fragment(), MainView {
    private lateinit var presenter: MainPresenter
    private var quotes: MutableList<Quote> = mutableListOf()
    private lateinit var adapter: QuoteAdapter
    private lateinit var tokenPref: TokenPref
    private lateinit var token: Token
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState:
        Bundle?
    ): View? = inflater.inflate(R.layout.fragment_class_quotes, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentClassQuotesBinding.bind(view)
        binding.recyclerviewClassQuotes.layoutManager = LinearLayoutManager(activity)
        tokenPref = TokenPref(requireActivity())
        token = tokenPref.getToken()
        adapter = QuoteAdapter(requireActivity())
        binding.recyclerviewClassQuotes.adapter = adapter
        presenter =
            MainPresenter(this, CoroutineContextProvider())
        progressbar.visibility = View.VISIBLE
        presenter.getMyQuotes(token.token)
        swiperefresh.onRefresh {
            progressbar.visibility = View.INVISIBLE
            presenter.getMyQuotes(token.token)
        }
    }
    override fun onResume() {
        super.onResume()
        presenter.getClassQuotes(token.token)
    }
    override fun showMessage(messsage: String) {
        Toast.makeText(requireActivity(),messsage, Toast.LENGTH_SHORT).show()
    }
    override fun resultQuote(data: ArrayList<Quote>) {
        quotes.clear()
        adapter.listQuotes = data
        quotes.addAll(data)
        adapter.notifyDataSetChanged()
        progressbar.visibility = View.INVISIBLE
        swiperefresh.isRefreshing = false
    }
    override fun resultLogin(data: Login) {
    }
}