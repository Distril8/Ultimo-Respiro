/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.hades.web;

import ec.edu.espe.distribuidas.hades.model.Camarote;
import ec.edu.espe.distribuidas.hades.model.Cliente;
import ec.edu.espe.distribuidas.hades.model.Reserva;
import ec.edu.espe.distribuidas.hades.model.TipoAlimentacion;
import ec.edu.espe.distribuidas.hades.model.Tour;
import ec.edu.espe.distribuidas.hades.service.CamaroteService;
import ec.edu.espe.distribuidas.hades.service.ClienteService;
import ec.edu.espe.distribuidas.hades.service.ReservaService;
import ec.edu.espe.distribuidas.hades.service.TipoAlimentacionService;
import ec.edu.espe.distribuidas.hades.service.TourService;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Hendrix
 */
@Named
@ViewScoped
public class ReservaBean  extends BaseBean implements Serializable{
    
   
    private List<Cliente> clientes;
    //private String clienteBusqueda;
    private List<Tour> tours;
    //private Integer tourBusqueda;
    
    private List<Camarote> camarotes;
    private Camarote camarote;
    private List<TipoAlimentacion> alimentaciones;
    private Reserva reserva;
    
    //private List<Camarote> listadoCamarotes;
    //private List<TipoAlimentacion> tiposDeAlimentacion;

    
    
    //private Reserva reserva;
    //private Camarote camarote;
    //private Cliente cliente;
    //private TipoAlimentacion alimentacion;
    //private Tour tour;
    
    private static final Logger LOG = Logger.getLogger(ReservaBean.class.getName());
    @Inject
    private ClienteService clienteService;
    @Inject
    private TourService tourService;
    @Inject
    private CamaroteService camaroteService;
    @Inject
    private TipoAlimentacionService alimentacionService;
    @Inject
    private ReservaService reservaService;
    
    @PostConstruct
    public void init() {
          
        this.clientes = this.clienteService.obtenerTodos();
        this.tours = this.tourService.obtenerTodos();
        this.camarotes = this.camaroteService.obtenerTodos();
        this.alimentaciones = this.alimentacionService.obtenerTodos();
        
        //this.listadoCamarotes = this.camaroteService.obtenerPorCrucero(listadoTours.get(0).getCrucero().getCodigo());
        //this.camarote = (this.camaroteService.obtenerInfoCamarote(listadoCamarotes.get(0).getCrucero().getCodigo(),(int) listadoCamarotes.get(0).getNumero()));
        //this.reserva.setCamarote(this.camaroteService.obtenerInfoCamarote(listadoCamarotes.get(0).getCrucero().getCodigo(),(int) listadoCamarotes.get(0).getNumero()));
        //System.out.println("Init: "+this.reserva.getCamarote().getTipoCamarote().getNombre());
        //System.out.println("Init2: "+this.reserva.getCamarote().getNumero());
    }
    
    @Override
    public void agregar() {
        //this.reserva = new Reserva();
        super.agregar();
        
    }
    
    public void buscar(){
        //this.clientes = this.clienteService.obtenerPorCodigo(this.clienteService.obtenerPorIdentificacion(this.clienteBusqueda));
        //this.tours = this.tourService.obtenerPorCodigoTour(this.tourService.obtenerPorCodigo(this.tourBusqueda));
        //LOG.info("clienteBusqueda: "+this.clienteBusqueda);
    }
    
    
    public void guardar() {
        this.reservaService.crear(this.reserva);
        
//        this.reserva.setCliente(this.clienteService.obtenerPorIdentificacion(this.cliente.getClientePK().getIdentificacion()));
//        this.reserva.setCamarote(this.camaroteService.obtenerInfoCamarote(this.tour.getCrucero().getCodigo(),(int) this.camarote.getNumero()));
//        
//        this.reserva.setCodigo(codRandom());
//        this.reserva.setIdentificacion(this.reserva.getCliente().getClientePK().getIdentificacion());
//        this.reserva.setTipoIdentificacion(this.reserva.getCliente().getClientePK().getTipoIdentificacion());
//        this.reserva.setCodTour(this.tour.getPk().getCodTour());
//        this.reserva.setCodTipoTour(this.tour.getPk().getCodTipoTour());
//        this.reserva.setCodCrucero(this.tour.getPk().getCodCrucero());
//        this.reserva.setCodCamarote(this.camarote.getPk().getCodCamarote());
//        this.reserva.setCodTipoCamarote(this.camarote.getPk().getCodTipoCamarote());
//        this.reserva.setCodTipoAlimentacion(this.alimentacion.getCodigo());
//
//        System.out.println("ID Cliente en reserva: "+ this.reserva.getIdentificacion());
//        System.out.println("Tipo de identificacion en reserva: "+ this.reserva.getTipoIdentificacion());
//        System.out.println("Cod Tour: "+ this.reserva.getCodTour());
//        System.out.println("Tipo Tour: "+ this.reserva.getCodTipoTour());
//        System.out.println("Cod Crucero: "+ this.reserva.getCodCrucero());
//        System.out.println("Camarote: "+ this.reserva.getCodCamarote());
//        System.out.println("Tipo camarote: "+ this.reserva.getCodTipoCamarote());
//        System.out.println("Tipo alimentacion: "+ this.reserva.getCodTipoAlimentacion());
//        System.out.println("Fecha: "+ this.reserva.getFechaEmision());       
//        System.out.println("random "+ codRandom());
//        
//        super.reset();
//        this.reservaService.crear(reserva);
//        FacesUtil.addMessageInfo("Se creo la reserva");
//        
    }
    
    public void cancelar() {
        super.reset();
        this.reserva = new Reserva();
    }
    
    /*public void actualizarCamarotes(){
        
        this.tour = (this.tourService.obtenerTourPorCodigo(this.tour.getPk().getCodTour()));
        System.out.println("Codigo del tour: "+this.tour.getPk().getCodTour());
        this.listadoCamarotes = this.camaroteService.obtenerPorCrucero(this.tour.getCrucero().getCodigo());
    }
    
    public void actualizarTipo(){
         System.out.println("Entro Tipo");
         System.out.println("Numero Camarote: "+this.camarote.getNumero());
         this.reserva.setCamarote(this.camaroteService.obtenerInfoCamarote(this.tour.getCrucero().getCodigo(),(int) this.camarote.getNumero()));
         this.camarote = (this.camaroteService.obtenerInfoCamarote(this.tour.getCrucero().getCodigo(),(int) this.camarote.getNumero()));
    }*/
    
    
    private String codRandom (){
        char[] chr={'A','C','D','1','2','3'};
		String aleatorio="";
 
		for(int i=0;i<=5;i++){
			aleatorio+=chr[(int)(Math.random()*6)];
		}
         return aleatorio;             
    }
    
    //Setters y Getters

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Tour> getTours() {
        return tours;
    }

    public List<Camarote> getCamarotes() {
        return camarotes;
    }

    public List<TipoAlimentacion> getAlimentaciones() {
        return alimentaciones;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
    

    public Camarote getCamarote() {
        return camarote;
    }

    public void setCamarote(Camarote camarote) {
        this.camarote = camarote;
    }
    
    /*public String getClienteBusqueda() {
        return clienteBusqueda;
    }

    public void setClienteBusqueda(String clienteBusqueda) {
        this.clienteBusqueda = clienteBusqueda;
    }

    public Integer getTourBusqueda() {
        return tourBusqueda;
    }

    public void setTourBusqueda(Integer tourBusqueda) {
        this.tourBusqueda = tourBusqueda;
    }*/

    
    
    
    
}
