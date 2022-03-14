package af.crm.webplatform.controllers;

import af.crm.webplatform.entities.User;
import af.crm.webplatform.entities.UserFront;
import af.crm.webplatform.lib.DataCheck;
import af.crm.webplatform.repository.RepoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/users")
public class ControllerUsers {

    @Autowired
    RepoUser repoUser;
    List<User> users;


    @RequestMapping(value = {"list"}, method = RequestMethod.GET)
    public ArrayList<UserFront> usersList() {
        List<UserFront> userFront = new ArrayList<UserFront>();
        users = repoUser.findAll();
        for (User userTmp : users)
            userFront.add(new UserFront(userTmp));
        return (ArrayList<UserFront>) userFront;
    }

    @RequestMapping(value = {"user/{id}"}, method = RequestMethod.GET)
    public User getClient(@PathVariable Long id) {
        return repoUser.getOne(id);
    }

    @RequestMapping(value = {"add"}, method = RequestMethod.POST)
    public UserFront addClient(@RequestBody User receiveUser) throws NoSuchAlgorithmException {
        User user = null;
        if (DataCheck.checkReceiveUser(receiveUser)) {
            user = new User(
                    receiveUser.getFullName(),
                    receiveUser.getEmail(),
                    receiveUser.getPassword());
            repoUser.save(user);
        }
        return new UserFront(user);
    }

    @RequestMapping(value = {"update"}, method = RequestMethod.POST)
    public UserFront updateUserWOPassword(@RequestBody UserFront receiveUserFront) {
        User user = repoUser.getOne(receiveUserFront.getId());
        user.setFullName(receiveUserFront.getFullName());
        user.setEmail(receiveUserFront.getEmail());
        repoUser.save(user);
        return new UserFront(user);
    }

/*

    @RequestMapping(value = {"updateUserPassword"}, method = RequestMethod.POST)
    public UserFront updateUserPassword(@RequestBody UserFront receiveUserFront) {
        return new UserFront(user);
    }
*/


    @RequestMapping(value = {"delete/{id}"}, method = RequestMethod.GET)
    public void deleteClient(@PathVariable Long id) {
        repoUser.deleteById(id);
    }

    @RequestMapping(value = {"getByFullName"}, method = RequestMethod.GET)
    public List<User> getByFullName(@PathVariable String fullName) {
        return repoUser.findByFullName(fullName);
    }

    @RequestMapping(value = {"getByEmail"}, method = RequestMethod.GET)
    public User getByEmail(@PathVariable String email) {
        return repoUser.findByEmail(email);
    }

}
