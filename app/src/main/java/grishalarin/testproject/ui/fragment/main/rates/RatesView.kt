package grishalarin.testproject.ui.fragment.main.rates

import grishalarin.localdb.model.ExchangeRate
import grishalarin.testproject.mvp.view.MvpView

/**
 * @author Sostavkin Grisha
 */
interface RatesView : MvpView {
    fun setLoading(loading: Boolean)
    fun setData(item: ExchangeRate)
    fun showError()
}