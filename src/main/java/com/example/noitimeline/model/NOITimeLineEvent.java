package com.example.noitimeline.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "time-line-events")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
public class NOITimeLineEvent {

  @Id private String id;
  private String title;
  private String description;
  private LocalDate eventDate;

  public void setId(String id){
    this.id = id;
  }

  public String getId(){
    return id;
  }

  public String getTitle(){
    return title;
  }

  public void setTitle(String title){
    this.title = title;
  }

  public String getDescription(){
    return description;
  }

  public void setDescription(String description){
    this.description = description;
  }

  public LocalDate getEventDate(){
    return eventDate;
  }

  public void setEventDate(LocalDate eventDate){
    this.eventDate = eventDate;
  }
}
