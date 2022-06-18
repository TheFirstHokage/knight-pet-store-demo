package knight.springframework.petstoredemo.map;

import knight.springframework.petstoredemo.model.Specialty;
import knight.springframework.petstoredemo.model.Vet;
import knight.springframework.petstoredemo.services.SpecialtyService;
import knight.springframework.petstoredemo.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;



@Service
public class VetMapService extends AbstractMapService<Vet,Long> implements VetService {

    private final SpecialtyService specialtyService;

    public VetMapService(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save( Vet object) {

        if (object.getSpecialties().size() > 0) {
            object.getSpecialties().forEach(specialty -> {
                if (specialty.getId() == null) {
                    //creates id for specialty
                    Specialty savedSpecialty = specialtyService.save(specialty);
                    specialty.setId(savedSpecialty.getId());

                }
            });
        }

        return super.save(object);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);

    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

}
