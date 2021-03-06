package lb.test.userpostsapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_dashboard.*
import lb.test.userpostsapp.R
import lb.test.userpostsapp.viewmodel.DashboardViewModel

class DashboardFragment : Fragment() {

  private lateinit var dashboardViewModel: DashboardViewModel

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    dashboardViewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)
    val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
    dashboardViewModel.text.observe(viewLifecycleOwner, {
      text_dashboard.text = it
    })
    return root
  }
}