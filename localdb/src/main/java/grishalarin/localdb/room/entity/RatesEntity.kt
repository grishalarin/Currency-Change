package grishalarin.localdb.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import grishalarin.localdb.room.converter.ValuteConverter
import ru.digipeople.database.room.entity.EntityWithId
import java.util.*

/**
 * @author Sostavkin Grisha
 */
@Entity(tableName = "Rates")
class RatesEntity : EntityWithId<Long> {
    /**
     * Id
     */
    @PrimaryKey(autoGenerate = true)
    override var id: Long = 0
    /**
     * Дата
     */
    var date: Long = 0

    /**
     * Предыдущая дата
     */
    var previousDate: Long = 0

    /**
     * Предыдущая дата
     */
    var previousUrl: String = ""

    /**
     * Отметка времени
     */
    var timestamp: Long = 0

    /**
     * Список валют
     */
    @TypeConverters(ValuteConverter::class)
    @ColumnInfo(name = "valute")
    var valute: ValuteEntity = ValuteEntity()
}