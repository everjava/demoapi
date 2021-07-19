# Welcome to Roles api!




# Run

- docker-compose up

Or:
- mvn install
- mvn spring-boot:run


## Backend points

- Look up a role for a membership, where membership is defined by a user id and a  
team id.  
- Look up memberships for a role  
- Create a new role  OK
- Assign a role to a member OK

## Endpoints

- List all users: GET http://localhost:8080/api/v1/user/ 
- Show a specific user: GET http://localhost:8080/api/v1/user/{id}
- Add a role to a user: GET http://localhost:8080/api/v1/user/{id}/role/{role_name}
- List all teams: GET http://localhost:8080/api/v1/teams/
- Show specific team: GET http://localhost:8080/api/v1/teams/{id}
- Show current roles: GET http://localhost:8080/api/v1/role
- Add new role: PUT http://localhost:8080/api/v1/role/{role_name}


