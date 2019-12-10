package grishalarin.testproject.ui.fragment.main.rates.mapper

import grishalarin.api.model.ExchangeRateResponse
import grishalarin.localdb.model.Currency
import grishalarin.localdb.model.ExchangeRate
import grishalarin.localdb.model.Valute
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

/**
 * @author Sostavkin Grisha
 */
class RatesMapper @Inject constructor() {

    fun resultsToRates(exchangeRateResponse: ExchangeRateResponse): ExchangeRate {
        val item = Valute()
        val items = mutableListOf<Currency>().apply {
            add(valuteResponseToValute(exchangeRateResponse.valutes?.amd!!))
            add(valuteResponseToValute(exchangeRateResponse.valutes?._try!!))
            add(valuteResponseToValute(exchangeRateResponse.valutes?.aud!!))
            add(valuteResponseToValute(exchangeRateResponse.valutes?.azn!!))
            add(valuteResponseToValute(exchangeRateResponse.valutes?.bgn!!))
            add(valuteResponseToValute(exchangeRateResponse.valutes?.brl!!))
            add(valuteResponseToValute(exchangeRateResponse.valutes?.byn!!))
            add(valuteResponseToValute(exchangeRateResponse.valutes?.cad!!))
            add(valuteResponseToValute(exchangeRateResponse.valutes?.chf!!))
            add(valuteResponseToValute(exchangeRateResponse.valutes?.cny!!))
            add(valuteResponseToValute(exchangeRateResponse.valutes?.czk!!))
            add(valuteResponseToValute(exchangeRateResponse.valutes?.dkk!!))
            add(valuteResponseToValute(exchangeRateResponse.valutes?.eur!!))
            add(valuteResponseToValute(exchangeRateResponse.valutes?.gbp!!))
            add(valuteResponseToValute(exchangeRateResponse.valutes?.hkd!!))
            add(valuteResponseToValute(exchangeRateResponse.valutes?.huf!!))
            add(valuteResponseToValute(exchangeRateResponse.valutes?.inr!!))
            add(valuteResponseToValute(exchangeRateResponse.valutes?.jpy!!))
            add(valuteResponseToValute(exchangeRateResponse.valutes?.kgs!!))
            add(valuteResponseToValute(exchangeRateResponse.valutes?.krw!!))
            add(valuteResponseToValute(exchangeRateResponse.valutes?.kzt!!))
            add(valuteResponseToValute(exchangeRateResponse.valutes?.mdl!!))
            add(valuteResponseToValute(exchangeRateResponse.valutes?.nok!!))
            add(valuteResponseToValute(exchangeRateResponse.valutes?.pln!!))
            add(valuteResponseToValute(exchangeRateResponse.valutes?.ron!!))
            add(valuteResponseToValute(exchangeRateResponse.valutes?.sgd!!))
            add(valuteResponseToValute(exchangeRateResponse.valutes?.tjs!!))
            add(valuteResponseToValute(exchangeRateResponse.valutes?.tmt!!))
            add(valuteResponseToValute(exchangeRateResponse.valutes?.uah!!))
            add(valuteResponseToValute(exchangeRateResponse.valutes?.usd!!))
            add(valuteResponseToValute(exchangeRateResponse.valutes?.uzs!!))
            add(valuteResponseToValute(exchangeRateResponse.valutes?.xdr!!))
            add(valuteResponseToValute(exchangeRateResponse.valutes?.zar!!))
        }
        item.valutes = items
        return ExchangeRate().apply {
            date = convertStringToDate(exchangeRateResponse.date)
            previousDate = convertStringToDate(exchangeRateResponse.previousDate)
            previousUrl = exchangeRateResponse.previousUrl
            timestamp = convertStringToDate(exchangeRateResponse.timestamp)
            valute = item
        }
    }

    private fun valuteResponseToValute(currency: ExchangeRateResponse.CurrencyResponse)
            : Currency {
        val item = Currency()
        item.id = currency.numCode.toLong()
        item.charCode = currency.charCode
        item.name = currency.name
        item.nominal = currency.nominal
        item.idSymbols = currency.id
        item.previousValue = currency.previousValue
        item.value = currency.value
        return item
    }

    private fun convertStringToDate(date: String): Date {
        return SimpleDateFormat(DATE_FORMAT, Locale.getDefault()).parse(date)!!
    }

    companion object {
        private const val DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss"
    }

}