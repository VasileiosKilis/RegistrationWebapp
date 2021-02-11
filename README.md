# RegistrationWebapp
This spring application registers, edits or deletes users from a database. 
I used AngularJS for the frontend, java and mySQL for the backend.
<br />
![alt text](https://drive.google.com/file/d/1pTWJnZpvTCAkIqpxyhDNCRCcBnAu8jXP/view)
![alt text](https://drive.google.com/file/d/1pTWJnZpvTCAkIqpxyhDNCRCcBnAu8jXP/view?usp=sharing)
<br/>
The first step was to create a mySQL database. We did not create any tables 
on the server all the tables will be created automatically,but we will need
the server url, and we created a username and a password for the server.
You should create the mySQL server and write this information in the resource
folder,at the application.properties file.
<br />
The RESTfull controller exists inside the rest package and contains all
the methods for creating,deleting etc users in the database.
<br />
Finally for the frontend. This is a single-page application. We used 
ng-view to display everything in our index page.
 