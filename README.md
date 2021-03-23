# RegistrationWebapp
This spring application registers, edits or deletes users from a database. 
I used AngularJS for the frontend, java and mySQL for the backend.
<br />
<img width="1431" alt="Screenshot 2020-12-24 at 12 11 58" src="https://user-images.githubusercontent.com/54688992/107663324-27d94c80-6c83-11eb-9446-1679f3ed4d50.png">
<img width="1431" alt="Screenshot 2020-12-24 at 12 11 17" src="https://user-images.githubusercontent.com/54688992/107663367-34f63b80-6c83-11eb-87fc-097c6e24c3f7.png">
<br/>
The first step was to create a mySQL database. We did not create any tables 
on the server all the tables will be created automatically,but we will need
the server url, and we created a username and a password for the server.
You should create the mySQL server and write this information in the resource
folder,at the application.properties file.
<br />
The RESTfull controller exists inside the rest package and contains all
the methods for creating,deleting and editing users in the database.
<br />
Finally for the frontend. This is a single-page application. We used 
ng-view to display everything in our index page. Bootstrap to make it look pretty.
JavaScript for the app controllers.<br />
<img width="620" alt="Screenshot 2021-03-23 at 23 12 29" src="https://user-images.githubusercontent.com/54688992/112219180-90b9ca00-8c1c-11eb-830d-21fb7a2d2f3e.png">
 
