import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css'],
  imports: [],
  standalone: true
})
export class ChatComponent implements OnInit {

  messages: { text: string, reply: boolean, date: Date }[] = [];

  constructor() { }

  ngOnInit() {
  }

  sendMessage(event: any) {
    this.messages.push({
      text: event.message,
      reply: false,
      date: new Date()
    });
  }

}
