package com.example.noitimeline.resources;

import com.example.noitimeline.model.NOITimeLineEvent;
import com.example.noitimeline.services.NOITimeLineEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/acm/time-line-event")
public class NOITimeLineEventResource {

  private NOITimeLineEventService noiTimeLineEventService;

  @Autowired
  public NOITimeLineEventResource(NOITimeLineEventService noiTimeLineEventService){
    this.noiTimeLineEventService = noiTimeLineEventService;
  }

  @GetMapping
  public Page<NOITimeLineEvent> getAllEvents(Pageable pageable){
    return noiTimeLineEventService.getAllEvents(pageable);
  }

  @GetMapping("/{id}")
  public NOITimeLineEvent getSpecificEvent(@PathVariable String id){
    return noiTimeLineEventService.findById(id);
  }

  @PostMapping
  public void createEvent(@RequestBody NOITimeLineEvent noiTimeLineEvent){
    noiTimeLineEventService.createNewTimeLineEvent(noiTimeLineEvent);
  }

  @PutMapping("/{id}")
  public void updateEvent(@PathVariable String id, @RequestBody NOITimeLineEvent noiTimeLineEvent){
    noiTimeLineEventService.updateTimeLineEvent(id, noiTimeLineEvent);
  }

  @DeleteMapping("/{id}")
  public void deleteEvent(@PathVariable String id){
    noiTimeLineEventService.deleteTimeLineEvent(id);
  }
}
