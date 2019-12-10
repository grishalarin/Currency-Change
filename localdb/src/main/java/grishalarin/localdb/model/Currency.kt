package grishalarin.localdb.model

import ru.digipeople.database.model.ModelWithId
import java.math.BigDecimal

/**
 * @author Sostavkin Grisha
 */
class Currency : ModelWithId<Long> {
    /**
     * Цифровой код
     */
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
    /**
     * Сумма пользователя
     */
    var userValue: Double = 0.0
}