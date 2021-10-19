
package Domingo_Reto3.Reto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosCliente {
    @Autowired
    private RepositorioCliente metodosCrud;
    
    public List<Cliente> getAll(){
        return metodosCrud.getAll();
    }
    public Optional<Cliente> getClient(int clientId){
        return metodosCrud.getCliente(clientId);
    }
    
    public Cliente save(Cliente Client){
        if(Client.getIdClient()== null){
            return metodosCrud.save(Client);
        }else{
            Optional<Cliente> e= metodosCrud.getCliente(Client.getIdClient());
            if(e.isEmpty()){
                return metodosCrud.save(Client);
            }else{
            return Client;
        }
    }
}

    public Cliente update(Cliente client){
        if(client.getIdClient()!=null){
            Optional<Cliente> e= metodosCrud.getCliente(client.getIdClient());
        if(!e.isEmpty()){
            if(client.getName()!=null){
                e.get().setName(client.getName());
            }
            if(client.getAge()!=null){
                e.get().setAge(client.getAge());
            }
            if(client.getPassword()!=null){
                e.get().setPassword(client.getPassword());
            }
            metodosCrud.save(e.get());
            return e.get();
        }else{
            return client;
        }
        }else{
        return client;
        }
    }   
    public boolean deleteClient(int clientId){
        Boolean aBoolean = getClient(clientId).map(client -> {
            metodosCrud.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}