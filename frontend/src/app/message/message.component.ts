import { Component, Input } from '@angular/core';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-message',
  template: `
    <div *ngIf="temErro()" class="p-message p-message-error">
      {{ text }}
    </div>
  `,
  styles: [
  ]
})

export class MessageComponent {

  @Input() error = '';
  @Input() control?: FormControl;
  @Input() text = '';

  temErro(): boolean {
    return this.control ? this.control.hasError(this.error) && this.control.dirty : true;
  }
}
