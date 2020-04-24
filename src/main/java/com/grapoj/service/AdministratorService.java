package com.grapoj.service;

import com.grapoj.domain.user.Administrator;

public interface AdministratorService {

    public Administrator findAdministratorByID(String adminID);

    //    保存账户信息
    public void saveAdministrator(Administrator administrator);

    //    删除账户信息
    public void deleteAdministratorByStuID(String adminID);

    //    修改账户信息
    public void updateAdministrator(Administrator administrator);


}
