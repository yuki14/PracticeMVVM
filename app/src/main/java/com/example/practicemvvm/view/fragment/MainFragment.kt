package com.example.practicemvvm.view.fragment

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.practicemvvm.MyApplication
import com.example.practicemvvm.R
import com.example.practicemvvm.data.VocabularyData
import com.example.practicemvvm.databinding.FragmentMainBinding
import com.example.practicemvvm.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_main.*
import org.koin.android.viewmodel.ext.android.sharedViewModel
import kotlin.random.Random


class MainFragment : Fragment() {
    private val viewModel: MainViewModel by sharedViewModel()
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        val view = binding.root
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.apply {
            viewmodel = viewModel
            setLifecycleOwner(activity)
        }

        viewModel.initParameter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        var current: VocabularyData

        btn_habitual_saying.setOnClickListener {
            do {
                current = MyApplication.vocabularyList[Random.nextInt(3)]
            } while (current.vocabulary.equals(viewModel.vocabulary.value))

            viewModel.setVocabulary(current)
        }
    }
}
