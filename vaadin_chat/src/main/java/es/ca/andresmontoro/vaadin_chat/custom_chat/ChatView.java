package es.ca.andresmontoro.vaadin_chat.custom_chat;

import java.time.Instant;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.messages.MessageInput;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import es.ca.andresmontoro.vaadin_chat.information_finder.InformationFinderApiCalls;

@Route("")
@CssImport("./styles/styles.css")
public class ChatView extends VerticalLayout {
  private CustomMessageList chat;
  private MessageInput input;
  private final InformationFinderApiCalls informationFinderApiCalls;
  private static final String AI_NAME = "Cofrade GPT";

  public ChatView(InformationFinderApiCalls informationFinderApiCalls) {
    createChatAndInput();
    this.informationFinderApiCalls = informationFinderApiCalls;
  }

  private void createChatAndInput() {
    chat = new CustomMessageList();
    input = new MessageInput();
    add(chat, input);
    setChatInputProperties();
  }

  private void setChatInputProperties() {
    setHorizontalComponentAlignment(Alignment.CENTER, chat, input);
    setPadding(true); // Leave some white space
    setHeightFull(); // We maximize to window
    setJustifyContentMode(JustifyContentMode.CENTER);
    chat.setSizeFull(); // Chat takes most of the space
    input.setWidthFull(); // Full width only
    chat.setMaxWidth("95%");
    input.setMaxWidth("95%"); // Until to certain size
    chat.getStyle().set("overflow-x", "hidden"); // No scrollbars

    input.addSubmitListener(this::handleMessageSubmit);
  }

  private void handleMessageSubmit(MessageInput.SubmitEvent event) {
    addMessageToChat(event.getValue(), "Tú");

    try {
      String responseFromAi = informationFinderApiCalls.sendPrompt(event.getValue());
      addMessageToChat(responseFromAi, AI_NAME);
    } catch (Exception e) {
      addMessageToChat("Lo siento, no puedo contestar eso.", AI_NAME);
      System.err.println("Error while sending prompt to AI: " + e.getMessage());
    }
  }

  private void addMessageToChat(String message, String username) {
    CustomMessageListItem messageListItem = new CustomMessageListItem(message, username, Instant.now());
    chat.add(messageListItem);
  }
}