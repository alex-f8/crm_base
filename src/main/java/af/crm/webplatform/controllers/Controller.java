package af.crm.webplatform.controllers;

import af.crm.webplatform.entities.Client;
import af.crm.webplatform.entities.User;
import af.crm.webplatform.repository.RepoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

@RestController
@RequestMapping("/crm")
public class Controller {
    @Autowired
    RepoUser repoUser;
    ArrayList<User> users;

    @RequestMapping(value = {"/clientslist"}, method = RequestMethod.GET)
    public Client clientList() throws NoSuchAlgorithmException {
        Calendar birthDate = new GregorianCalendar();
        birthDate.set(1993, 0, 14, 23, 35);
        return new Client("Name", "Surname", birthDate, 'f', "example@mail.ru", "+1");
    }

    @RequestMapping(value = {"/userslist"}, method = RequestMethod.GET)
    public ArrayList<User> usersList() {
        users = (ArrayList<User>) repoUser.findAll();
        return users;
    }

    @RequestMapping(value = {"/adduser"}, method = RequestMethod.GET)
    public void adduser() {
    }

}
