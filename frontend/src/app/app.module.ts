import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { ChatComponent } from './chat/chat-component/chat.component';
import { BrowserModule } from '@angular/platform-browser'; // Importa BrowserModule
import { NbThemeModule, NbLayoutModule, NbChatModule } from '@nebular/theme';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NbEvaIconsModule } from '@nebular/eva-icons';
import { AiApiCallService } from './chat/chat-service/AiApiCall.service';
import { provideHttpClient } from '@angular/common/http';
import { MarkdownService } from './chat/chat-service/Markdown.service';

@NgModule({
  declarations: [		
    AppComponent,
    ChatComponent
  ],
  imports: [
    BrowserModule, // Agrega el módulo a imports
    BrowserAnimationsModule,
    NbThemeModule.forRoot({ name: 'default' }), // Tema predeterminado
    NbLayoutModule,
    NbChatModule, // Importar el módulo de chat
    NbEvaIconsModule,
  ],
  providers: [
    provideHttpClient(),
    AiApiCallService, 
    MarkdownService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }