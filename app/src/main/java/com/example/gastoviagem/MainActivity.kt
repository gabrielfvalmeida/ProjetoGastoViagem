package com.example.gastoviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.gastoviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonCalculate.setOnClickListener(this)    //melhor maneira
        binding.buttonTwo.setOnClickListener(this)
        /*      binding.buttonCalculate.setOnClickListener(object : View.OnClickListener{
                  override fun onClick(v: View?) {
                      TODO("Not yet implemented")
                  }
              })*/
    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_calculate) {                 // R é pra referenciar tudo que tem no resources
            calculate()
        } else if (view.id == R.id.button_two){
            click()
        }
    }

    private fun isValid(): Boolean {
        return (binding.editDistance.text.toString() != ""
                && binding.editPrice.text.toString() != ""
                && binding.editAutonomy.text.toString() != ""
                && binding.editAutonomy.text.toString().toFloat() != 0f)
    }

    private fun calculate() {

        if(isValid()) {

            val distance = binding.editDistance.text.toString().toFloat()
            val price = binding.editPrice.text.toString().toFloat()
            val autonomy = binding.editAutonomy.text.toString().toFloat()

            val total = (distance * price) / autonomy

            //val totalStr = "R$ ${"%.2f".format(total)}"

            binding.textPrice.text = "R$ ${"%.2f".format(total)}"

            // Toast notification
            //Toast.makeText(this,totalStr,Toast.LENGTH_SHORT).show()
        } else Toast.makeText(this,R.string.invaliddata,Toast.LENGTH_SHORT).show()

    }

    private fun click(){
        Toast.makeText(this,R.string.clica,Toast.LENGTH_SHORT).show()
    }

}