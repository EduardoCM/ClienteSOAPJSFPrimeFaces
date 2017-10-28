package com.escom.ws.clientsoapweb;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import org.ipn.escom.ws.Persona;
import org.ipn.escom.ws.PersonaServiceWS;
import org.ipn.escom.ws.PersonaServiceWSImplService;

/**
 *
 * @author edcastillo
 */
@ManagedBean
@RequestScoped
public class PersonaBean {
    
    private Persona personaNueva;
   
    private PersonaServiceWS personaService;
    
    private List<Persona> lstPersonas;
    
    public PersonaBean(){
        lstPersonas = new ArrayList<Persona>();
        personaNueva = new Persona();
    }
    
    public void guardarPersona(){
        personaService =  new PersonaServiceWSImplService().getPersonaServiceWSImplPort();
        personaService.registrarPersona(personaNueva);
    }
    
    public void listarPersona(){
        personaService =  new PersonaServiceWSImplService().getPersonaServiceWSImplPort();
        lstPersonas = personaService.listarPersonas();
    }
    
    public void eliminarId(Persona personaEliminar){
        personaService =  new PersonaServiceWSImplService().getPersonaServiceWSImplPort();
        personaService.eliminarPersona(personaEliminar);
    }
    
    public void buscarId(){
        personaService =  new PersonaServiceWSImplService().getPersonaServiceWSImplPort();
        personaService.encontrarPersonaPorId(personaNueva);
    
    }
    
    public void actualizar(){
        personaService =  new PersonaServiceWSImplService().getPersonaServiceWSImplPort();
        personaService.modificarPersona(personaNueva);
    
    }
    
    
    public Persona getPersonaNueva() {
        return personaNueva;
    }

    public void setPersonaNueva(Persona personaNueva) {
        this.personaNueva = personaNueva;
    }

    public PersonaServiceWS getPersonaService() {
        return personaService;
    }

    public void setPersonaService(PersonaServiceWS personaService) {
        this.personaService = personaService;
    }

    

    public List<Persona> getLstPersonas() {
        return lstPersonas;
    }

    public void setLstPersonas(List<Persona> lstPersonas) {
        this.lstPersonas = lstPersonas;
    }
    
    
    
    
    
    
}
