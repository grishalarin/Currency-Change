package grishalarin.localdb.room.repository

import grishalarin.localdb.AppDatabase
import grishalarin.localdb.model.Valute
import grishalarin.localdb.repository.ValuteRepository
import grishalarin.localdb.room.entity.ValuteEntity
import grishalarin.localdb.room.mapper.ValuteMapper
import ru.digipeople.database.room.repository.ModelRepositoryWithLongId
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Sostavkin Grisha
 */
@Singleton
class ValuteRepositoryImpl @Inject constructor(appDatabase: AppDatabase) :
    ModelRepositoryWithLongId<Valute, ValuteEntity>(appDatabase), ValuteRepository {

    override val mapper = ValuteMapper
    override val dao = appDatabase.valuteDao()
}