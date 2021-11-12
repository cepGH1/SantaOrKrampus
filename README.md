# SantaOrKrampus
example of a springboot crud app</br>
Outline of the project</br>
![image](https://user-images.githubusercontent.com/12085003/141465356-b9c64436-f56c-46d4-b884-b1caf95dce5f.png)</br>

This repository is the result of a Department for Education Bootcamp run by QA.com in software development</br>
Reason for doing this - learning to carry out a small project in Java</br>
Project was managed agilely, using Jira, Scrum and Kanban boards</br>
link to jira project management: 
https://team-1632237778310.atlassian.net/jira/software/projects/DFES/boards/3/backlog </br>
<h3>Thoughts about the Project</h3>
I had no expectations about how the project would go. Although I wasn't unhappy with the time allocated. 
Reproducing a SpringBoot crud app was OK. Testing took far longer than I expected. At least a whole day longer. I still have an enormus amount to learn about Jira.
<h4>What delayed me</h4>
After packaging with Maven it was difficult to get the app to work again in eclipse.</br>
Having no practical experience of Jira before beginning this project was sad because I am sure I could have used it more effectively.</br>
<h4>Future of the app and improvements</h4>
The app could be improved with a front end web page, security(a login) and output to goodPeople and badPeople files, on demand.
<h3>How to use the App</h3>
Functionality of the App
Description
This App takes 3 pieces of information about a person and stores them in a MySQL database. The information is passed to the app using the Postman AP.<br>
The information stored is <br>
<ol>
  <li>name : a string , the name of the person</li>
  <li>sweet: a string, their choice of sweets, candy or chocolates to receive on St Nicholas day</li>
<li>good: either true or false, to signify if they are going to get the chocolate or a visit from the Krampus.<br> Value good = chocolate from St Nich.<br> Value false = Krampus takes you away.</li>
  </ol>
The App then provides Lists of good and bad people, depending on the value of the good coloumn of the database.<br>
The App uses a MySQL database called santa_or_krampus at the localhost, port 3306<br>
The tomcat server for the MySQL production version of the app is listening on port 8081<br>
Testing is done on port 8082 with h2 database<br>
 <h4>Commands using Postman</h4>
<h5>1. Create </h5>
Adds a person entry to the Person table of the santa_or_krampus database<br>
Command in head<br>
Post   localhost:8081/Person/create<br>
Put the three pieces of information in the body, as raw JSON notation<br>
{<br>
“name”:”joe”<br>
“sweet”:”chocolate”<br>
“good”: true<br>
}<br>
![image](https://user-images.githubusercontent.com/12085003/141466773-3d72f35b-fe27-4ddd-9f83-c0ec717061ae.png)<br>
<h5>2. get/id</h5>
Retrieves the database entry for the person with that id<br>

Postman head Get  localhost:8081/Person/get/id<br>
![image](https://user-images.githubusercontent.com/12085003/141466988-fd6ac6d1-ad4b-4b6d-b49d-4d152011996e.png)<br>
<h5>3. getThemAll</h5>
Retrieves all the database entries<br>
Postman head,  Get localhost:8081/Person/getThemAll<br>
![image](https://user-images.githubusercontent.com/12085003/141467315-65673066-4fa8-4d09-aea3-959f945aef68.png)<br>










