package grishalarin.localdb.room.mapper

import grishalarin.localdb.model.Currency
import grishalarin.localdb.room.entity.CurrencyEntity
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers
import ru.digipeople.database.room.mapper.BaseMapper

/**
 * @author Sostavkin Grisha
 */
@Mapper(uses = [DateMapper::class])
interface CurrencyMapper : BaseMapper<Currency, CurrencyEntity> {
    companion object : CurrencyMapper by INSTANCE
}

private val INSTANCE = Mappers.getMapper<CurrencyMapper>(CurrencyMapper::class.java)
