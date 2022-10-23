package com.frogobox.research.ui.detail

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.frogobox.research.core.BaseBindActivity
import com.frogobox.research.databinding.ActivityDetailBinding
import com.frogobox.research.util.Constant
import com.frogobox.research.util.Constant.Extra.RESULT_EXTRA_DATA
import com.frogobox.research.util.Constant.ResultCode.RESULT_CODE_FROM_DETAIL


class DetailActivity : BaseBindActivity<ActivityDetailBinding>() {

    companion object {
        private val TAG: String = DetailActivity::class.java.simpleName
    }

    private val viewModel: DetailViewModel by viewModels()

    private val extraData: String by lazy {
        intent.getStringExtra(Constant.Extra.EXTRA_DATA) ?: ""
    }

    override fun initBinding(): ActivityDetailBinding {
        return ActivityDetailBinding.inflate(layoutInflater)
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

            btnBackToMain.setOnClickListener {
                val message = "Horee $extraData from Detail Activity"

                setResult(RESULT_CODE_FROM_DETAIL, Intent().apply {
                    putExtra(RESULT_EXTRA_DATA, message)
                })
                finish() // finishing activity
            }

        }
    }

    override fun initObserver() {
        super.initObserver()
        viewModel.apply {

        }
    }

}