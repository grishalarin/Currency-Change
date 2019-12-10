package grishalarin.localdb

import dagger.Binds
import dagger.Module
import grishalarin.localdb.repository.CurrencyRepository
import grishalarin.localdb.repository.RatesRepository
import grishalarin.localdb.repository.ValuteRepository
import grishalarin.localdb.room.repository.CurrencyRepositoryImpl
import grishalarin.localdb.room.repository.RatesRepositoryImpl
import grishalarin.localdb.room.repository.ValuteRepositoryImpl

/**
 * @author Sostavkin Grisha
 */
@Module
abstract class RepositoryModule {

    @Binds
    internal abstract fun ratesRepository(ratesRepository: RatesRepositoryImpl): RatesRepository

    @Binds
    internal abstract fun valuteRepository(valuteRepository: ValuteRepositoryImpl): ValuteRepository

    @Binds
    internal abstract fun currencyRepository(currency: CurrencyRepositoryImpl): CurrencyRepository
}