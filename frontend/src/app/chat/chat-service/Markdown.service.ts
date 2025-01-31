import { Injectable } from '@angular/core';
import { DomSanitizer, SafeHtml } from '@angular/platform-browser';
import { marked } from 'marked';

@Injectable({
  providedIn: 'root'
})
export class MarkdownService {

  constructor(private sanitizer: DomSanitizer) { }

  convertToHtml(markdown: string): SafeHtml {
    const html = marked(markdown);
    const safeHtml = this.sanitizer.bypassSecurityTrustHtml(html.toString());
    return safeHtml;
  }
}
