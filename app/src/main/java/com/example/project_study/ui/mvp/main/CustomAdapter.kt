import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.project_study.R
import com.example.project_study.data.objects.Recipe
import com.example.project_study.data.objects.RecipeItem
import com.example.project_study.ui.mvp.details.MvpDetailsActivity
import com.squareup.picasso.Picasso


class CustomAdapter(private val list: List<RecipeItem>, private val onClick: (String) -> Unit) :
        RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
                R.layout.item_list, parent, false
        )
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.text.text = list[position].name
        Picasso.get().load(list[position].images[0]).into(holder.img);
        holder.itemLayout.setOnClickListener {
            onClick.invoke(list[position].uuid)
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val text = view.findViewById<TextView>(R.id.recipe_text)
        var img=view.findViewById<ImageView>(R.id.ItemListImg)
        val itemLayout = view.findViewById<ConstraintLayout>(R.id.itemLayout)
    }

}
