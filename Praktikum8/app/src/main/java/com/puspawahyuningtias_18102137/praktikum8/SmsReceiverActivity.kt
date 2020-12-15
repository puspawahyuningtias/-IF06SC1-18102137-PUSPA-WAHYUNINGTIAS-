package com.puspawahyuningtias_18102137.praktikum8

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_sms_receiver.*
import java.util.*

@Suppress("TYPE_INFERENCE_ONLY_INPUT_TYPES_WARNING")
class SmsReceiverActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_SMS_NO = "extra_sms_no"
        const val EXTRA_SMS_MESSAGE = "extra_sms_message"
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sms_receiver)
        title = getString(R.string.incoming_message)
        val senderNo = intent.getStringExtra(EXTRA_SMS_NO)
        val senderMessage = intent.getStringExtra(EXTRA_SMS_MESSAGE)
        val lower = senderMessage?.toLowerCase(Locale.ROOT)
        val penipuan = arrayOf("hadiah", "blogspot", "wordpress", "pulsa", "selamat", "transfer", "mobil", "polisi", "rumah")
        val cek = penipuan.filter { it in lower!!.split(" ") }
        if (cek.size >= 2) {
            tv_message.text = "PESAN PENIPUAN!!!!\n\n$senderMessage"
            tv_message.setTextColor(ContextCompat.getColor(this, android.R.color.holo_red_dark))
        } else {
            tv_message.text = senderMessage
        }
        tv_from.text = getString(R.string.coming_from) + ": " + senderNo
        btn_close.setOnClickListener { finish() }
    }
}