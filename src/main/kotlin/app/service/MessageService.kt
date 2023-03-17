package app.service

import app.model.Message
import org.springframework.stereotype.Service
import org.springframework.jdbc.core.JdbcTemplate
import java.util.*

@Service
class MessageService(val db: JdbcTemplate) {

    fun findMessages(): List<Message> {
        return db.query("select * from messages") { response, _ ->
            Message(response.getString("id"), response.getString("text"))
        }
    }

    fun save(message: Message){
        val id = message.id ?: UUID.randomUUID().toString()
        db.update("insert into messages values ( ?, ? )",
                id, message.text)
    }
}
