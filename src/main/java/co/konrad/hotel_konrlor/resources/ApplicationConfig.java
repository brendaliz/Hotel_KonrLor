/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.resources;

import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author Carlos
 */
@ApplicationPath("/api")
public class ApplicationConfig extends Application{
    
    @Override
    public Set<Class<?>> getClasses(){
        Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
        addResourceClasses(resources);
        return resources;
    }
    
    private void addResourceClasses(Set<Class<?>> resources){
        resources.add(co.konrad.hotel_konrlor.resources.CadenaHoteleraResource.class);
        resources.add(co.konrad.hotel_konrlor.resources.ClienteOpinarHotelResource.class);
        resources.add(co.konrad.hotel_konrlor.resources.ClienteResource.class);
        resources.add(co.konrad.hotel_konrlor.resources.EmpleadoResource.class);
        resources.add(co.konrad.hotel_konrlor.resources.HabitacionResource.class);
        resources.add(co.konrad.hotel_konrlor.resources.HotelResource.class);
        resources.add(co.konrad.hotel_konrlor.resources.PagoCreditoResource.class);
        resources.add(co.konrad.hotel_konrlor.resources.PagoDebitoResource.class);
        resources.add(co.konrad.hotel_konrlor.resources.PagoResource.class);    
        resources.add(co.konrad.hotel_konrlor.resources.ProveedorPromocionHotelResource.class); 
        resources.add(co.konrad.hotel_konrlor.resources.ProveedorResource.class); 
        resources.add(co.konrad.hotel_konrlor.resources.ReservaResource.class); 
        resources.add(co.konrad.hotel_konrlor.resources.TipoAcomodacionResource.class); 
        resources.add(co.konrad.hotel_konrlor.resources.UsuarioResource.class); 
    }
}
