package com.miportfolio.nico.Controller;

import com.miportfolio.nico.Entity.HyS;
import com.miportfolio.nico.Security.Controller.Mensaje;
import com.miportfolio.nico.Service.SHyS;
import com.miportfolio.nico.dto.dtoHyS;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins={"http://localhost:4200","https://nicoportfolioweb.web.app"})
//@CrossOrigin(origins = "https://nicoportfolioweb.web.app/")
@RequestMapping("/skill")
public class CHyS {

    @Autowired
    SHyS sHyS;

    @GetMapping("/lista")
    public ResponseEntity<List<HyS>> list() {
        List<HyS> list = sHyS.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<HyS> getById(@PathVariable("id") int id) {
        if (!sHyS.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        HyS hys = sHyS.getOne(id).get();
        return new ResponseEntity(hys, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoHyS dtohys) {
        if (StringUtils.isBlank(dtohys.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sHyS.existsByNombre(dtohys.getNombre())) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }
        //compara suma de nombre y descripcion, para poder agregar una misma hys con diferente descripcion
        //if(sHyS.existsByNomYDescE(dtoExp.getNomYDescE())) 
        //&& sHyS.getByNombreE(dtoExp.getNombreE()).get().getId() != id)
        //{
        //    return new ResponseEntity(new Mensaje("Esa hys ya existe"), HttpStatus.BAD_REQUEST);
        //}

        HyS hys = new HyS(dtohys.getNombre(), dtohys.getPorcentaje());
        sHyS.save(hys);

        return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoHyS dtohys) {
        //validamos si existe el id
        if (!sHyS.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }

        //compara nombre de hyss
        if (sHyS.existsByNombre(dtohys.getNombre()) && sHyS.getByNombre(dtohys.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa hys ya existe"), HttpStatus.BAD_REQUEST);
        }

        //compara suma de nombre y descripcion, para poder agregar una misma hys con diferente descripcion
        //if(sHyS.existsByNomYDescE(dtoExp.getNomYDescE()) && sHyS.getByNombreE(dtoExp.getNombreE()).get().getId() != id){
        //    return new ResponseEntity(new Mensaje("Esa hys ya existe"), HttpStatus.BAD_REQUEST);
        //}
        //verifica si el campo está vacío
        if (StringUtils.isBlank(dtohys.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio."), HttpStatus.BAD_REQUEST);
        }

        HyS hys = sHyS.getOne(id).get();
        hys.setNombre(dtohys.getNombre());
        hys.setPorcentaje((dtohys.getPorcentaje()));

        sHyS.save(hys);
        return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        //validamos si existe el id
        if (!sHyS.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.NOT_FOUND);
        }

        sHyS.delete(id);

        return new ResponseEntity(new Mensaje("hys eliminada"), HttpStatus.OK);
    }
}
