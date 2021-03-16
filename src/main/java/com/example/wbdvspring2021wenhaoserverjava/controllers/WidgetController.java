package com.example.wbdvspring2021wenhaoserverjava.controllers;


import com.example.wbdvspring2021wenhaoserverjava.models.Widget;
import com.example.wbdvspring2021wenhaoserverjava.services.WidgetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class WidgetController {
  @Autowired
  WidgetService service;

  @PostMapping("api/topics/{tid}/widgets")
  Widget createWidget (
          @PathVariable("tid") String tid,
          @RequestBody Widget widget) {

    return service.createWidget(tid, widget);

  }
  @GetMapping("/api/topics/{tid}/widgets")
  List<Widget> findWidgetsForTopic(
          @PathVariable("tid") String tid) {

    return service.findWidgetsForTopic(tid);

  }
  @PutMapping("/api/widgets/{wid}")
  int updateWidget(
          @PathVariable("wid") String wid,
          @RequestBody Widget widget) {

    return service.updateWidget(wid, widget);
  }

  @DeleteMapping("/api/widgets/{wid}")
  int deleteWidget(
          @PathVariable("wid") String wid) {

    return service.deleteWidget(wid);
  }

  @GetMapping("/api/widgets")
  List<Widget> findAllWidgets() {

    return service.findAllWidgets();
  }

  @GetMapping("/api/widgets/{wid}")
  Widget findWidgetById(
          @PathVariable("wid") String wid) {

    return service.findWidgetById(wid);
  }

}