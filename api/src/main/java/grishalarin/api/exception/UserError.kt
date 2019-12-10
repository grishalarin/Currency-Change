package grishalarin.api.exception

interface UserError {
    /**
     * Текст сообщения
     */
    val message: String

    companion object {
        val NO_ERROR: UserError = object : UserError {
            override val message = ""
        }
        val ERROR: UserError = object : UserError {
            override val message = ""
        }
    }
}