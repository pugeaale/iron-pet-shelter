package com.ironhack.petshelter.dataloader;

import com.ironhack.petshelter.dto.*;
import com.ironhack.petshelter.model.*;
import com.ironhack.petshelter.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
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







        Employee employee1 = employeeService.getEmployeeById(5L);
        log.info("employee1 found : {}", employee1.getName());

        Adopter adopter1 = adopterService.getAdopterById(3L);
        log.info("adopter1 found : {}", adopter1.getName());

        List<Adopter> adopters = adopterService.getAdopters();
        log.info("adopters found : {}", adopters.size());

        List<Employee> employees = employeeService.getEmployees();
        log.info("employees found : {}", employees.size());

        List<Veterinarian> veterinarians = veterinarianService.getVeterinarians();
        log.info("veterinarians found : {}", veterinarians.size());

        Veterinarian veterinarian1 = veterinarianService.getVeterinarianById(1L);
        log.info("veterinarian1 found : {}", veterinarian1.getName());

        Animal animal2 = animalService.getAnimalById(2);
        log.info("animal2 found : {}", animal2.getName());

        shelterService.addAnimalToShelter(1,1);

        shelterService.addEmployeeToShelter(5L,1);

        adoptionService.create(animal2.getId(),adopter1.getId());

        List<Adoption> adoptions = adoptionService.getAdoptions();
        log.info("adoptions found : {}", adoptions.size());

        createMedicalProcedures();

        List<Veterinarian> veterinariansByCity = veterinarianService.getVeterinariansByCity("paris");
        log.info("veterinarians found : {}", veterinariansByCity.size());

        List<Shelter> sheltersByCity = shelterService.getSheltersByCity("paris");
        log.info("shelters found : {}", sheltersByCity.size());

        List<Animal> animalsByShelter = animalService.getAnimalsByShelterId(1);
        log.info("animals found : {}", animalsByShelter.size());

        List<MedicalProcedure> proceduresByAnimal = medicalProcedureService.getMedicalProceduresByAnimal(2);
        log.info("proceduresByAnimal found : {}", proceduresByAnimal.size());

        List<MedicalProcedure> proceduresByVet = medicalProcedureService.getMedicalProceduresByVeterinarian(1L);
        log.info("proceduresByVet found : {}", proceduresByVet.size());

        updateVeterinarian();

        updateEmployee();

        updateShelter();

        updateAdopter();

        updateDog();

        createUsers();

        deleteMedicalProcedure();
    }

    private void createMedicalProcedures() {
        medicalProcedureService.create(2, 1L);
        medicalProcedureService.create(1, 1L);
        medicalProcedureService.create(2, 2L);
        List<MedicalProcedure> medicalProcedures = medicalProcedureService.getMedicalProcedures();
        log.info("medicalProcedures found : {}", medicalProcedures.size());
    }

    private void deleteMedicalProcedure() {
        medicalProcedureService.deleteMedicalProcedure(1);
        List<MedicalProcedure> medicalProcedures2 = medicalProcedureService.getMedicalProcedures();
        log.info("medicalProcedures found : {}", medicalProcedures2.size());
    }

    private void updateShelter() {
        ShelterDTO shelterDTO = new ShelterDTO();
        shelterDTO.setCity("lisboa");
        shelterDTO.setPhoneNumber("9876543210");
        shelterDTO.setName("best shelter ever");
        shelterService.update(1, shelterDTO);
        Shelter shelter1Updated = shelterService.getShelterById(1);
        log.info(MessageFormat.format("shelter1Updated : '{}'{0} - {1} -{2}", shelter1Updated.getCity(), shelter1Updated.getPhoneNumber(), shelter1Updated.getName()));
    }

    private void updateDog() {
        DogDTO dogDTO = new DogDTO();
        dogDTO.setOkDog(true);
        dogDTO.setOkCat(true);
        dogDTO.setOkChild(true);
        Dog dogUpdated = dogService.update(1, dogDTO);
        log.info("dogUpdated : {}", dogUpdated.getOkDog());
    }

    private void updateAdopter() {
        AdopterDTO adopterDTO = new AdopterDTO();
        adopterDTO.setEmail("email@outlook.org");
        adopterDTO.setPhoneNumber("+33777888999");
        Adopter adopter1Updated = adopterService.update(3L, adopterDTO);
        log.info("adopter1Updated : {}", adopter1Updated.getEmail() + "-" + adopter1Updated.getPhoneNumber());
    }

    private void updateEmployee() {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmail("fake@gmail.org");
        employeeService.update(5L, employeeDTO);
        Employee employee1Updated = employeeService.getEmployeeById(5L);
        log.info("employee1Updated : {}", employee1Updated.getEmail());
    }

    private void updateVeterinarian() {
        VeterinarianDTO veterinarianDTO = new VeterinarianDTO();
        veterinarianDTO.setCity("marseille");
        veterinarianDTO.setPhoneNumber("1231231231");
        veterinarianService.update(2L, veterinarianDTO);
        Veterinarian veterinarian2updated = veterinarianService.getVeterinarianById(2L);
        log.info("veterinarian2updated : {}", veterinarian2updated.getCity() + " - "  + veterinarian2updated.getPhoneNumber());
    }

    private void createVeterinarians() {
        Veterinarian veterinarian = new Veterinarian();
        veterinarian.setName("gregory house");
        veterinarian.setCity("paris");
        veterinarian.setUsername("ghouse");
        veterinarian.setPassword("1234");
        veterinarianService.save(veterinarian);
        roleService.addRoleToUser("ghouse", "ROLE_VETERINARIAN");

        Veterinarian veterinarian2 = new Veterinarian();
        veterinarian2.setName("hugo house");
        veterinarian2.setCity("lyon");
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
        employee.setPassword("1234");
        employeeService.save(employee);
        roleService.addRoleToUser("anam", "ROLE_EMPLOYEE");
        employeeService.save(employee);

        Employee employee2 = new Employee();
        employee2.setName("tereza mendoza");
        employee2.setUsername("mendt");
        employee2.setPassword("1234");
        employeeService.save(employee2);
        roleService.addRoleToUser("mendt", "ROLE_EMPLOYEE");
        employeeService.save(employee2);
    }

    private void createAdopters() {
        Adopter adopter = new Adopter();
        adopter.setName("brigitte bardot");
        adopter.setUsername("bardo");
        adopter.setPassword("1234");
        adopterService.save(adopter);
        roleService.addRoleToUser("bardo", "ROLE_ADOPTER");

        Adopter adopter2 = new Adopter();
        adopter2.setName("angela guzman");
        adopter2.setUsername("aguz");
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
    }

    private void createShelters() {
        Shelter shelter = new Shelter();
        shelter.setName("Shelter1");
        shelter.setCity("paris");
        shelterService.save(shelter);

        Shelter shelter2 = new Shelter();
        shelter2.setName("shelter2");
        shelter2.setCity("lyon");
        shelterService.save(shelter2);
    }

    private void createCats() {
        Cat cat = new Cat();
        cat.setName("Cat1");
        catService.save(cat);

        Cat cat2 = new Cat();
        cat2.setName("cat2");
        catService.save(cat2);
    }

    private void createDogs() {
        Dog dog = new Dog();
        dog.setName("Dog1");
        dogService.save(dog);

        Dog dog2 = new Dog();
        dog2.setName("Dog2");
        dogService.save(dog2);
    }


}
