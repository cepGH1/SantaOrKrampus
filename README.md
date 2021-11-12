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
<img src="https://user-images.githubusercontent.com/12085003/141467315-65673066-4fa8-4d09-aea3-959f945aef68.png" height="400" alt="missing image">
![image](https://user-images.githubusercontent.com/12085003/141467315-65673066-4fa8-4d09-aea3-959f945aef68.png)<br>

<h5>4. getGood</h5>
Retrieves all the people with good behaviour, from the database, for Santa<br>
Postman head, Get localhost:8081/Person/getGood<br>
![image](https://user-images.githubusercontent.com/12085003/141468720-7e4e26d8-e5e4-475c-9aa6-db6db2a99d48.png)<br>
<h5>5. getBad</h5>
Retrieves all the people with bad behaviour, from the database, for Krampus<br>
Postman head, Get localhost:8081/Person/getBad<br>
![image](https://user-images.githubusercontent.com/12085003/141469407-3cdff715-0956-40c8-9eb4-419ee6c9ff77.png)<br>
<h5>6. replace</h5>
Replaces an entry in the database with new values whilst retaining it’s original id<br>
Postman head Put localhost:8081/Person/replace/id<br>
![image](https://user-images.githubusercontent.com/12085003/141469560-8cb7066a-27c5-4f9f-9c00-a9f2474b9855.png)<br>
<h5>7. remove/id</h5>
Removes the entry with the given id from the database<br>
Postman head, Delete localhost:8081/Person/remove/id<br>
![image](https://user-images.githubusercontent.com/12085003/141469709-987adf26-cc3f-4f41-9fd7-c35a7bafcf62.png)<br>
<h4>GitHub/repository structure</h4>
Issues from the jira sprint are on feature branches of the git repository https://github.com/cepGH1/SantaOrKrampus<br>
The feature branches are merged to the dev branch and that is merged to the main branch.<br>

Made a feature branch for integration test, then merged it to the dev branch<br>
![image](https://user-images.githubusercontent.com/12085003/141470664-d7c33994-87d4-45c3-9c42-3cc0e14ee022.png)<br>
Merged dev to main<br>
![image](https://user-images.githubusercontent.com/12085003/141470893-8c9d1a71-aff5-4338-935d-be420c026903.png)<br>
<h4>Database Structure</h4>
santa_or_krampus database showing contents of the person table after some additions and removals<br>
![image](https://user-images.githubusercontent.com/12085003/141471027-f20f4f3b-9ff4-4df4-b8f6-7873fe2e850f.png)<br>
<h4>Testing</h4>
The app was tested with a mock mvc integration test and a junit suite of tests<br>
![image](https://user-images.githubusercontent.com/12085003/141471181-000e9d59-bda8-4829-86a2-5c7a355d809b.png)<br>
<h4>Risk Assessment</h4>
Risk assessment is in the file riskAssessment.docx in the root of this repository
  



























