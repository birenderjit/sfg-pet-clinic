package com.birenderjit.sfgpetclinic.services;

import com.birenderjit.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);
}
