import { Component, OnInit } from '@angular/core';
import { AiApiCallService } from '../chat-service/AiApiCall.service';
import { MarkdownService } from '../chat-service/Markdown.service';

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css']
})
export class ChatComponent implements OnInit {

  messages: any[] = [];

  constructor(
    private aiApiCallService: AiApiCallService,
    private markdownService: MarkdownService
  ) { }

  ngOnInit() {
    setTimeout(() => {
      this.addMessageToChat(
        '¡Hola! Soy CofradeGPT. ¿En qué puedo ayudarte?',
        'CofradeGPT', false
      );
    }, 1500);
  }

  sendMessage(event: any) {
    const receivedMessage = event.message;
    this.addMessageToChat(receivedMessage, 'User', true);
    
    this.aiApiCallService.sendMessage(receivedMessage).subscribe({
      next: (response) => {
        this.addMessageToChat(response, 'CofradeGPT', false);
      },
      error: (error) => {
        console.error('Error:', error);
        this.addMessageToChat(
          'Lo siento, no he podido entender tu mensaje.', 
          'CofradeGPT', false
        );
      }
    });
  }

  addMessageToChat(message: string, sender: string, reply: boolean) {
    this.messages.push({
      message: message,
      type: 'text',
      sender: sender,
      reply: reply
    });
  }
}
