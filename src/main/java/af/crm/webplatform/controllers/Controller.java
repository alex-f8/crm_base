package af.crm.webplatform.controllers;

import af.crm.webplatform.entities.Client;
import af.crm.webplatform.entities.User;
import af.crm.webplatform.entities.UserFront;
import af.crm.webplatform.repository.RepoClient;
//import af.crm.webplatform.repository.RepoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;


@RestController
@RequestMapping("/clients")
public class Controller {
    /*@Autowired
    RepoUser repoUser;*/
    @Autowired
    RepoClient repoClient;
    ArrayList<User> users;
    ArrayList<Client> clients;
    ArrayList<UserFront> userFronts = new ArrayList<>();

    @RequestMapping(value = {"list"}, method = RequestMethod.GET)
    public ArrayList<Client> clientList() throws NoSuchAlgorithmException {
        clients = (ArrayList<Client>) repoClient.findAll();
        return clients;
    }

    @RequestMapping(value = {"client/{id}"}, method = RequestMethod.GET)
    public Client getClient(@PathVariable Long id) {
        Client client = repoClient.findById(id).get();
        return client;
    }

/*    @RequestMapping(value = {"userslist"}, method = RequestMethod.GET)
    public ArrayList<User> userList() throws NoSuchAlgorithmException {
        users = (ArrayList<User>) repoUser.findAll();
        for(User userTmp : users)
            userFronts.add( new UserFront(userTmp));
        return users;
    }*/

}
