package grishalarin.localdb.room.mapper

import grishalarin.localdb.model.ExchangeRate
import grishalarin.localdb.room.entity.RatesEntity
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers
import ru.digipeople.database.room.mapper.BaseMapper

/**
 * @author Sostavkin Grisha
 */
@Mapper(uses = [DateMapper::class])
interface RatesMapper : BaseMapper<ExchangeRate, RatesEntity> {
    companion object : RatesMapper by INSTANCE
}

private val INSTANCE = Mappers.getMapper<RatesMapper>(RatesMapper::class.java)
