package grishalarin.localdb

import androidx.room.Database
import androidx.room.RoomDatabase
import grishalarin.localdb.room.dao.CurrencyDao
import grishalarin.localdb.room.dao.RatesDao
import grishalarin.localdb.room.dao.ValuteDao
import grishalarin.localdb.room.entity.CurrencyEntity
import grishalarin.localdb.room.entity.RatesEntity
import grishalarin.localdb.room.entity.ValuteEntity

/**
 * @author Sostavkin Grisha
 */
@Database(version = BuildConfig.DB_VERSION, exportSchema = false, entities = [RatesEntity::class, ValuteEntity::class,CurrencyEntity::class])
abstract class AppDatabase : RoomDatabase() {

    abstract fun ratesDao(): RatesDao
    abstract fun currencyDao(): CurrencyDao
    abstract fun valuteDao(): ValuteDao
}
