## Create an Angular project using CLI

1) Run `ng new <your_project_name>` and wait till your project is generated.

2) After verifying run `ng serve` for a dev server. Navigate to `http://localhost:4200/` to verify the project creation.

3) Import this project to vscode.

## Copy module & components
- contents of app component
- main-page component
- student-form component and student services
- login module and auth service
- proxy configuration file - proxy.conf.js (this file used to redirect your http requests to your spring-boot server to fetch the data, otherwise angular will lookup the api's in your angular server itself which would result in error).

Copy all the components mentioned above into your projects and stop your application run again using `ng serve --proxy-config proxy.conf.js` command.

Build must be successful and open your application(`http://localhost:4200/`) to see the results.

