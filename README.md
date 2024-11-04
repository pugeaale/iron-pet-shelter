# Iron pet shelter

This is my final project of Ironhack backend bootcamp.

## Project description

The project is a web application that manages shelters.
The platform allows users to create or edit a shelter and also provides the option to add or update an animal.
A user can also create a profile and request an adoption.
The veterinarian adds medical procedures carried out on each animal, such as vaccinations.
Finally, shelter employees or volunteers record various activities, such as cleaning, walking, and training sessions.

## Class diagram

## Setup

IntelliJ
Springboot

## Technology used

Git
Github
Java
Spring
JPA
MySQL

## Controllers and routes structure

### Adopter

Save a new adopter
* POST
* /adopters

Get a adopter by id
* METHOD : GET
* ROUTE : /adopters/{id}
* Path variable : 'id' of the adopter

Get a list of all adopters
* GET
* /adopters

### Adoption

Get a list of all Adoptions
* GET
* /adoptions

Save a new adoption
* POST
* /adoptions
* Request body : {
  "animalId": "2",
  "adopterId": "2"
  }

### Veterinarian

Save a new Veterinarian
* POST
* /veterinarians

Get a list of all veterinarians
* GET
* /veterinarians

Get a Veterinarian by id
* METHOD : GET
* ROUTE : /veterinarians/{id}
* Path variable : 'id' of the Veterinarian

Get Veterinarians by city
* METHOD : GET
* ROUTE : /veterinarians/{city}
* Path variable : 'city' to locate veterinarians

### Medical procedure

Get a list of all medical procedures
* GET
* /medical-procedures

Save a new medical procedure
* POST
* /medical-procedures
* Request body : {
  "animalId": "2",
  "veterinarianId": "2"
  }

Get medical procedures by animals
* METHOD : GET
* ROUTE : /medical-procedures-by-animal
* Request param : 'animalId' to locate medical procedures
* ex: /medical-procedures-by-animal?animalId=1
* 
### Employee

Save a new Employee
* POST
* /employees

Get a list of all Employees
* GET
* /employees

Get a Employee by id
* METHOD : GET
* ROUTE : /employees/{id}
* Path variable : 'id' of the Employee

### User

Get a list of all users
* Get
* /users

Save a new user
* Post :
* /users

### Role

Save a new role
* Post :
* /roles

Add a role to a user
* Post :
* /roles/add-to-user

### Shelter

Save a new shelter
* POST
* /shelters

Add animal to a shelter
* PATH
* /shelters/add-animal
* body : {
  "animalId": "2",
  "shelterId": "2"
  } 

Add employee to a shelter
* PATH
* /shelters/add-employee
* body : {
  "employeeId": "2",
  "shelterId": "2"
  }

Get a list of all shelters
* GET
* /shelters

Get a shelter by id
* METHOD : GET
* ROUTE : /shelters/{id}
* Path variable : 'id' of the shelter 

Get shelters by city
* METHOD : GET
* ROUTE : /shelters-by-city
* Request param : 'city' to locate shelters
* ex: /shelters-by-city?city=paris

### Dog

Save a new dog
* POST
* /dogs

Get a list of all dogs
* GET
* /dogs

### Cat

Save a new cat
* POST
* /cats

Get a list of all cats
* GET
* /cats

### Animals

Get a list of all animals
* Get
* /animals

Get an Animal by id
* METHOD : GET
* ROUTE : /animals/{id}
* Path variable : 'id' of the Animal

Get animals by shelter
* METHOD : GET
* ROUTE : /animals-by-shelter
* Request param : 'shelterId' to locate animals
* ex: /animals-by-shelter?shelterId=1

## Future work

## Extra links

Slides


## Ressources

## Team members

Alexandre Pugeat