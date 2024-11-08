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

        adoptionService.create(2,3L);

        createMedicalProcedures();

        createUsers();

        deleteMedicalProcedure();
    }

    private void createMedicalProcedures() {
        medicalProcedureService.create(2, 1L, "vaccin 1");
        medicalProcedureService.create(1, 1L, "vaccin 2");
        medicalProcedureService.create(2, 2L, "vaccin 3");
        List<MedicalProcedure> medicalProcedures = medicalProcedureService.getMedicalProcedures();
        log.info("medicalProcedures found : {}", medicalProcedures.size());
    }

    private void deleteMedicalProcedure() {
        medicalProcedureService.deleteMedicalProcedure(1);
        List<MedicalProcedure> medicalProcedures2 = medicalProcedureService.getMedicalProcedures();
        log.info("medicalProcedures found : {}", medicalProcedures2.size());
    }

    private void createVeterinarians() {
        Veterinarian veterinarian = new Veterinarian();
        veterinarian.setName("gregory house");
        veterinarian.setCity("paris");
        veterinarian.setPhoneNumber("0123456789");
        veterinarian.setUsername("ghouse");
        veterinarian.setPassword("1234");
        veterinarianService.save(veterinarian);
        roleService.addRoleToUser("ghouse", "ROLE_VETERINARIAN");

        Veterinarian veterinarian2 = new Veterinarian();
        veterinarian2.setName("hugo house");
        veterinarian2.setCity("lyon");
        veterinarian2.setPhoneNumber("0123456799");
        veterinarian2.setUsername("hhouse");
        veterinarian2.setPassword("1234");
        veterinarianService.save(veterinarian2);
        roleService.addRoleToUser("hhouse", "ROLE_VETERINARIAN");
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
        Employee employee = new Employee();
        employee.setName("ana mendoza");
        employee.setUsername("anam");
        employee.setEmail("aze");
        employee.setPassword("{noop}1234");
        employee.setDateOfBirth(LocalDate.of(2000,1,1));
        employeeService.save(employee);
        roleService.addRoleToUser("anam", "ROLE_EMPLOYEE");

        Employee employee2 = new Employee();
        employee2.setName("tereza mendoza");
        employee2.setUsername("mendt");
        employee2.setEmail("tereza");
        employee2.setPassword("{noop}1234");
        employee2.setDateOfBirth(LocalDate.of(1989,1,1));
        employeeService.save(employee2);
        roleService.addRoleToUser("mendt", "ROLE_EMPLOYEE");
    }

    private void createAdopters() {
        Adopter adopter = new Adopter();
        adopter.setName("brigitte bardot");
        adopter.setUsername("bardo");
        adopter.setPhoneNumber("eee");
        adopter.setPassword("1234");
        adopterService.save(adopter);
        roleService.addRoleToUser("bardo", "ROLE_ADOPTER");

        Adopter adopter2 = new Adopter();
        adopter2.setName("angela guzman");
        adopter2.setUsername("aguz");
        adopter2.setPhoneNumber("dddddd");
        adopter2.setPassword("1234");
        adopterService.save(adopter2);
        roleService.addRoleToUser("aguz", "ROLE_ADOPTER");
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
        Shelter shelter = new Shelter();
        shelter.setName("Shelter1");
        shelter.setCity("paris");
        shelter.setUsername("shelter");
        shelter.setPassword("1234");
        shelterService.save(shelter);
        roleService.addRoleToUser("shelter", "ROLE_SHELTER");
        Shelter shelter2 = new Shelter();
        shelter2.setName("shelter2");
        shelter2.setCity("lyon");
        shelter2.setUsername("shel2");
        shelter2.setPassword("1234");
        shelterService.save(shelter2);
        roleService.addRoleToUser("shel2", "ROLE_SHELTER");
    }

    private void createCats() {
        Cat cat = new Cat();
        cat.setName("Cat1");
        cat.setBreed("maine coon");
        catService.save(cat);

        Cat cat2 = new Cat();
        cat2.setName("cat2");
        cat2.setBreed("siamois");
        catService.save(cat2);
    }

    private void createDogs() {
        Dog dog = new Dog();
        dog.setName("Dog");
        dog.setBreed("berger allemand");
        dogService.save(dog);

        Dog dog2 = new Dog();
        dog2.setName("Maya");
        dog2.setBreed("american staff");
        dogService.save(dog2);
    }
}
