package grishalarin.localdb.room.dao

import androidx.room.Dao
import grishalarin.localdb.model.Valute
import grishalarin.localdb.room.entity.ValuteEntity
import ru.digipeople.database.room.dao.BaseDao

/**
 * @author Sostavkin Grisha
 */
@Dao
interface ValuteDao: BaseDao<ValuteEntity>