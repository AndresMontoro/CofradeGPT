import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { ChatComponent } from './chat/chat.component';
import { BrowserModule } from '@angular/platform-browser'; // Importa BrowserModule
import { NbThemeModule, NbLayoutModule, NbChatModule } from '@nebular/theme';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NbEvaIconsModule } from '@nebular/eva-icons';

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
    NbEvaIconsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }