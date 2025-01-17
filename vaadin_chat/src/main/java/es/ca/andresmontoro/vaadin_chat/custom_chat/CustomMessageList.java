package es.ca.andresmontoro.vaadin_chat.custom_chat;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class CustomMessageList extends VerticalLayout{
  private List<CustomMessageListItem> messages;

  public CustomMessageList() {
    this.messages = new ArrayList<>();
    setWidthFull();
  }

  public List<CustomMessageListItem> getMessages() {
    return messages;
  }

  public void addMessage(String message, String author, Instant timestamp) {
    CustomMessageListItem messageItem = new CustomMessageListItem(message, author, timestamp);
    messages.add(messageItem);
    add(messageItem);
  }
}
