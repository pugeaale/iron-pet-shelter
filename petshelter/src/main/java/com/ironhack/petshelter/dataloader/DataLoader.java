package com.ironhack.petshelter.dataloader;

import com.ironhack.petshelter.model.*;
import com.ironhack.petshelter.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

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

        shelterService.addAnimalToShelter(1,7L);

        shelterService.addEmployeeToShelter(5L,7L);

        adoptionService.create(2,3L, LocalDate.now());

        createMedicalProcedures();

        createUsers();
    }

    private void createMedicalProcedures() {
        medicalProcedureService.create(2, 1L, "vaccin 1");
        medicalProcedureService.create(1, 1L, "vaccin 2");
        medicalProcedureService.create(2, 2L, "vaccin 3");
        List<MedicalProcedure> medicalProcedures = medicalProcedureService.getMedicalProcedures();
        log.info("medicalProcedures found : {}", medicalProcedures.size());
    }

    private void createVeterinarians() {
        createVet("hugo house", "lyon", "0123456799", "hhouse");
        createVet("gregory house", "paris", "0123456789", "ghouse");
    }

    private void createVet(String name, String city, String number, String username) {
        Veterinarian veterinarian = new Veterinarian();
        veterinarian.setName(name);
        veterinarian.setCity(city);
        veterinarian.setPhoneNumber(number);
        veterinarian.setUsername(username);
        veterinarian.setPassword("1234");
        veterinarianService.save(veterinarian);
        roleService.addRoleToUser("ghouse", "ROLE_VETERINARIAN");
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
        createEmployee("naa men", "anam", "aze");
        createEmployee("tereza men", "mendt", "tereza");
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
        createAdopter("brigitte bardot", "bardo", "eee");

        createAdopter("angela guzman", "aguz", "dddddd");
    }

    private void createAdopter(String name, String username, String phone) {
        Adopter adopter = new Adopter();
        adopter.setName(name);
        adopter.setUsername(username);
        adopter.setPhoneNumber(phone);
        adopter.setPassword("1234");
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
        createShelter("Shelter1", "paris", "shelter");
        createShelter("shelter2", "lyon", "shel2");
    }

    private void createShelter(String name, String city, String username) {
        Shelter shelter = new Shelter();
        shelter.setName(name);
        shelter.setCity(city);
        shelter.setUsername(username);
        shelter.setPassword("1234");
        shelterService.save(shelter);
        roleService.addRoleToUser(shelter.getUsername(), "ROLE_SHELTER");
    }

    private void createCats() {
        createCar("Cat1", "maine coon");

        createCar("cat2", "siamois");
    }

    private void createCar(String name, String breed) {
        Cat cat = new Cat();
        cat.setName(name);
        cat.setBreed(breed);
        catService.save(cat);
    }

    private void createDogs() {
        createDog("Dog", "berger allemand");

        createDog("Maya", "american staff");
    }

    private void createDog(String name, String breed) {
        Dog dog = new Dog();
        dog.setName(name);
        dog.setBreed(breed);
        dogService.save(dog);
    }
}
