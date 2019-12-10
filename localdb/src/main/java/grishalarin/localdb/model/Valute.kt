package grishalarin.localdb.model

import ru.digipeople.database.model.ModelWithId

/**
 * @author Sostavkin Grisha
 */
class Valute: ModelWithId<Long> {
    /**
     * Id
     */
    override var id: Long = 0
    /**
     * Валюта
     */
    var valutes: List<Currency> = emptyList()
}