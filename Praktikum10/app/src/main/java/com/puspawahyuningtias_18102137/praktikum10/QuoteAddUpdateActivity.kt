package com.puspawahyuningtias_18102137.praktikum10

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.puspawahyuningtias_18102137.praktikum10.data.Quote
import com.puspawahyuningtias_18102137.praktikum10.databinding.ActivityQuoteAddUpdateBinding
import com.puspawahyuningtias_18102137.praktikum10.db.QuoteHelper
import com.puspawahyuningtias_18102137.praktikum10.helper.EXTRA_POSITION
import com.puspawahyuningtias_18102137.praktikum10.helper.EXTRA_QUOTE
import com.puspawahyuningtias_18102137.praktikum10.helper.categoryList

class QuoteAddUpdateActivity : AppCompatActivity(), View.OnClickListener {
    private var isEdit = false
    private var quote: Quote? = null
    private var position: Int = 0
    private var category: String = "0"
    private lateinit var quoteHelper: QuoteHelper
    private lateinit var binding: ActivityQuoteAddUpdateBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuoteAddUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var spinnerAdapter= ArrayAdapter(this, R.layout.simple_list_item_1,categoryList)
        binding.edtCategory.adapter=spinnerAdapter
        binding.edtCategory.onItemSelectedListener = object : AdapterView.OnItemSelectedListener
        {
            override fun onItemSelected(
                parent: AdapterView<*>, view: View, position: Int, id: Long
            ) {
                category = position.toString()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(this@QuoteAddUpdateActivity, "array terpilih = " +
                        position.toString(), Toast.LENGTH_SHORT).show()
            }
        }
        quoteHelper = QuoteHelper.getInstance(applicationContext)
        quoteHelper.open()
        quote = intent.getParcelableExtra(EXTRA_QUOTE)
        if (quote != null) {
            position = intent.getIntExtra(EXTRA_POSITION, 0)
            isEdit = true
        } else {
            quote = Quote()
        }
        val actionBarTitle: String
        val btnTitle: String
        if (isEdit) {
            actionBarTitle = "Ubah"
            btnTitle = "Update"
            quote?.let {
                binding.edtTitle.setText(it.title)
                binding.edtDescription.setText(it.description)
                binding.edtCategory.setSelection(it.category!!.toInt())
            }!!
        } else {
            actionBarTitle = "Tambah"
            btnTitle = "Simpan"
        }
        supportActionBar?.title = actionBarTitle
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.btnSubmit.text = btnTitle
        binding.btnSubmit.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }
}