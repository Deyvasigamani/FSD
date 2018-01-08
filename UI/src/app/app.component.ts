import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Project Manager';


  // navigateFun(event){
  //   console.log("In on click fun",event);
  //   event.target.parentNode.childNodes.className = "";
  //   $(event.target).parent().find('.activeCls').removeClass("activeCls");
  //   event.target.className = "activeCls";
  // }
}
