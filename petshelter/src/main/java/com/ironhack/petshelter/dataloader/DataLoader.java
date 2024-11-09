package com.ironhack.petshelter.dataloader;

import com.ironhack.petshelter.dto.AdoptionDTO;
import com.ironhack.petshelter.dto.MedicalProcedureDTO;
import com.ironhack.petshelter.model.*;
import com.ironhack.petshelter.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final AdoptionService adoptionService;
    private final UserService userService;
    private final RoleService roleService;
    private final ShelterService shelterService;
    private final DogService dogService;
    private final CatService catService;
    private final AnimalService animalService;
    private final AdopterService adopterService;
    private final VeterinarianService veterinarianService;
    private final EmployeeService employeeService;
    private final MedicalProcedureService medicalProcedureService;

    @Override
    public void run(String... args) throws Exception {
        createRoles();

        createVeterinarians();
        createAdopters();
        createEmployees();
        createShelters();

        createDogs();
        createCats();

        addAnimalsToShelter();

        addEmployeesToShelters();

        createAdoptions();

        createMedicalProcedures();

        createUsers();
    }

    private void createAdoptions() {
        AdoptionDTO adoptionDTO = new AdoptionDTO();
        adoptionDTO.setAnimalId(2);
        adoptionDTO.setAdopterId(3L);
        adoptionDTO.setDate(LocalDate.now());
        adoptionService.create(adoptionDTO);
    }

    private void addAnimalsToShelter() {
        shelterService.addAnimalToShelter(1,7L);
    }

    private void addEmployeesToShelters() {
        shelterService.addEmployeeToShelter(5L,7L);
    }

    private void createMedicalProcedures() {
        MedicalProcedureDTO medicalProcedureDTO = new MedicalProcedureDTO();
        medicalProcedureDTO.setAnimalId(2);
        medicalProcedureDTO.setVeterinarianId(1L);
        medicalProcedureDTO.setDescription("vaccination");
        medicalProcedureService.create(medicalProcedureDTO);
    }

    private void createVeterinarians() {
        createVet("sara tancredi", "lyon", "0177456799", "tanc");
        createVet("gregory house", "paris", "0123456789", "ghouse");
    }

    private void createVet(String name, String city, String number, String username) {
        Veterinarian veterinarian = new Veterinarian();
        veterinarian.setName(name);
        veterinarian.setCity(city);
        veterinarian.setPhoneNumber(number);
        veterinarian.setUsername(username);
        veterinarian.setPassword("{noop}1234");
        veterinarianService.save(veterinarian);
        roleService.addRoleToUser(username, "ROLE_VETERINARIAN");
    }

    private void createUsers() {
        userService.saveUser(new User("John Doe", "john", "1234"));
        userService.saveUser(new User("James Smith", "james", "1234"));
        userService.saveUser(new User("Chris Anderson", "chris", "1234"));

        roleService.addRoleToUser("john", "ROLE_USER");
        roleService.addRoleToUser("james", "ROLE_ADMIN");
        roleService.addRoleToUser("chris", "ROLE_ADMIN");
        roleService.addRoleToUser("chris", "ROLE_USER");
    }

    private void createEmployees() {
        createEmployee("Julia Mendoza", "anam", "aze@gmail.com");
        createEmployee("Tereza Guzman", "mendt", "tereza@outlook.com");
    }

    private void createEmployee(String name, String username, String email) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setUsername(username);
        employee.setEmail(email);
        employee.setPassword("{noop}1234");
        employee.setDateOfBirth(LocalDate.of(2000,1,1));
        employeeService.save(employee);
        roleService.addRoleToUser(username, "ROLE_EMPLOYEE");
    }

    private void createAdopters() {
        createAdopter("Brigitte Bardot", "bardo", "eee");
        createAdopter("Saul Goodman", "sgood", "dddddd");
    }

    private void createAdopter(String name, String username, String phone) {
        Adopter adopter = new Adopter();
        adopter.setName(name);
        adopter.setUsername(username);
        adopter.setPhoneNumber(phone);
        adopter.setPassword("{noop}1234");
        adopterService.save(adopter);
        roleService.addRoleToUser(username, "ROLE_ADOPTER");
    }

    private void createRoles() {
        roleService.save(new Role("ROLE_USER"));
        roleService.save(new Role("ROLE_ADMIN"));
        roleService.save(new Role("ROLE_VETERINARIAN"));
        roleService.save(new Role("ROLE_ADOPTER"));
        roleService.save(new Role("ROLE_EMPLOYEE"));
        roleService.save(new Role("ROLE_SHELTER"));
    }

    private void createShelters() {
        createShelter("SPA 75", "paris", "spa");
        createShelter("SPA 69", "lyon", "spaol");
    }

    private void createShelter(String name, String city, String username) {
        Shelter shelter = new Shelter();
        shelter.setName(name);
        shelter.setCity(city);
        shelter.setUsername(username);
        shelter.setPassword("{noop}1234");
        shelterService.save(shelter);
        roleService.addRoleToUser(shelter.getUsername(), "ROLE_SHELTER");
    }

    private void createCats() {
        createCat("vodka", "maine coon");
        createCat("jujul", "siamese");
        createCat("whisky", "bengual");
        createCat("patoche", "persian");
        createCat("lechat", "sphynx");
    }

    private void createCat(String name, String breed) {
        Cat cat = new Cat();
        cat.setName(name);
        cat.setBreed(breed);
        catService.save(cat);
    }

    private void createDogs() {
        createDog("goldie", "golden retriever");
        createDog("Maya", "american staff");
        createDog("rosebee", "english bulldog");
        createDog("chippie", "chihuahua");
        createDog("dog", "beagle");
    }

    private void createDog(String name, String breed) {
        Dog dog = new Dog();
        dog.setName(name);
        dog.setBreed(breed);
        dogService.save(dog);
    }
}
