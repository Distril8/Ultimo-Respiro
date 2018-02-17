/*
 * Hades Cruise
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) Hades Cruise Corp.
 */
package ec.edu.espe.distribuidas.hades.web;

import ec.edu.espe.distribuidas.hades.model.Crucero;
import ec.edu.espe.distribuidas.hades.model.Reserva;
import ec.edu.espe.distribuidas.hades.model.TipoTour;
import ec.edu.espe.distribuidas.hades.model.Tour;
import ec.edu.espe.distribuidas.hades.service.CruceroService;
import ec.edu.espe.distribuidas.hades.service.ReservaService;
import ec.edu.espe.distribuidas.hades.service.TipoTourService;
import ec.edu.espe.distribuidas.hades.service.TourService;
import ec.edu.espe.distribuidas.hades.web.util.FacesUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Hades Cruise Corp.
 */
@Named
@ViewScoped
public class ReservaBean extends BaseBean implements Serializable {

    private List<Reserva> reservas;
    private Reserva reserva;
    private Reserva reservaSel;
    private List<TipoTour> tiposTours;
    private List<Crucero> cruceros;
    private List<Tour> tours;
    private Tour tour;

    @Inject
    private ReservaService reservaService;
    @Inject
    private TourService tourService;
    @Inject
    private TipoTourService tipoTourService;
    @Inject
    private CruceroService cruceroService;

    @PostConstruct
    public void init() {
        this.tours = this.tourService.obtenerTodos();
        this.tour = new Tour();
        this.tiposTours = this.tipoTourService.obtenerTodos();
        this.cruceros = this.cruceroService.obtenerTodos();
        this.reservas = this.reservaService.obtenerTodos();
        this.reserva = new Reserva();
    }

    @Override
    public void agregar() {
        this.reserva = new Reserva();
        this.reservas = this.reservaService.obtenerTodos();
        
        super.agregar();
    }

    public void cancelar() {
        super.reset();
        this.reserva = new Reserva();
        this.reservas = this.reservaService.obtenerTodos();
        
    }

//    @Override
//    public void modificar() {
//        super.modificar();
//        this.reserva = new Reserva();
//        this.tour.setCodigo(this.tourSel.getCodigo());
//        this.tour.setTipoTour(this.tourSel.getTipoTour());
//        this.tour.setCrucero(this.tourSel.getCrucero());
//        this.tour.setNombre(this.tourSel.getNombre());
//        this.tour.setDuracion(this.tourSel.getDuracion());
//        this.tour.setFechaInicio(this.tourSel.getFechaInicio());
//        this.tour.setFechaInicio(this.tourSel.getFechaFin());
//        this.tour.setPuertoEmbarque(this.tourSel.getPuertoEmbarque());
//        this.tour.setPuertoDesembarque(this.tourSel.getPuertoDesembarque());
//        this.tour.setPrecioBase(this.tourSel.getPrecioBase());
//        this.tour.setPorcentajeMenu(this.tourSel.getPorcentajeMenu());
//    }

//    public void eliminar() {
//        try {
//            this.tourService.eliminar(this.tourSel.getCodigo().toString());
//            this.tours = this.tourService.obtenerTodos();
//            FacesUtil.addMessageInfo("Se elimino el registro");
//            this.tourSel = null;
//        } catch (Exception e) {
//            FacesUtil.addMessageError(null, "No se puede eliminar el registro seleccionado. Verifique que no tenga informaci\u00f3n relacionada.");
//        }
//    }

    public void guardar() {
        try {

            if (this.enAgregar) {
                this.reservaService.crear(this.reserva);
                FacesUtil.addMessageInfo("Se agrego La reserva: " + this.reserva.getCodigo());
            } else {
                this.reservaService.modificar(this.reserva);
                FacesUtil.addMessageInfo("Se modific\u00f3 la Actividad con c\u00f3digo: " + this.reserva.getCodigo());
            }

        } catch (Exception e) {
            FacesUtil.addMessageError(null, "Ocurrí\u00f3 un error al actualizar la informaci\u00f3n");
        }

        super.reset();
        this.reserva = new Reserva();
        //this.actividadPK = new ActividadPK();
        this.reservas = this.reservaService.obtenerTodos();
        
        
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Reserva getReservaSel() {
        return reservaSel;
    }

    public void setReservaSel(Reserva reservaSel) {
        this.reservaSel = reservaSel;
    }

 

    public CruceroService getCruceroService() {
        return cruceroService;
    }

    public void setCruceroService(CruceroService cruceroService) {
        this.cruceroService = cruceroService;
    }

    public List<Tour> getTours() {
        return tours;
    }

    public List<TipoTour> getTiposTours() {
        return tiposTours;
    }

    public List<Crucero> getCruceros() {
        return cruceros;
    }
}
