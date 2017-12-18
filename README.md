# RestaurantOrdering
Restaurant Ordering Application CSE 522 - OOD

Deployment Instructions:

1) Download and Install node js - https://nodejs.org/en/download/
2) Install Angular Cli globally:
	a) Open command prompt as admin.
	b) npm install -g @angular/cli
3) Go to project directory : ~/RestaurantOrdering/src/main/webapp/view/.
4) Delete directory node_modules.
5) Run command: npm install.
6) Run command: ng serve. (This will start the frontend server. Typically on http://localhost:4200/)
7) Open the project in eclipse.
8) Run RestaurantOrdering.java as java application. (This will start the backend REST server. Typically on http://localhost:8080/)
9) The website can now be accessed on http://localhost:4200/ or any custom port set by the user for angular.
10) The database web view can be accessed using http://localhost:8080/h2-console (Optional)
	a) Driver Class: org.h2.Driver
	b) JDBC URL: jdbc:h2:file:~/restaurantOrdering
	c) User Name: sa
	d) Password: (no password)  
