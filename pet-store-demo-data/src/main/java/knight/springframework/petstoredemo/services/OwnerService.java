package knight.springframework.petstoredemo.services;

import knight.springframework.petstoredemo.model.Owner;


public interface OwnerService extends CrudService<Owner,Long> {


    Owner findByLastName(String lastName);



}
