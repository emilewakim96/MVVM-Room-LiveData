package lb.test.userpostsapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_user_posts.*
import lb.test.userpostsapp.R
import lb.test.userpostsapp.adapter.UserPostsAdapter
import lb.test.userpostsapp.model.User
import lb.test.userpostsapp.viewmodel.UserPostsViewModel
import lb.test.userpostsapp.viewmodel.UserPostsViewModelFactory


class UserPostsFragment: Fragment() {

    var postsAdapter: UserPostsAdapter? = null
    private lateinit var viewModel: UserPostsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val model: UserPostsViewModel by viewModels(
            factoryProducer = { ->
                UserPostsViewModelFactory("1")
            }
        )
        viewModel = model
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_user_posts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        previous.setOnClickListener {
            findNavController().navigate(R.id.action_UserPostsFragment_to_HomeFragment)
        }

        posts_recycler_view.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        postsAdapter = UserPostsAdapter()
        posts_recycler_view.adapter = postsAdapter

        viewModel.userPosts.observe(viewLifecycleOwner) { posts ->
            postsAdapter?.posts = posts
        }
    }
}