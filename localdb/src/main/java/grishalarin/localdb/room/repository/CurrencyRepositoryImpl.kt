package grishalarin.localdb.room.repository

import grishalarin.localdb.AppDatabase
import grishalarin.localdb.model.Currency
import grishalarin.localdb.repository.CurrencyRepository
import grishalarin.localdb.room.entity.CurrencyEntity
import grishalarin.localdb.room.mapper.CurrencyMapper
import ru.digipeople.database.room.repository.ModelRepositoryWithLongId
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Sostavkin Grisha
 */
@Singleton
class CurrencyRepositoryImpl @Inject constructor(appDatabase: AppDatabase) :
    ModelRepositoryWithLongId<Currency, CurrencyEntity>(appDatabase), CurrencyRepository {

    override val mapper = CurrencyMapper
    override val dao = appDatabase.currencyDao()
}