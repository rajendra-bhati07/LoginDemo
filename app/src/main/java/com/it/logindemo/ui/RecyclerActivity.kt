package com.it.logindemo.ui
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.it.logindemo.R
import com.it.logindemo.adapter.RecyclerDataAdapter
import com.it.logindemo.databinding.ActivityRecyclerBinding
import com.it.logindemo.data.viewmodel.ItemsViewModel
class RecyclerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecyclerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Creates a vertical layout Manager
        binding.recyclerview.layoutManager = LinearLayoutManager(this)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<ItemsViewModel>()

        data.add(
            ItemsViewModel(
                R.drawable.ic_card,
                "Beavers",
                resources.getString(R.string.description_one)
            )
        )
        data.add(
            ItemsViewModel(
                R.drawable.ic_gallery,
                "Transportation",
                resources.getString(R.string.description_two)
            )
        )
        data.add(
            ItemsViewModel(
                R.drawable.ic_card,
                "Hockey Night in Canada",
                resources.getString(R.string.description_three)
            )
        )
        data.add(
            ItemsViewModel(
                R.drawable.ic_gallery,
                "Mounties",
                resources.getString(R.string.description_four)
            )
        )
        data.add(
            ItemsViewModel(
                R.drawable.ic_card,
                "Meese",
                resources.getString(R.string.description_five)
            )
        )

        data.add(
            ItemsViewModel(
                R.drawable.ic_gallery,
                "Beavers",
                resources.getString(R.string.description_one)
            )
        )
        data.add(
            ItemsViewModel(
                R.drawable.ic_card,
                "Transportation",
                resources.getString(R.string.description_two)
            )
        )
        data.add(
            ItemsViewModel(
                R.drawable.ic_gallery,
                "Hockey Night in Canada",
                resources.getString(R.string.description_three)
            )
        )
        data.add(
            ItemsViewModel(
                R.drawable.ic_card,
                "Mounties",
                resources.getString(R.string.description_four)
            )
        )
        data.add(
            ItemsViewModel(
                R.drawable.ic_gallery,
                "Meese",
                resources.getString(R.string.description_five)
            )
        )

        // Pass the ArrayList to Adapter
        val adapter = RecyclerDataAdapter(data)
        // Setting the Adapter with the recyclerview
        binding.recyclerview.adapter = adapter

    }


}
