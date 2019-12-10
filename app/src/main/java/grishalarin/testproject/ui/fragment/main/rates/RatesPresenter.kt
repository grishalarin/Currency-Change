package grishalarin.testproject.ui.fragment.main.rates

import grishalarin.api.exception.UserError
import grishalarin.localdb.model.ExchangeRate
import grishalarin.testproject.mvp.presenter.BaseMvpViewStatePresenter
import grishalarin.testproject.ui.fragment.main.rates.interactor.RatesLoader
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.disposables.Disposables
import io.reactivex.schedulers.Schedulers
import ru.digipeople.logger.LoggerFactory
import java.math.BigDecimal
import javax.inject.Inject

/**
 * @author Sostavkin Grisha
 */
class RatesPresenter @Inject constructor(
    viewState: RatesViewState,
    private val ratesLoader: RatesLoader
) : BaseMvpViewStatePresenter<RatesView, RatesViewState>(viewState) {

    private var disposableLoader: Disposable = Disposables.disposed()
    private val logger = LoggerFactory.getLogger(RatesPresenter::class)
    private var exchangeRate: ExchangeRate? = null

    override fun onInitialize() {
        loadData()
    }

    override fun destroy() {
        super.destroy()
        disposableLoader.dispose()
    }

    fun swipeToRefresh() {
        loadData()
        view.setLoading(false)
    }

    fun onChangeSumm(summ: Double){
        recountData(summ)
    }

    private fun loadData() {
        disposableLoader.dispose()
        disposableLoader = ratesLoader.getExchangeRates()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result ->
                if (result.userError == UserError.ERROR){
                    loadFromDb()
                    view.showError()
                }else{
                    exchangeRate = result.exchangeRate
                    view.setData(result.exchangeRate)
                }
            }, {
                logger.error(it)
            })
    }

    private fun loadFromDb() {
        disposableLoader.dispose()
        disposableLoader = ratesLoader.getRatesFromDb()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ rates ->
                view.setData(rates[0])
            }, {
                logger.error(it)
            })
    }

    private fun recountData(summ: Double){
        exchangeRate.let { exchangeRate ->
            exchangeRate?.valute?.valutes?.forEach {currency->
                currency.userValue = summ/currency.value*currency.nominal
            }
            view.setData(exchangeRate!!)
        }
    }
}