
package Domingo_Reto3.Reto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Bike")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
   
public class ControladorBike {
    @Autowired
    private ServiciosBike servicio;
    @GetMapping("/all")
    public List<Bike> getBikes(){
        return servicio.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Bike> getBike(@PathVariable("id")int bikeId){
        return servicio.getBike(bikeId);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Bike save(@RequestBody Bike bike){
        return servicio.save(bike);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Bike update(@RequestBody Bike bike){
        return servicio.update(bike);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int bikeId){
        return servicio.deleteBike(bikeId);
    }
}
