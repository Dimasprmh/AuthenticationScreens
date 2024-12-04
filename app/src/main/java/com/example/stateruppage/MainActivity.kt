package com.example.stateruppage

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.stateruppage.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
  
  private lateinit var binding: ActivityMainBinding
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)
    
    playAnimation()
    transparentStatusBar()
    
    binding.button.setOnClickListener {
      val intent  = Intent(this, LoginActivity::class.java)
      startActivity(intent)
    }
    
  }
  
  private fun playAnimation() {
    ObjectAnimator.ofFloat(binding.fruitBackground, View.ROTATION, 0f, -360f).apply {
      duration = 90000 // 90 seconds full rotation
      repeatCount = ObjectAnimator.INFINITE
      repeatMode = ObjectAnimator.RESTART
    }.start()
  }
  
  private fun transparentStatusBar(){
    
    window.apply {
      decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
      statusBarColor = android.graphics.Color.TRANSPARENT
    }
    
  }
}