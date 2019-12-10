package grishalarin.localdb.room.mapper

import grishalarin.localdb.model.Valute
import grishalarin.localdb.room.entity.ValuteEntity
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers
import ru.digipeople.database.room.mapper.BaseMapper

/**
 * @author Sostavkin Grisha
 */
@Mapper
interface ValuteMapper : BaseMapper<Valute, ValuteEntity> {
    companion object : ValuteMapper by INSTANCE
}

private val INSTANCE = Mappers.getMapper<ValuteMapper>(ValuteMapper::class.java)
