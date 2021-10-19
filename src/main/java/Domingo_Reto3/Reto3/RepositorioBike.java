
package Domingo_Reto3.Reto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioBike {

    @Autowired
    private InterfaceBike crud;
        
    public List<Bike> getAll(){
        return (List<Bike>) crud.findAll();
    }
    
    public Optional<Bike> getBike(int id){
        return crud.findById(id);
    }
    
    public Bike save(Bike bike){
        return crud.save(bike);
    }
    
    public void delete(Bike bike){
    crud.delete(bike);
    }
}
