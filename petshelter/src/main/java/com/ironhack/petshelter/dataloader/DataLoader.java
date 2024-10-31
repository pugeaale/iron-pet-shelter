package com.ironhack.petshelter.dataloader;

import com.ironhack.petshelter.model.*;
import com.ironhack.petshelter.repository.ShelterRepository;
import com.ironhack.petshelter.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final UserService userService;
    private final RoleService roleService;
    private final ShelterService shelterService;
    private final DogService dogService;
    private final CatService catService;
    private final AnimalService animalService;
    private final AdopterService adopterService;
    private final VeterinarianService veterinarianService;
    private final EmployeeService employeeService;

    @Override
    public void run(String... args) throws Exception {
        roleService.save(new Role("ROLE_USER"));
        roleService.save(new Role("ROLE_ADMIN"));

        userService.saveUser(new User("John Doe", "john", "1234"));
        userService.saveUser(new User("James Smith", "james", "1234"));
        userService.saveUser(new User("Jane Carry", "jane", "1234"));
        userService.saveUser(new User("Chris Anderson", "chris", "1234"));

        roleService.addRoleToUser("john", "ROLE_USER");
        roleService.addRoleToUser("james", "ROLE_ADMIN");
        roleService.addRoleToUser("jane", "ROLE_USER");
        roleService.addRoleToUser("chris", "ROLE_ADMIN");
        roleService.addRoleToUser("chris", "ROLE_USER");

        Shelter shelter = new Shelter();
        shelter.setName("Shelter1");
        shelterService.save(shelter);

        Shelter shelter2 = new Shelter();
        shelter2.setName("shelter2");
        shelterService.save(shelter2);

        Dog dog = new Dog();
        dog.setName("Dog1");
        dogService.save(dog);

        Dog dog2 = new Dog();
        dog2.setName("Dog2");
        dogService.save(dog2);

        Cat cat = new Cat();
        cat.setName("Cat1");
        catService.save(cat);

        Cat cat2 = new Cat();
        cat2.setName("cat2");
        catService.save(cat2);

        List<Animal> animals = animalService.getAnimals();
        log.info("animals found : {}", animals.size());

        List<Dog> dogs = dogService.getDogs();
        log.info("dogs found : {}", dogs.size());

        List<Cat> cats = catService.getCats();
        log.info("cats found : {}", cats.size());

        List<Shelter> shelters = shelterService.getShelters();
        log.info("shelters found : {}", shelters.size());

        Shelter shelter1 = shelterService.getShelterById(1);
        log.info("shelter1 found : {}", shelter1.getName());

        Adopter adopter = new Adopter();
        adopter.setFirstName("brigitte");
        adopter.setLastName("bardot");
        adopterService.save(adopter);

        Adopter adopter2 = new Adopter();
        adopter2.setFirstName("angela");
        adopter2.setLastName("guzman");
        adopterService.save(adopter2);

        Veterinarian veterinarian = new Veterinarian();
        veterinarian.setFirstName("gregory");
        veterinarian.setLastName("house");
        veterinarianService.save(veterinarian);

        Veterinarian veterinarian2 = new Veterinarian();
        veterinarian2.setFirstName("hugo");
        veterinarian2.setLastName("house");
        veterinarianService.save(veterinarian2);

        Employee employee = new Employee();
        employee.setFirstName("ana");
        employee.setLastName("mendoza");
        employeeService.save(employee);

        Employee employee2 = new Employee();
        employee2.setFirstName("tereza");
        employee2.setLastName("mendoza");
        employeeService.save(employee2);

        Employee employee1 = employeeService.getEmployeeById(1);
        log.info("employee1 found : {}", employee1.getLastName());

        Adopter adopter1 = adopterService.getAdopterById(1);
        log.info("adopter1 found : {}", adopter1.getLastName());

        List<Adopter> adopters = adopterService.getAdopters();
        log.info("adopters found : {}", adopters.size());

        List<Employee> employees = employeeService.getEmployees();
        log.info("employees found : {}", employees.size());

        List<Veterinarian> veterinarians = veterinarianService.getVeterinarians();
        log.info("veterinarians found : {}", veterinarians.size());

        Veterinarian veterinarian1 = veterinarianService.getVeterinarianById(1);
        log.info("veterinarian1 found : {}", veterinarian1.getLastName());

        Animal animal2 = animalService.getAnimalById(2);
        log.info("animal2 found : {}", animal2.getName());
    }
}
