package training.com.relation.controllers.onetone;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import training.com.relation.models.onetone.Client;
import training.com.relation.repositories.onetone.RepositoryClient;

@RestController
public class ControllerClient {

  @Autowired
  private RepositoryClient repositoryClient;

  @GetMapping("/onetoone/client")
  ResponseEntity<List<Client>> get() {
    List<Client> listClients = repositoryClient.findAll();
    return new ResponseEntity<>(listClients, HttpStatus.OK);
  }

  @PostMapping("/onetoone/client")
  ResponseEntity<String> get(@Valid Client client) {
    client = repositoryClient.save(client);
    return new ResponseEntity<>(client.getId().toString(), HttpStatus.OK);
  }
}
