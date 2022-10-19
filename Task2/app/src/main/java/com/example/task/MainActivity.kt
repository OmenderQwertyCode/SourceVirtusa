package com.example.task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.viewModels
import com.example.task.Utils.NetworkResult
import com.example.task.ViewModel.UserDataViewModel
import com.example.task.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), RadioGroup.OnCheckedChangeListener {
    private lateinit var binding: ActivityMainBinding
    private val userDataViewModel: UserDataViewModel by viewModels()
    var search: CharSequence = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.radioGr.setOnCheckedChangeListener(this)

        userDataViewModel.fetchListDataResponse("1")

        DataObservable()
    }

    private fun DataObservable() {
        binding.progressCircular.visibility = View.VISIBLE
        userDataViewModel.GetListResponse.observe(this) { response ->
            when (response) {
                is NetworkResult.Success -> {
                    binding.progressCircular.visibility = View.GONE
                    response.data?.let {
                        binding.txtEmail.text = "Email : "+it.data.email
                    }
                }

                is NetworkResult.Error -> {
                    binding.progressCircular.visibility = View.GONE
                    Toast.makeText(
                        this,
                        response.message,
                        Toast.LENGTH_SHORT
                    ).show()

                    Log.e("Error", response.message.toString())
                }

                is NetworkResult.Loading -> {
                    binding.progressCircular.visibility = View.VISIBLE
                }
            }
        }
    }

    override fun onCheckedChanged(p0: RadioGroup?, p1: Int) {
        val radio: RadioButton = findViewById(p1)
       if (radio.text.endsWith("User id 1",true)){
           userDataViewModel.fetchListDataResponse("1")
       }else  if (radio.text.endsWith("User id 3",true)){
           userDataViewModel.fetchListDataResponse("3")
       } else if (radio.text.endsWith("User id 10",true)){
           userDataViewModel.fetchListDataResponse("10")
       }
        Log.e("radio",""+radio.text)

      /*  if (p0?.id == R.id.rd_user1) {
            userDataViewModel.fetchListDataResponse("1")
            DataObservable()
        } else if (p0?.id == R.id.rd_user3) {
            userDataViewModel.fetchListDataResponse("3")
            DataObservable()
        } else if (p0?.id == R.id.rd_user3) {
            userDataViewModel.fetchListDataResponse("10")
            DataObservable()
        }*/
    }


}