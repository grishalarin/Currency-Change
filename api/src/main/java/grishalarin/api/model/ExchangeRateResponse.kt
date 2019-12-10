package grishalarin.api.model

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal
import java.util.*

/**
 * @author Sostavkin Grisha
 *
 * Модель Api поискового запроса по курсам валют
 */
class ExchangeRateResponse {
    /**
     * Дата
     */
    @SerializedName("Date")
    var date: String = ""

    /**
     * Предыдущая дата
     */
    @SerializedName("PreviousDate")
    var previousDate: String = ""

    /**
     * Предыдущая дата
     */
    @SerializedName("PreviousURL")
    var previousUrl: String = ""

    /**
     * Отметка времени
     */
    @SerializedName("Timestamp")
    var timestamp: String = ""

    /**
     * Список валют
     */
    @SerializedName("Valute")
    var valutes: ValuteResponse? = null

    data class ValuteResponse(
        /**
         * Австралийский доллар
         */
        @SerializedName("AUD")
        var aud: CurrencyResponse? = null,
        /**
         * Азербайджанский манат
         */
        @SerializedName("AZN")
        var azn: CurrencyResponse? = null,
        /**
         * Фунт стерлингов Соединенного королевства
         */
        @SerializedName("GBP")
        var gbp: CurrencyResponse? = null,
        /**
         * Армянских драмов
         */
        @SerializedName("AMD")
        var amd: CurrencyResponse? = null,
        /**
         * Белорусский рубль
         */
        @SerializedName("BYN")
        var byn: CurrencyResponse? = null,
        /**
         * Болгарский лев
         */
        @SerializedName("BGN")
        var bgn: CurrencyResponse? = null,
        /**
         * Бразильский реал
         */
        @SerializedName("BRL")
        var brl: CurrencyResponse? = null,
        /**
         * Венгерских форинтов
         */
        @SerializedName("HUF")
        var huf: CurrencyResponse? = null,
        /**
         * Гонконгских долларов
         */
        @SerializedName("HKD")
        var hkd: CurrencyResponse? = null,
        /**
         * Датских крон
         */
        @SerializedName("DKK")
        var dkk: CurrencyResponse? = null,
        /**
         * Доллар США
         */
        @SerializedName("USD")
        var usd: CurrencyResponse? = null,
        /**
         * Евро
         */
        @SerializedName("EUR")
        var eur: CurrencyResponse? = null,
        /**
         * Индийских рупий
         */
        @SerializedName("INR")
        var inr: CurrencyResponse? = null,
        /**
         * Казахстанских тенге
         */
        @SerializedName("KZT")
        var kzt: CurrencyResponse? = null,
        /**
         * Канадский доллар
         */
        @SerializedName("CAD")
        var cad: CurrencyResponse? = null,
        /**
         * Киргизских сомов
         */
        @SerializedName("KGS")
        var kgs: CurrencyResponse? = null,
        /**
         * Китайских юаней
         */
        @SerializedName("CNY")
        var cny: CurrencyResponse? = null,
        /**
         * Молдавских леев
         */
        @SerializedName("MDL")
        var mdl: CurrencyResponse? = null,
        /**
         * Норвежских крон
         */
        @SerializedName("NOK")
        var nok: CurrencyResponse? = null,
        /**
         * Польский злотый
         */
        @SerializedName("PLN")
        var pln: CurrencyResponse? = null,
        /**
         * Румынский лей
         */
        @SerializedName("RON")
        var ron: CurrencyResponse? = null,
        /**
         * СДР (специальные права заимствования)
         */
        @SerializedName("XDR")
        var xdr: CurrencyResponse? = null,
        /**
         * Сингапурский доллар
         */
        @SerializedName("SGD")
        var sgd: CurrencyResponse? = null,
        /**
         * Таджикских сомони
         */
        @SerializedName("TJS")
        var tjs: CurrencyResponse? = null,
        /**
         * Турецкая лира
         */
        @SerializedName("TRY")
        var _try: CurrencyResponse? = null,
        /**
         * Новый туркменский манат
         */
        @SerializedName("TMT")
        var tmt: CurrencyResponse? = null,
        /**
         * Узбекских сумов
         */
        @SerializedName("UZS")
        var uzs: CurrencyResponse? = null,
        /**
         * Украинских гривен
         */
        @SerializedName("UAH")
        var uah: CurrencyResponse? = null,
        /**
         * Чешских крон
         */
        @SerializedName("CZK")
        var czk: CurrencyResponse? = null,
        /**
         * Шведских крон
         */
        @SerializedName("CHF")
        var chf: CurrencyResponse? = null,
        /**
         * Швейцарский франк
         */
        @SerializedName("ZAR")
        var zar: CurrencyResponse? = null,
        /**
         * Вон Республики Корея
         */
        @SerializedName("KRW")
        var krw: CurrencyResponse? = null,
        /**
         * Японских иен
         */
        @SerializedName("JPY")
        var jpy: CurrencyResponse? = null
    )

    /**
     * Модель валюты
     */
    data class CurrencyResponse(
        /**
         * Id валюты
         */
        @SerializedName("ID")
        var id: String = "",

        /**
         * Цифровой код
         */
        @SerializedName("NumCode")
        var numCode: Int = 0,
        /**
         * Символьный код
         */
        @SerializedName("CharCode")
        var charCode: String = "",
        /**
         * Номинал
         */
        @SerializedName("Nominal")
        var nominal: Int = 0,
        /**
         * Название валюты
         */
        @SerializedName("Name")
        var name: String = "",
        /**
         * Значение
         */
        @SerializedName("Value")
        var value: Double = 0.0,
        /**
         * Предыдущее значение
         */
        @SerializedName("Previous")
        var previousValue: Double = 0.0
    )
}
