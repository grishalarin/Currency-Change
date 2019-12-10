package grishalarin.api.apiworker

import grishalarin.api.Api
import grishalarin.api.model.ExchangeRateResponse
import grishalarin.api.response.Response
import grishalarin.api.response.ResponseConverter
import io.reactivex.Single

/**
 * @author Sostavkin Grisha
 */
class DefaultApiWorker(
    private val api: Api,
    private val responseConverter: ResponseConverter
) : ApiWorker {

    override fun getExchangeRates(): Single<Response<ExchangeRateResponse>> {
        return api.getCurrency()
            .map { response -> responseConverter.convert(response) }
    }
}