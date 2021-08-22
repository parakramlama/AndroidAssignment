package com.example.androidassignment.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidassignment.R
import com.example.androidassignment.adapter.ArticleAdapter
import com.example.androidassignment.db.ArticleDB
import com.example.androidassignment.repository.ArticleRepository

class ArticlesFragment : Fragment() {

    companion object {
        fun newInstance() = ArticlesFragment()
    }


    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ArticleAdapter

    private lateinit var viewModel: ArticlesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val articleDao = ArticleDB.getInstance(requireContext()).getArticleDAO()
        val repository = ArticleRepository(articleDao)
        val viewModelFactory = ArticleViewModelFactory(repository)
        articleViewModel = ViewModelProvider(this,viewModelFactory).get(ArticleViewModel::class.java)
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.articles_fragment, container, false)
        recyclerView = view.findViewById(R.id.articleRecycler)

        articleViewModel.getAllArticles()

        articleViewModel.text.observe(viewLifecycleOwner, Observer { lstArticles ->
            adapter.setList(lstArticles)
        })


        adapter = ArticleAdapter(requireContext())
        recyclerView.layoutManager= LinearLayoutManager(context)
        recyclerView.adapter=adapter
//        loadArticles()
        return view
    }

//    private fun loadArticles() {
//        CoroutineScope(Dispatchers.IO).launch {
//            try {
//                val articleRepository = ArticleRepository()
//                val response = articleRepository.getAllArticles()
//                if (response.success == true) {
//                    // Put all the student details in lstStudents
//                    val lstArticles = response.data
//                    withContext(Dispatchers.Main) {
//                        recyclerView.adapter =
//                                ArticleAdapter(lstArticles!!, requireContext())
//                        recyclerView.layoutManager = //GridLayoutManager
//                     LinearLayoutManager(context)
//                    }
//                }
//            } catch (ex: Exception) {
//                withContext(Dispatchers.Main) {
//                    Toast.makeText(
//                            context,"Error : ${ex.toString()}", Toast.LENGTH_SHORT
//                    ).show()
//                }
//            }
//        }
//    }
}




//    {
//        return inflater.inflate(R.layout.articles_fragment, container, false)
//    }
//
//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(ArticlesViewModel::class.java)
//        // TODO: Use the ViewModel
//    }
//
//}