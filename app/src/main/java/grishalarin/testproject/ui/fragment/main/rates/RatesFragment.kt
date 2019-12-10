package grishalarin.testproject.ui.fragment.main.rates

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.android.material.snackbar.Snackbar
import grishalarin.localdb.model.ExchangeRate
import grishalarin.testproject.R
import grishalarin.testproject.ui.activity.main.MainActivity
import grishalarin.testproject.ui.fragment.base.MvpFragment
import grishalarin.testproject.ui.fragment.main.rates.adapter.CurrencyAdapter
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject


/**
 * @author Sostavkin Grisha
 */
class RatesFragment : MvpFragment(), RatesView {

    //region DI
    private lateinit var component: RatesComponent
    @Inject
    lateinit var adapter: CurrencyAdapter
    //endRegion
    //region View
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var recycler: RecyclerView
    private lateinit var summEdit: EditText
    private lateinit var date: TextView
    //endRegion
    // region Other
    private lateinit var presenter: RatesPresenter
    //endRegion

    override fun onCreate(savedInstanceState: Bundle?) {
        component = (activity as MainActivity).component().ratesComponent()
        component.inject(this)
        super.onCreate(savedInstanceState)

        presenter = mvpDelegate.getPresenter({ component.presenter() }, RatesPresenter::class.java)
        presenter.initialize()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_rate, container, false)

        swipeRefreshLayout = view.findViewById(R.id.swipe_refresh)
        recycler = view.findViewById(R.id.fragment_album_list_recycler)
        summEdit = view.findViewById(R.id.summ_edit)
        date = view.findViewById(R.id.rate_date)

        val linearLayoutManager = LinearLayoutManager(requireContext())
        recycler.layoutManager = linearLayoutManager
        recycler.adapter = adapter

        recycler.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                linearLayoutManager.orientation
            )
        )

        swipeRefreshLayout.setOnRefreshListener {
            presenter.swipeToRefresh()
        }

        summEdit.setOnEditorActionListener { v, actionId, event ->
            presenter.onChangeSumm(v.text.toString().toDouble())
            true
        }

        return view
    }

    override fun setData(item: ExchangeRate) {
        adapter.items = item.valute.valutes
        val dateFormat = SimpleDateFormat(DATE_FORMAT, Locale.getDefault())
        val timeFormat = SimpleDateFormat(TIME_FORMAT, Locale.getDefault())
        val modelDate = dateFormat.format(item.date)
        val modelTime = timeFormat.format(item.date)
        date.text = getString(
            R.string.rates_fragment_date,
            modelDate, modelTime
        )
    }

    override fun setLoading(loading: Boolean) {
        swipeRefreshLayout.isRefreshing = loading
    }

    override fun showError() {
        Snackbar.make(
            swipeRefreshLayout,
            getString(R.string.rates_fragment_error),
            Snackbar.LENGTH_LONG
        ).show()
    }

    fun component(): RatesComponent {
        return component
    }

    companion object {
        private const val DATE_FORMAT = "dd.MM.yyyy"
        private const val TIME_FORMAT = "HH:mm:ss"
        fun newInstance() = RatesFragment()
    }
}