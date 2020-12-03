package apap.tutorial.traveloke.service;


import apap.tutorial.traveloke.model.RoleModel;
import apap.tutorial.traveloke.repository.RoleDb;
import apap.tutorial.traveloke.repository.UserDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleDb roleDb;

    @Override
    public List<RoleModel> findAll(){
        return roleDb.findAll();
    }
}
