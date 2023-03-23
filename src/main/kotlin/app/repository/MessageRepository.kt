package app.repository

import app.model.Message
import org.springframework.data.repository.CrudRepository

interface MessageRepository : CrudRepository<Message, String>