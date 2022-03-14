package af.crm.webplatform.controllers;

import af.crm.webplatform.entities.Client;
import af.crm.webplatform.lib.DataCheck;
import af.crm.webplatform.repository.RepoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;
import java.util.List;


@RestController
@RequestMapping("/clients")
public class ControllerClients {

    @Autowired
    RepoClient repoClient;


    @RequestMapping(value = {"list"}, method = RequestMethod.GET)
    public List<Client> clientList() throws NoSuchAlgorithmException {
        return repoClient.findAll();
    }

    @RequestMapping(value = {"client/{id}"}, method = RequestMethod.GET)
    public Client getClient(@PathVariable Long id) {
        return repoClient.getOne(id);
    }

    @RequestMapping(value = {"add"}, method = RequestMethod.POST)
    public Client addClient(@RequestBody Client receiveClient) {
        Client client = null;
        if (DataCheck.checkReceiveClient(receiveClient)) {
            client = new Client(
                    receiveClient.getName(),
                    receiveClient.getSurname(),
                    receiveClient.getBirthDate(),
                    receiveClient.getGender(),
                    receiveClient.getEmail(),
                    receiveClient.getPhone());
            repoClient.save(client);
        }
        return client;
    }

    @RequestMapping(value = {"update"}, method = RequestMethod.POST)
    public Client updateClient(@RequestBody Client receiveClient) {
        Client client = repoClient.getOne(receiveClient.getId());
        client.setName(receiveClient.getName());
        client.setSurname(receiveClient.getSurname());
        client.setBirthDate(receiveClient.getBirthDate());
        client.setGender(receiveClient.getGender());
        client.setEmail(receiveClient.getEmail());
        client.setPhone(receiveClient.getPhone());
        repoClient.save(client);
        return client;
    }

    @RequestMapping(value = {"delete/{id}"}, method = RequestMethod.GET)
    public void deleteClient(@PathVariable Long id) {
        repoClient.deleteById(id);
    }

    @RequestMapping(value = {"getByName"}, method = RequestMethod.GET)
    public List<Client> getByName(@PathVariable String name) {
        return repoClient.findByName(name);
    }

    @RequestMapping(value = {"getBySurname"}, method = RequestMethod.GET)
    public List<Client> getBySurname(@PathVariable String surname) {
        return repoClient.findBySurname(surname);
    }

    @RequestMapping(value = {"getByGender"}, method = RequestMethod.GET)
    public List<Client> getByGender(@PathVariable char gender) {
        return repoClient.findByGender(gender);
    }

    /*
    @RequestMapping(value = {"getByAge"}, method = RequestMethod.GET)
    public List<Client> getByAge(@PathVariable String age) {
        return repoClient.findByAge(age);
    }
    */

    @RequestMapping(value = {"getByEmail"}, method = RequestMethod.GET)
    public Client getByEmail(@PathVariable String email) {
        return repoClient.findByEmail(email);
    }

    @RequestMapping(value = {"getByPhone"}, method = RequestMethod.GET)
    public Client getByPhone(@PathVariable String phone) {
        return repoClient.findByPhone(phone);
    }

}
