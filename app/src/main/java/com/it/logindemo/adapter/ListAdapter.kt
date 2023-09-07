import android.text.TextUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.it.logindemo.R
import com.it.logindemo.databinding.ItemListDataBinding

class MainAdapter : RecyclerView.Adapter<MainViewHolder>() {
    var list = mutableListOf<RowData>()
    fun setMovieList(list: List<RowData>) {
        this.list = list.toMutableList()
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = ItemListDataBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val movie = list[position]
        if (!TextUtils.isEmpty(movie.title)) {
            holder.binding.tvTitle.text = movie.title

        } else {
            holder.binding.tvTitle.text = "N/A"
        }
        if (!TextUtils.isEmpty(movie.description)) {
            holder.binding.tvDesc.text = movie.description
        } else {
            holder.binding.tvDesc.text = "N/A"
        }

        Glide.with(holder.itemView.context).load(movie.imageHref)
            .placeholder(R.drawable.placeholder)
            .into(holder.binding.ivImage)

    }

    override fun getItemCount(): Int {
        return list.size
    }
}

class MainViewHolder(val binding: ItemListDataBinding) : RecyclerView.ViewHolder(binding.root) {

}