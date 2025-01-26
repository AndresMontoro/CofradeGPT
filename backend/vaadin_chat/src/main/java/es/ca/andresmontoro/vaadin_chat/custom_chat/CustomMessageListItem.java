package es.ca.andresmontoro.vaadin_chat.custom_chat;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import org.commonmark.renderer.html.HtmlRenderer;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.Extension;
import org.commonmark.ext.gfm.tables.TablesExtension;


public class CustomMessageListItem extends VerticalLayout {
  private String message;
  private String author;
  private Instant timestamp;
  private static final String AI_NAME = "Cofrade GPT";

  public CustomMessageListItem(String message, String author, Instant timestamp) {
    this.message = message;
    this.author = author;
    this.timestamp = timestamp;

    // Estilo general del componente
    // this.getStyle().set("padding", "10px");
    this.getStyle().set("box-shadow", "0 2px 4px rgba(0, 0, 0, 0.1)");
    setWidthFull(); 
    createMessage();
    createMessageHeader();
  }

  private void createMessage() {
    setWidthFull();

    VerticalLayout messageContent = new VerticalLayout();
    messageContent.add(createMessageHeader(), createMessageBody());
    
    Avatar avatar = new Avatar(author);
    avatar.addThemeName("large");
    // avatar.getStyle().set("margin-top", "10px");

    HorizontalLayout messageContainer = new HorizontalLayout();
    messageContainer.add(avatar, messageContent);
    messageContainer.setJustifyContentMode(JustifyContentMode.START);
    messageContainer.setAlignItems(Alignment.CENTER);
    add(messageContainer);
  }

  private HorizontalLayout createMessageHeader() {
    HorizontalLayout header = new HorizontalLayout();
    header.setSpacing(true);
    header.getStyle().set("align-items", "center");

    Span authorSpan = new Span(author);
    authorSpan.getStyle().set("font-weight", "bold");
    authorSpan.getStyle().set("font-size", "20px");

    Span timestampSpan = new Span(formatTimestamp(timestamp));
    timestampSpan.getStyle().set("font-size", "14px");
    timestampSpan.getStyle().set("color", "#888");
    timestampSpan.getStyle().set("margin-left", "auto");

    header.add(authorSpan, timestampSpan);
    return header;
  }

  private Span createMessageBody() {
    if (author.equals(AI_NAME)) {
      // Convertir Markdown con soporte para tablas a HTML
      List<Extension> extensions = Arrays.asList(TablesExtension.create());
      Parser parser = Parser.builder().extensions(extensions).build();
      HtmlRenderer renderer = HtmlRenderer.builder().extensions(extensions).build();
      
      Node document = parser.parse(message);
      String htmlContent = renderer.render(document);

      // Insertar el HTML en un componente Vaadin
      Html htmlMessage = new Html("<div style='font-size: 16px; color: #333; margin-top: 5px;'>" + htmlContent + "</div>");
      return new Span(htmlMessage);
    } else {
      Span messageSpan = new Span(message);
      messageSpan.getStyle().set("font-size", "16px");
      messageSpan.getStyle().set("color", "#333");
      messageSpan.getStyle().set("margin-top", "5px");
      return messageSpan;
    }
  
  }

  private String formatTimestamp(Instant timestamp) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
      .withZone(ZoneId.systemDefault());
    return formatter.format(timestamp);
  }
}
