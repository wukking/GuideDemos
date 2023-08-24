package com.wuyson.guidedemos.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.wuyson.guidedemos.viewmodel.CustomFactory

class HomeFragment : Fragment() {

    val mainViewModel by activityViewModels<MainViewModel> { CustomFactory() }
}