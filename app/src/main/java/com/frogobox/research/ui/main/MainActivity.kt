package com.frogobox.research.ui.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import com.frogobox.research.core.BaseBindActivity
import com.frogobox.research.databinding.ActivityMainBinding
import com.frogobox.research.ui.detail.DetailActivity
import com.frogobox.research.util.Constant
import com.frogobox.research.util.Constant.ResultCode.RESULT_CODE_FROM_DETAIL

class MainActivity : BaseBindActivity<ActivityMainBinding>() {

    companion object {
        private val TAG: String = MainActivity::class.java.simpleName
    }

    private val viewModel: MainViewModel by viewModels()

    override fun initBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            // Call View Model Here
            Log.d(TAG, "View Model : ${viewModel::class.java.simpleName}")
        }
        // TODO : Add your code here

    }

    override fun initView() {
        super.initView()
        binding.apply {

            btnGoToDetail.setOnClickListener {
                resultLauncher.launch(Intent(this@MainActivity, DetailActivity::class.java).apply {
                    putExtra(Constant.Extra.EXTRA_DATA, "Hello World !!!")
                })
            }

        }
    }

    override fun initObserver() {
        super.initObserver()
        viewModel.apply {

        }
    }

    var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_CODE_FROM_DETAIL) {
            // There are no request codes
            val data: Intent? = result.data
            Log.d(TAG, "Result : ${data?.getStringExtra(Constant.Extra.EXTRA_DATA)}")
            binding.tvMain.text = data?.getStringExtra(Constant.Extra.RESULT_EXTRA_DATA)
        }
    }

}