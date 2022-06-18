package knight.springframework.petstoredemo.bootstrap;

import knight.springframework.petstoredemo.model.*;
import knight.springframework.petstoredemo.services.OwnerService;
import knight.springframework.petstoredemo.services.PetTypeService;
import knight.springframework.petstoredemo.services.SpecialtyService;
import knight.springframework.petstoredemo.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class DataLoader implements CommandLineRunner {


    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;


    //    public DataLoader() {
//        ownerService =new OwnerMapService();
//        vetService = new VetMapService();
//    }


    //Spring is auto wiring the services interface
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    //    public DataLoader(OwnerService ownerService, VetService vetService) {
//        this.ownerService = ownerService;
//        this.vetService = vetService;
//    }


    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }

    }

    //refactor to method for spring data JPA
    private void loadData() {


        PetType dog = new PetType();
        dog.setName("Big Dawg");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Kitty cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Pet clifford = new Pet();
        clifford.setPetType(savedDogPetType);
        clifford.setBirthDate(LocalDate.of(2001,12,5));
        clifford.setName("Clifford");

        Owner owner1 = new Owner();
        clifford.setOwner(owner1);
        owner1.getPets().add(clifford);
        owner1.setFirstName("Jerro");
        owner1.setLastName("Gillespie");
        owner1.setAddress("123 Grape street");
        owner1.setCity("Houston");
        owner1.setPhoneNumber("8815445884");
        ownerService.save(owner1);


        Pet garfield = new Pet();
        garfield.setName("Garfield");
        garfield.setPetType(savedCatPetType);
        garfield.setBirthDate(LocalDate.of(1999,6,9));
        Owner owner2 = new Owner();
        garfield.setOwner(owner2);
        owner2.getPets().add(garfield);
        owner2.setFirstName("Kendrick");
        owner2.setLastName("White");
        owner2.setAddress("103 Forest ave");
        owner2.setCity("Phoenix");
        owner2.setPhoneNumber("6207375924");
        ownerService.save(owner2);

        System.out.println("Loading owners....");

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology =specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);


        Vet vet1 = new Vet();
        //vet1.setId(1L);
        vet1.setFirstName("Reed");
        vet1.setLastName("Thompson");
        vet1.getSpecialties().add(savedRadiology);
        vetService.save(vet1);


        Vet vet2 = new Vet();
        //vet2.setId(3L);
        vet2.setFirstName("Avi");
        vet2.setLastName("Rafi");
        vet2.getSpecialties().add(savedDentistry);
        vetService.save(vet2);

        System.out.println("Loading vets...");
    }
}
