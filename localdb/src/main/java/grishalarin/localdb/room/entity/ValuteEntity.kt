package grishalarin.localdb.room.entity

import androidx.room.*
import grishalarin.localdb.room.converter.DataConverter
import ru.digipeople.database.room.entity.EntityWithId


/**
 * @author Sostavkin Grisha
 */
@Entity(
    tableName = "Valute", foreignKeys = [ForeignKey(
        entity = RatesEntity::class,
        parentColumns = ["id"],
        childColumns = ["id"],
        onDelete = ForeignKey.CASCADE
    )],
    indices = [Index("id")]
)
class ValuteEntity : EntityWithId<Long> {
    @PrimaryKey(autoGenerate = false)
    override var id: Long = 0
    /**
     * Валюта
     */
    @TypeConverters(DataConverter::class)
    @ColumnInfo(name = "valutes")
    var valutes: List<CurrencyEntity> = emptyList()
}