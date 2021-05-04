package lb.test.userpostsapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import lb.test.userpostsapp.R
import lb.test.userpostsapp.model.Post
import lb.test.userpostsapp.model.User
import lb.test.userpostsapp.viewholder.UserPostsViewHolder
import java.lang.reflect.Array.set

class UserPostsAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var posts: List<Post> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_post, parent, false)
        return UserPostsViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = posts[position]
        if (holder is UserPostsViewHolder) {
            holder.bind(item, position)
        }
    }

    override fun getItemCount(): Int = posts.count()
}