package grishalarin.localdb.model

import ru.digipeople.database.model.ModelWithId
import java.util.Date

/**
 * @author Sostavkin Grisha
 */
class ExchangeRate : ModelWithId<Long> {
    /**
     * Id коллекции
     */
    override var id: Long = 0
    /**
     * Дата
     */
    var date: Date = Date()

    /**
     * Предыдущая дата
     */
    var previousDate: Date = Date()

    /**
     * Предыдущая дата
     */
    var previousUrl: String = ""

    /**
     * Отметка времени
     */
    var timestamp: Date = Date()

    /**
     * Список валют
     */
    var valute: Valute = Valute()
}