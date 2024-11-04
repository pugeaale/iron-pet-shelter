package com.ironhack.petshelter.dataloader;

import com.ironhack.petshelter.dto.EmployeeDTO;
import com.ironhack.petshelter.dto.VeterinarianDTO;
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
        shelter.setCity("paris");
        shelterService.save(shelter);

        Shelter shelter2 = new Shelter();
        shelter2.setName("shelter2");
        shelter2.setCity("lyon");
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
        veterinarian.setCity("paris");
        veterinarian.setLastName("house");
        veterinarianService.save(veterinarian);

        Veterinarian veterinarian2 = new Veterinarian();
        veterinarian2.setFirstName("hugo");
        veterinarian2.setLastName("house");
        veterinarian2.setCity("lyon");
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

        shelterService.addAnimalToShelter(1,1);

        shelterService.addEmployeeToShelter(1,1);

        adoptionService.create(animal2.getId(),adopter1.getId());

        List<Adoption> adoptions = adoptionService.getAdoptions();
        log.info("adoptions found : {}", adoptions.size());

        medicalProcedureService.create(animal2.getId(), veterinarian1.getId());
        medicalProcedureService.create(1, 1);
        medicalProcedureService.create(2, 2);
        List<MedicalProcedure> medicalProcedures = medicalProcedureService.getMedicalProcedures();
        log.info("medicalProcedures found : {}", medicalProcedures.size());

        List<Veterinarian> veterinariansByCity = veterinarianService.getVeterinariansByCity("paris");
        log.info("veterinarians found : {}", veterinariansByCity.size());

        List<Shelter> sheltersByCity = shelterService.getSheltersByCity("paris");
        log.info("shelters found : {}", sheltersByCity.size());

        List<Animal> animalsByShelter = animalService.getAnimalsByShelterId(1);
        log.info("animals found : {}", animalsByShelter.size());

        List<MedicalProcedure> proceduresByAnimal = medicalProcedureService.getMedicalProceduresByAnimal(2);
        log.info("proceduresByAnimal found : {}", proceduresByAnimal.size());

        List<MedicalProcedure> proceduresByVet = medicalProcedureService.getMedicalProceduresByVeterinarian(1);
        log.info("proceduresByVet found : {}", proceduresByVet.size());

        VeterinarianDTO veterinarianDTO = new VeterinarianDTO();
        veterinarianDTO.setCity("marseille");
        veterinarianDTO.setPhoneNumber("1231231231");
        veterinarianService.update(2, veterinarianDTO);
        Veterinarian veterinarian2updated = veterinarianService.getVeterinarianById(2);
        log.info("veterinarian2updated : {}", veterinarian2updated.getCity() + " - "  + veterinarian2updated.getPhoneNumber());

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmail("fake@gmail.org");
        employeeService.update(1, employeeDTO);
        Employee employee1Updated = employeeService.getEmployeeById(1);
        log.info("employee1Updated : {}", employee1Updated.getEmail());
    }
}
