package com.thoughtworks.capability.gtb.controller;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.thoughtworks.capability.gtb.vo.EventType;
import com.thoughtworks.capability.gtb.vo.EventVo;
import com.thoughtworks.capability.gtb.vo.UserVo;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author itutry
 * @create 2020-05-21_16:29
 */
@RestController
@Slf4j
public class EventController {
  private final ObjectMapper objectMapper;

  @Autowired
  public EventController(ObjectMapper objectMapper) {
    this.objectMapper = objectMapper;
  }

  @GetMapping("/events/{id}")
  public EventVo getEventById(@PathVariable("id") String id) throws JsonProcessingException {
    UserVo user = new UserVo("3", "张三");
    EventVo eventVo = new EventVo(id, "下载文件", EventType.DOWNLOAD, LocalDateTime.now(), user);
    String json = objectMapper.writeValueAsString(eventVo);
    System.out.println(eventVo);
    return eventVo;
  }

  @PostMapping("/events")
  public void createEvent(@RequestBody EventVo event) {

    log.info("create event: {}", event);
//    EventVo eventVo = objectMapper.readValue(json, EventVo.class);
//    System.out.println(eventVo);
  }


}
