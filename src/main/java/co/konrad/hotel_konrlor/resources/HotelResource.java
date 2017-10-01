/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.konrad.hotel_konrlor.resources;

import co.konrad.hotel_konrlor.dto.HotelDTO;
import co.konrad.hotel_konrlor.entities.HotelEntity;
import co.konrad.hotel_konrlor.logic.HotelLogic;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Carlos
 */
@Path("/hoteles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HotelResource {
    
    @EJB
    private HotelLogic hotelLogic;
    
    /**
     * Metodo GET
     * @return HotelDTO
     */
    @GET
    public List<HotelDTO> getHotelesList(){
        List<HotelEntity> hoteles = hotelLogic.getHoteles();
        return HotelDTO.toHotelList(hoteles);
    }

    /**
     * Metodo GET para obtener un solo objeto
     * @param id_hotel 
     * @return  List
     */
    @GET
    @Path("{id: \\d+}")
    public HotelDTO getHotel(@PathParam("id") Long id_hotel){
        HotelEntity hotel = hotelLogic.getHotel(id_hotel);
        if(hotel == null){
            throw new RuntimeException("El hotel no existe");
        }
        return new HotelDTO(hotel);
    }
    
    /**
     * Metodo POST creacion de hotel
     * @param hotel
     * @return HotelDTO
     */
    @POST
    public HotelDTO createHotel(HotelDTO hotel){
        return new HotelDTO(hotelLogic.createHotel(hotel.toEntity()));
    }
    
    /**
     * Metodo PUT actualizacion hotel
     * @param id_hotel 
     * @param hotel
     * @return HotelDTO
     */
    @PUT
    @Path("{hotelId: \\d+}")
    public HotelDTO updateHotel(@PathParam("hotelId") Long id_hotel, HotelDTO hotel){
        HotelEntity hotelEntity = hotelLogic.getHotel(id_hotel);
        if(hotelEntity == null){
            throw new RuntimeException("El hotel no existe");
        }
        return new HotelDTO(hotelLogic.updateHotel(id_hotel, hotel.toEntity()));
    }
    
    @DELETE
    @Path("{hotelId: \\d+}")
    public void deleteHotel(@PathParam("hotelId") Long id_hotel){
        HotelEntity hotelEntity = hotelLogic.getHotel(id_hotel);
        if(hotelEntity == null){
            throw new RuntimeException("El hotel no existe");
        }
        hotelLogic.deleteHotel(id_hotel);
    }
}
