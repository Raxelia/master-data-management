package com.mentoring.mdm.controller;

import com.mentoring.mdm.utilites.LiveOfferSession;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@Profile("!test")
public class LiveOfferController {

  @Autowired private LiveOfferSession liveOfferSession;

  @MessageMapping("/product-live-offers")
  @SendTo("/topic/live-offers")
  public List<String> sendLiveOffer(@RequestBody String offer) {
    liveOfferSession.addLiveOffer(offer);
    return liveOfferSession.getLiveOffers();
  }
}
