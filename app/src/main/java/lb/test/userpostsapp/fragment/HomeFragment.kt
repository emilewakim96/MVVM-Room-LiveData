package lb.test.userpostsapp.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_home.*
import lb.test.userpostsapp.R
import lb.test.userpostsapp.viewmodel.HomeViewModel
import org.koin.android.ext.android.inject

class HomeFragment : Fragment() {

  private val homeViewModel by inject<HomeViewModel>()

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.fragment_home, container, false)
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    // This callback will only be called when fragment is at least Started.
    val callback = object : OnBackPressedCallback(true /* enabled by default */) {
      override fun handleOnBackPressed() {
        // Handle the back button event
        sendAppToBackground()
      }
    }
    requireActivity().onBackPressedDispatcher.addCallback(this, callback)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    load_user_posts.setOnClickListener {
      findNavController().navigate(R.id.action_HomeFragment_to_UserPostsFragment)
    }
  }

  private fun sendAppToBackground() {
    val background = Intent()
    background.action = Intent.ACTION_MAIN
    background.addCategory(Intent.CATEGORY_HOME)
    startActivity(background)
  }
}