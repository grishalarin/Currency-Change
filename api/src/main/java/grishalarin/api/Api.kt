package grishalarin.api

import grishalarin.api.model.ExchangeRateResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET

/**
 * @author Sostavkin Grisha
 */
interface Api {
    /**
     * Получает список альбомов
     *
     * @param searchText текст для поискового запроса
     * @param country страна поиска
     * @param media тип мультимедиа
     * @param entity сущность мультимедиа, например: Альбом, Трек
     */
    @GET("daily_json.js")
    fun getCurrency(): Single<Response<ExchangeRateResponse>>
}