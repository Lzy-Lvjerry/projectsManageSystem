package com.grapoj.service.impl;

import com.grapoj.dao.AdministratorDao;
import com.grapoj.domain.user.Administrator;
import com.grapoj.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("administratorService")
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private AdministratorDao administratorDao;

    @Override
    public Administrator findAdministratorByID(String adminID) {
        return administratorDao.findAdministratorByID(adminID);
    }

    @Override
    public void saveAdministrator(Administrator administrator) {
        administratorDao.saveAdministrator(administrator);
    }

    @Override
    public void deleteAdministratorByStuID(String adminID) {
        administratorDao.deleteAdministratorByStuID(adminID);
    }

    @Override
    public void updateAdministrator(Administrator administrator) {
        administratorDao.updateAdministrator(administrator);
    }
}
