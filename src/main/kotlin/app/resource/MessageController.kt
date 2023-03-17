package app.resource

import app.model.Message
import app.service.MessageService
import org.springframework.web.bind.annotation.*

@RestController
class MessageController(val service: MessageService) {
    @GetMapping("/")
    fun index(): List<Message> = service.findMessages()

    @PostMapping("/")
    fun post(@RequestBody message: Message) {
        service.save(message)
    }
}