package grishalarin.localdb.room.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import ru.digipeople.database.model.ModelWithId
import ru.digipeople.database.room.entity.EntityWithId
import java.math.BigDecimal

/**
 * @author Sostavkin Grisha
 */
@Entity(tableName = "Currency",foreignKeys = [ForeignKey(
    entity = ValuteEntity::class,
    parentColumns = ["id"],
    childColumns = ["id"],
    onDelete = ForeignKey.CASCADE)],
    indices = [Index("id")])
class CurrencyEntity: EntityWithId<Long> {
    /**
     * Цифровой код
     */
    @PrimaryKey(autoGenerate = false)
    override var id: Long = 0
    /**
     * Символьный Id
     */
    var idSymbols: String = ""
    /**
     * Символьный код
     */
    var charCode: String = ""
    /**
     * Номинал
     */
    var nominal: Int = 0
    /**
     * Название валюты
     */
    var name: String = ""
    /**
     * Значение
     */
    var value: Double = 0.0
    /**
     * Предыдущее значение
     */
    var previousValue: Double = 0.0
}