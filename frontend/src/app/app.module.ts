import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { ChatComponent } from './chat/chat.component';
import { BrowserModule } from '@angular/platform-browser'; // Importa BrowserModule


@NgModule({
  declarations: [	
    AppComponent,
    ChatComponent
  ],
  imports: [
    BrowserModule // Agrega el módulo a imports
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }