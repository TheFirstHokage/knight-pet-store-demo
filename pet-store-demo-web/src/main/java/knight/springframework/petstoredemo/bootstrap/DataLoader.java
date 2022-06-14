package knight.springframework.petstoredemo.bootstrap;

import knight.springframework.petstoredemo.model.Owner;
import knight.springframework.petstoredemo.model.Vet;
import knight.springframework.petstoredemo.services.OwnerService;
import knight.springframework.petstoredemo.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements CommandLineRunner {


    private final OwnerService ownerService;
    private final VetService vetService;
//    public DataLoader() {
//        ownerService =new OwnerMapService();
//        vetService = new VetMapService();
//    }

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    //    public DataLoader(OwnerService ownerService, VetService vetService) {
//        this.ownerService = ownerService;
//        this.vetService = vetService;
//    }


    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Jerro");
        owner1.setLastName("Gillespie");
        ownerService.save(owner1);


        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Kendrick");
        owner2.setLastName("White");
        ownerService.save(owner2);

        System.out.println("Loading owners....");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Reed");
        vet1.setLastName("Thompson");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(3L);
        vet2.setFirstName("Avi");
        vet2.setLastName("Rafi");
        vetService.save(vet2);

        System.out.println("Loading vets...");






    }
}
