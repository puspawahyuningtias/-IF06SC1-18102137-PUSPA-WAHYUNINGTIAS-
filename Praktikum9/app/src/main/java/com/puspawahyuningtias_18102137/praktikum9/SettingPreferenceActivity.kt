package com.puspawahyuningtias_18102137.praktikum9

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.puspawahyuningtias_18102137.praktikum9.data.SettingModel
import com.puspawahyuningtias_18102137.praktikum9.databinding.ActivitySettingPreferenceBinding
import com.puspawahyuningtias_18102137.praktikum9.preference.SettingPreference


class SettingPreferenceActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var mSettingPreference: SettingPreference
    private lateinit var settingModel: SettingModel
    private lateinit var binding: ActivitySettingPreferenceBinding
    companion object {
        const val RESULT_CODE = 101
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingPreferenceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSave.setOnClickListener(this)
        mSettingPreference = SettingPreference(this)
        settingModel = mSettingPreference.getSetting()
        showPreferenceInForm()

        supportActionBar?.title = getString(R.string.setting_page)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_save) {
            val name = binding.edtName.text.toString().trim()
            val email = binding.edtEmail.text.toString().trim()
            val address = binding.edtAddress.text.toString().trim()
            val age = binding.edtAge.text.toString().trim()
            val phoneNo = binding.edtPhone.text.toString().trim()
            val jk = binding.rgJk.checkedRadioButtonId == R.id.rb_pr
            val isLoveMU = binding.rgLoveMu.checkedRadioButtonId == R.id.rb_yes
            if (name.isEmpty()) {
                binding.edtName.error = getString(R.string.field_required)
                return
            }
            if (email.isEmpty()) {
                binding.edtEmail.error = getString(R.string.field_required)
                return
            }
            if (!isValidEmail(email)) {
                binding.edtEmail.error = getString(R.string.email_is_not_valid)
                return
            }
            if (address.isEmpty()) {
                binding.edtAddress.error = getString(R.string.field_required)
                return
            }
            if (age.isEmpty()) {
                binding.edtAge.error = getString(R.string.field_required)
                return
            }
            if (phoneNo.isEmpty()) {
                binding.edtPhone.error = getString(R.string.field_required)
                return
            }
            if (!TextUtils.isDigitsOnly(phoneNo)) {
                binding.edtPhone.error = getString(R.string.field_digit_only)
                return
            }
            saveSetting(name, email, address, age, phoneNo, jk, isLoveMU)
            val resultIntent = Intent()
            setResult(RESULT_CODE, resultIntent)
            finish()
        }

    }
    private fun isValidEmail(email: CharSequence): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
    private fun showPreferenceInForm() {
        binding.edtName.setText(settingModel.name)
        binding.edtEmail.setText(settingModel.email)
        binding.edtAddress.setText(settingModel.address)
        binding.edtAge.setText(settingModel.age.toString())
        binding.edtPhone.setText(settingModel.phoneNumber)
        if (settingModel.jk) {
            binding.rbPr.isChecked = true
        } else {
            binding.rbLk.isChecked = true
        }
        if (settingModel.isDarkTheme) {
            binding.rbYes.isChecked = true
        } else {
            binding.rbNo.isChecked = true
        }
    }
    private fun saveSetting(name: String, email: String, address: String,age: String, phoneNo: String, jk:Boolean, isLoveMU: Boolean) {
        val settingPreference = SettingPreference(this)
        settingModel.name = name
        settingModel.email = email
        settingModel.address = address
        settingModel.age = Integer.parseInt(age)
        settingModel.phoneNumber = phoneNo
        settingModel.jk = jk
        settingModel.isDarkTheme = isLoveMU
        settingPreference.setSetting(settingModel)
        Toast.makeText(this, "Data tersimpan", Toast.LENGTH_SHORT).show()
    }
}