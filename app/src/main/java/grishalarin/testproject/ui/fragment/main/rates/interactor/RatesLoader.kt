package grishalarin.testproject.ui.fragment.main.rates.interactor

import grishalarin.api.apiworker.ApiWorker
import grishalarin.api.exception.ApiException
import grishalarin.api.exception.UserError
import grishalarin.localdb.model.ExchangeRate
import grishalarin.localdb.repository.RatesRepository
import grishalarin.testproject.ui.fragment.main.rates.mapper.RatesMapper
import io.reactivex.Single
import javax.inject.Inject

/**
 * @author Sostavkin Grisha
 */
class RatesLoader @Inject constructor(
    private val apiWorker: ApiWorker,
    private val ratesMapper: RatesMapper,
    private val ratesRepository: RatesRepository
) {

    fun getExchangeRates(): Single<Result> {
        return apiWorker.getExchangeRates()
            .map { response ->
                Result(UserError.NO_ERROR, ratesMapper.resultsToRates(response.data!!))
            }
            .onErrorReturn { Result(UserError.ERROR, loadFromDb()[0]) }
            .doOnSuccess { storeRates(it.exchangeRate) }
    }

    fun getRatesFromDb(): Single<List<ExchangeRate>> {
        return Single.fromCallable { ratesRepository.getAll() }
    }

    private fun loadFromDb(): List<ExchangeRate> {
        return ratesRepository.getAll()
    }

    private fun storeRates(rate: ExchangeRate) {
        ratesRepository.deleteAll()
        ratesRepository.insert(rate)
    }

    data class Result(val userError: UserError, val exchangeRate: ExchangeRate) {
        val isSuccessful: Boolean
            get() = userError == UserError.NO_ERROR
    }

}