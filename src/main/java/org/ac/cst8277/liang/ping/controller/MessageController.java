package org.ac.cst8277.liang.ping.controller;

import org.ac.cst8277.liang.ping.entity.Message;
import org.ac.cst8277.liang.ping.exception.UnauthorizedException;
import org.ac.cst8277.liang.ping.service.MessageService;
import org.ac.cst8277.liang.ping.service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserManagementService userManagementService;

    @GetMapping
    public List<Message> getAllMessages(@RequestParam String token) {
        if (userManagementService.validateToken(token)) {
            return messageService.getAllMessages();
        }
        throw new UnauthorizedException();
    }

    @GetMapping("/user/{userId}")
    public List<Message> getMessagesByUser(@PathVariable Long userId, @RequestParam String token) {
        if (userManagementService.validateToken(token)) {
            return messageService.getMessagesByUser(userId);
        }
        throw new UnauthorizedException();
    }

    @PostMapping
    public Message addMessage(@RequestBody Message message, @RequestParam String token) {
        if (userManagementService.validateToken(token)) {
            return messageService.addMessage(message);
        }
        throw new UnauthorizedException();
    }
}
