package grishalarin.testproject.ui.fragment.main.rates

import grishalarin.localdb.model.ExchangeRate
import grishalarin.testproject.mvp.viewstate.BaseMvpViewState
import javax.inject.Inject

/**
 * @author Sostavkin Grisha
 */
class RatesViewState @Inject constructor() : BaseMvpViewState<RatesView>(), RatesView {

    override fun onViewAttached(view: RatesView?) {}

    override fun onViewDetached(view: RatesView?) {}

    override fun setLoading(loading: Boolean) {
        forEachView { it.setLoading(loading) }
    }

    override fun setData(item: ExchangeRate) {
        forEachView { it.setData(item) }
    }

    override fun showError() {
        forEachView { it.showError() }
    }
}