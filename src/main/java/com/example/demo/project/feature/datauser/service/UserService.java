package com.example.demo.project.feature.datauser.service;

import com.example.demo.project.common.entity.ForTestEntity;
import com.example.demo.project.common.repository.ForTestRepository;
import com.example.demo.project.feature.datauser.model.UserModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final ForTestRepository forTestRepository;

    public UserModel.Response getUser(){
        UserModel.Response data = new UserModel.Response();
        data.setId(1);
        data.setName("korn");
        data.setTel("099-99999999");
        data.setEmailAddress("test@hotmail.com");
        return data;
    }

    public UserModel.Response addUser(UserModel.Request req){
        UserModel.Response resData = new UserModel.Response();
        ForTestEntity data = new ForTestEntity();
        data.setName(req.getName());
        data.setTel(req.getTel());
        data.setEmailAddress(req.getEmailAddress());
        forTestRepository.save(data);
        resData.setName(data.getName());
        resData.setTel(data.getTel());
        resData.setEmailAddress(data.getEmailAddress());
        return resData;
    }
    public List<UserModel.Response> getAll(){
        List<UserModel.Response> userAll = new ArrayList<>();
        forTestRepository.findAll().forEach(data ->{
            UserModel.Response resData = new UserModel.Response();
            resData.setId(data.getId());
            resData.setName(data.getName());
            resData.setTel(data.getTel());
            resData.setEmailAddress(data.getEmailAddress());
            userAll.add(resData);
        });
        return userAll;
    }

//    public
}
