package com.example.motionlayoutplayground.signup

import android.animation.ValueAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.motionlayoutplayground.R
import com.example.motionlayoutplayground.databinding.FragmentSignUpBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SignUpFragment : Fragment() {

    private val viewModel: SignUpViewModel by viewModels()
    lateinit var binding: FragmentSignUpBinding

    private var currentProgress = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        binding.viewPager.adapter = SignUpViewPagerAdapter(this)
//        binding.viewPager.registerOnPageChangeCallback(binding.signUp.pageListener)
//        binding.viewPager.setPageTransformer(FadePageTransformer())
        childFragmentManager.beginTransaction()
            .replace(R.id.container, SignUp1Fragment::class.java, null)
            .commitNow()

        lifecycleScope.launch {
            delay(1000)
            ValueAnimator.ofFloat(0f, 0.1f).apply {
                addUpdateListener {
                    binding.signUp.progress = it.animatedValue as Float
                }
                start()
            }
        }
    }
}