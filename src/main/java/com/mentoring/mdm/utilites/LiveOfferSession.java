package com.mentoring.mdm.utilites;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/*
   Websocket: Session Isolated Live Offer
   We need private state just for this WebSocket connection. Once they disconnect, it’s done and not needed.
*/
@Getter
@Component
@Scope("websocket")
public class LiveOfferSession {

  private final List<String> liveOffers = new ArrayList<>();

  public void addLiveOffer(String offer) {
    liveOffers.add(offer);
  }
}
