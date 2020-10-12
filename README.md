# CodeFuryNetworkingProject
Contacts and Networking Application (Whole end-to-end program)

Through this project we are trying to connect people. The web based application allow users to add and manage contacts. The application supports unlimited users and provides several features for socializing.
## Steps for the evaluators to run the project
1.Import the project "Contacts_And_Networking_Application".
2. Add the derby and GSON jar files (according to the supported version) in WebContent->WEB-INF->lib folder.
3. Change the database path to the one present in your system (Variable->"url" in DBUtil class present in com.demo.dao).
4. Build the path if required.
5. Run the project on apache tomcat server.

## Brief workflow of the project:
When we run the project, the first page is the HOMEPAGE. From there you have the option to login as ADMIN or USER. After you login(USER) ,you can access various fetures of application like:
1. Add Friend by sending request to the other user.
2. BLOCK,IGNORE,ACCEPT the friend request recieved.
3. SEARCH information of other users. 
4. BLOCK or UNBLOCK other users.
5. ADD NEW USER 
6. UNFRIEND or BLOCK  friend.
7. UPDATE information of user(contact list) etc.. 
