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
    // Add little delay
    setTimeout(() => {
      this.addWelcomeMessage();
    }, 1500);
    
  }

  addWelcomeMessage() {
    this.messages.push({
      message: 'Hola, soy CofradeGPT. ¿En qué puedo ayudarte?',
      type: 'text',
      sender: 'CofradeGPT',
      reply: false
    });
  }

  sendMessage(event: any) {
    const receivedMessage = event.message;
    this.messages.push({
      message: receivedMessage,
      type: 'text',
      sender: 'You',
      reply: true
    });
    
    this.aiApiCallService.sendMessage(receivedMessage).subscribe({
      next: (response) => {
        this.messages.push({
          message: response,
          type: 'text',
          sender: 'CofradeGPT',
          reply: false
        });
      },
      error: (error) => {
        console.error('Error:', error);
        this.messages.push({
          message: 'Lo siento, no pude entender tu mensaje. ¿Podrías intentar de nuevo?',
          type: 'text',
          sender: 'CofradeGPT',
          reply: false
        });
      }
    });
  }
}
