# Tasks Management API with Tags.

## Pre-Requisites

        IntelliJ
        Java JDK 21
        Maven v3.4.0
        PostgreSQL version 16

## Setting up Database

Use the following links to install PostgreSQL Database Engine [PostgesSQL Installation](https://www.guru99.com/download-install-postgresql.html)

After successful installation Create database and name it <strong>tasks </strong>.

For database creation steps use this link
[Database creation](https://www.tutorialsteacher.com/postgresql/create-database)

### Steps

1. Start IntelliJ and Click on <strong><em>File> New> Project> Version Control...</em></strong>
   <br/>

   ![version contron](/images/selectfile.png)

<br/>
2. Paste the following Repository URL:https://github.com/WencesKipsang/tasksmanagement.git in <strong>URL</strong>
   and choose the folder in your computer you want to clone to. in <strong>Directory</strong> part
   Click on Clone Project.
<br/>
<br/>

![clone](/images/clone.png)
<br/> 3. Once the project has been successfully cloned, Navigate to the project folder and Right Click on <strong><em>pom.xml > Click Maven>Sync Project.</em></strong>
<br/>

![sync project](/images/syncpom.png)
<br/>

4. Find <strong>application.properties</strong> file under the <em><strong>src>resources</strong></em> and add your postgreSQL DB_USERNAME and DB_PASSWORD.
   <br/>

   ![aplication properties](/images/editapplicationpropertise.png)

      <br/>

5. Open the <strong>TaskmanagementApplication.java</strong>and click run the project.You will find the file in <em><strong> src> main> java> com.kipsang.taskmanagement</strong></em>
   <br/>

   ![run](/images/runproject.png)
   <br/>

6. Once the project successfully run, go to http://localhost:8080/swagger-ui/index.html on your browser. You can now interact with the API endpoints as shown:
   <br/>

   ![endpoints](/images/Swaggerui.png)
   <br/>

### Interaction with the Apis using Swagger

#### Steps:

1. First click on <strong><em> /api/register</em></strong> to create an account with username and password that your will use whenever asked by swagger
   ![register user](/images/registeruser.png)

2. Create Tasks by clicking on <strong><em>/api/createTasks</em></strong> then click <strong>try it out </strong> then fill in the title filed and fill the tags, tags can
   be filled in arrays and click on <em><strong>execute</em></strong> it will prompt for username and password<br/>
   Enter the username and password you register in step

![create task](/images/createtaskpass.png)

Create more tasks as you can.<br/> 3. <strong>View</strong> the tasks you Created in by clicking <strong><em>/api/getTasks</em></strong> <br/> 4. <strong>Update</strong> the task in <em><strong>api/updateTask/{id}</strong></em><br/> 5. Interact freely with the rest of the endpoints.
