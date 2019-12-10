package grishalarin.localdb

import grishalarin.localdb.repository.CurrencyRepository
import grishalarin.localdb.repository.RatesRepository
import grishalarin.localdb.repository.ValuteRepository
import ru.digipeople.database.DbTransaction

/**
 * @author Sostavkin Grisha
 */
interface LocalDbComponent {

    fun dbTransaction(): DbTransaction

    fun ratesRepository(): RatesRepository

    fun currencyRepository(): CurrencyRepository

    fun valuteRepository(): ValuteRepository

    companion object {
        private lateinit var instance: LocalDbComponent

        fun get(): LocalDbComponent = instance

        fun set(localDbComponent: LocalDbComponent) {
            instance = localDbComponent
        }
    }
}