package grishalarin.localdb.repository

import grishalarin.localdb.model.ExchangeRate
import ru.digipeople.database.repository.ModelRepository

/**
 * @author Sostavkin Grisha
 */
interface RatesRepository: ModelRepository<ExchangeRate, Long>