package grishalarin.api.apiworker

import grishalarin.api.model.ExchangeRateResponse
import grishalarin.api.response.Response
import io.reactivex.Single

/**
 * @author Sostavkin Grisha
 */
interface ApiWorker {
    /**
     * Получает список курсов валют
     */
    fun getExchangeRates(): Single<Response<ExchangeRateResponse>>
}