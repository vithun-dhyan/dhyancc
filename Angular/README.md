## Create an Angular project using CLI

- Create a new folder for your angular project and navigate into it.

- Run `ng new <your_project_name>` - during installation it will ask to add routes for your app give `yes` and for styling choose `scss` as your styling format and give `no` for Server-Side Rendering (SSR) and Static Site Generation (SSG/Prerendering).

<b> NOTE - If you are using angular version 15 and above use this command to create the project `ng new <your_project_name> --standalone=false`(ex. ng new dhyancc --standalone=false).</b>

- After the project creation navigate into your created project directory and run `ng serve` for a dev server. Access this url `http://localhost:4200/` to verify the project creation.

- Import this project into vscode.

## Copy app component

- Copy the contents of app component and replace it in your project (ts, css, html).

<b> NOTE - The given project has been built using Node.js v18.20.4, Angular cli v13.0.4, Angular v13.0.3 </b>

## Build

- Ng compilation must be successful in this step and reload your website.
- Now you should be able to see the nav bar.

## Copy main-page component

- Copy the contents of main-page component into your project (ts, css, html), also copy the dependent student service and student-interface files and declare the components in the app module.

- Configure routes for main-page component in app-routing.module.ts

- To fetch the data for main-page component disable your basic authentication in your spring-boot application and start your spring-boot server. After starting the spring-boot server configure proxy to your angular app
    - Copy the file `proxy.conf.json` from cloned repo to your project root directory (in path where package.json exists).
    - `proxy.conf.json` (this file used to redirect your http requests to your spring-boot server to fetch the data, otherwise angular will lookup the api's in your angular server itself which would result in error).

## Build again

- Stop your angular application and start the app using command `ng serve --proxy-config proxy.conf.json`.

- Ng compilation must be successful in this step and reload your website.
Now you should be able to load the main-page component in `http://localhost:4200/home` path with student data.

## Copy student-form component

- Copy the student-form component into your project (ts, css, html) and also copy the routes for the student-form from app-routing module and declare the components in the app module.

## Build again

- Ng compilation must be successful in this step and reload your website.

- Now you should be able to see the main-page component with functional add/delete/edit actions with student form.

## Enable security in backend

- At this step you should be able to perform CRUD operations with student form and navigate between pages. All these CRUD operations were not secured by login.

- Go to the spring-boot server and enable the basic authentication and restart the server and  verify the api access by without passing credentials it should not work.

- With proper credentials the api's should work.

- Verify your angular app should not be able to access api's after enabling authentication in backend.

## Enable security in front-end

- Copy the login module into your project(ts, html, css, routing.module.ts, module.ts, service.ts)

- Declare the login module & services in your app module.

## Build again

- Ng compilation must be successful in this step and reload your website.
- Now you should be able to see to do add/delete/edit actions with student form after enabling security.


