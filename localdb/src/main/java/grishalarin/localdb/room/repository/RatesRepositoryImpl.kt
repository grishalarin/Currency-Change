package grishalarin.localdb.room.repository

import grishalarin.localdb.AppDatabase
import grishalarin.localdb.model.ExchangeRate
import grishalarin.localdb.repository.RatesRepository
import grishalarin.localdb.room.entity.RatesEntity
import grishalarin.localdb.room.mapper.RatesMapper
import ru.digipeople.database.room.repository.ModelRepositoryWithLongId
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Sostavkin Grisha
 */
@Singleton
class RatesRepositoryImpl  @Inject constructor(appDatabase: AppDatabase) :
    ModelRepositoryWithLongId<ExchangeRate, RatesEntity>(appDatabase), RatesRepository {

    override val mapper = RatesMapper
    override val dao = appDatabase.ratesDao()
}