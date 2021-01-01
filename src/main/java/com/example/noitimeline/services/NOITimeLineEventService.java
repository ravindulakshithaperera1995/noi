package com.example.noitimeline.services;

import com.example.noitimeline.model.NOITimeLineEvent;
import com.example.noitimeline.persistence.NOITimeLineEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class NOITimeLineEventService {

  private NOITimeLineEventRepository noiTimeLineEventRepository;

  @Autowired
  public NOITimeLineEventService(final NOITimeLineEventRepository noiTimeLineEventRepository){
    this.noiTimeLineEventRepository = noiTimeLineEventRepository;
  }

  public Page<NOITimeLineEvent> getAllEvents(Pageable pageable){
    return noiTimeLineEventRepository.findAll(pageable);
  }

  public NOITimeLineEvent findById(final String id){
    Optional<NOITimeLineEvent> optionalNOITimeLineEvent = noiTimeLineEventRepository.findById(id);
    return optionalNOITimeLineEvent.orElse(null);
  }

  public void createNewTimeLineEvent(NOITimeLineEvent noiTimeLineEvent){
    String id = UUID.randomUUID().toString();
    noiTimeLineEvent.setId(id);
    noiTimeLineEventRepository.save(noiTimeLineEvent);
  }

  public void updateTimeLineEvent(final String id, final NOITimeLineEvent noiTimeLineEvent){
    if(id != noiTimeLineEvent.getId()){
      System.out.println("Ids does not match!");
    }

    NOITimeLineEvent createdEvent = findById(id);
    createdEvent.setTitle(noiTimeLineEvent.getTitle());
    createdEvent.setDescription(noiTimeLineEvent.getDescription());
    createdEvent.setEventDate(noiTimeLineEvent.getEventDate());

    noiTimeLineEventRepository.save(createdEvent);
  }

  public void deleteTimeLineEvent(final String id){
    noiTimeLineEventRepository.deleteById(id);
  }
}
