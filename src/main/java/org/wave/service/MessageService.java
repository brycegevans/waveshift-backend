package org.wave.service;

import org.springframework.stereotype.Service;
import org.wave.model.Message;
import org.wave.repo.MessageRepository;
import org.wave.request.MessageRequestDTO;

import java.time.LocalDateTime;

@Service
public class MessageService {
    private MessageRepository mRepo;
    public MessageService(MessageRepository mRepo){this.mRepo = mRepo;}

    public Message createMessage(MessageRequestDTO request){
        Message newMessage = new Message();
        newMessage.setBody(request.getBody());
        newMessage.setSubject(request.getSubject());
        newMessage.setRecipientId(Long.parseLong(request.getRecipient()));
        newMessage.setEmail(request.getEmail());
        newMessage.setName(request.getName());
        newMessage.setNumber(request.getNumber());
        newMessage.setSentAt(LocalDateTime.now());
        return mRepo.save(newMessage);
    }
}
