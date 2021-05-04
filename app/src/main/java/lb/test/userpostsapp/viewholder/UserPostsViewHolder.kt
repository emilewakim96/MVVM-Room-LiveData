package lb.test.userpostsapp.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import lb.test.userpostsapp.R
import lb.test.userpostsapp.model.Post

class UserPostsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private val postTitle = itemView.findViewById<TextView>(R.id.post_title);
    private val postDescription = itemView.findViewById<TextView>(R.id.post_description);

    fun bind(post: Post, position: Int) {
        postTitle.text = post.title
        postDescription.text = post.description
    }

}