package com.example.androidassignment.fragments

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidassignment.CartActivity
import com.example.androidassignment.R
import com.example.androidassignment.adapter.ProductAdapter
import com.example.androidassignment.db.ProductDB
import com.example.androidassignment.repository.ProductRepository

class ProductsFragment : Fragment() {

    companion object {
        fun newInstance() = ProductsFragment()
    }

    private lateinit var viewModel: ProductViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ProductAdapter
    private lateinit var btnCart: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val productDao = ProductDB.getInstance(requireContext()).getProductDAO()
        val repository = ProductRepository(productDao)
        val viewModelFactory = ProductViewModelFactory(repository)
        productViewModel = ViewModelProvider(this,viewModelFactory).get(ProductViewModel::class.java)

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.products_fragment, container, false)
        recyclerView = view.findViewById(R.id.productRecycler)
        btnCart = view.findViewById(R.id.btnCart)

        productViewModel.getAllProducts()

        productViewModel.text.observe(viewLifecycleOwner, Observer { lstProducts ->
            adapter.setList(lstProducts)
        })


        adapter = ProductAdapter(requireContext())
        recyclerView.layoutManager= LinearLayoutManager(context)
        recyclerView.adapter=adapter

        btnCart.setOnClickListener{
            startActivity(
                Intent(
                    context,
                    CartActivity::class.java
                )
            )
        }

//        loadProducts()
        return view
    }

//    private fun loadProducts() {
//        CoroutineScope(Dispatchers.IO).launch {
//            try {
//                val productRepository = ProductRepository()
//                val response = productRepository.getAllProducts()
//                if (response.success == true) {
//                    val lstProducts = response.data
//                    withContext(Dispatchers.Main) {
//                        adapter =
//                                ProductAdapter(lstProducts!!, requireContext())
//                        recyclerView.layoutManager = LinearLayoutManager(context)
//                        recyclerView.adapter = adapter
//                    }
//                }
//            } catch (ex: Exception) {
//                withContext(Dispatchers.Main) {
//                    Toast.makeText(
//                            context,
//                            "Error : ${ex.toString()}", Toast.LENGTH_SHORT
//                    ).show()
//                }
//            }
//        }
//    }
}
//        return inflater.inflate(R.layout.products_fragment, container, false)


//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(ProductsViewModel::class.java)
//        // TODO: Use the ViewModel
//    }
//
//}