/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Héctor Vix
 */
@Entity
@Table(name = "planta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Planta.findAll", query = "SELECT p FROM Planta p")
    , @NamedQuery(name = "Planta.findByPlantaId", query = "SELECT p FROM Planta p WHERE p.plantaId = :plantaId")
    , @NamedQuery(name = "Planta.findByCodigoe", query = "SELECT p FROM Planta p WHERE p.codigoe = :codigoe")
    , @NamedQuery(name = "Planta.findByNacion", query = "SELECT p FROM Planta p WHERE p.nacion = :nacion")
    , @NamedQuery(name = "Planta.findByNombren", query = "SELECT p FROM Planta p WHERE p.nombren = :nombren")
    , @NamedQuery(name = "Planta.findByNomcomunn", query = "SELECT p FROM Planta p WHERE p.nomcomunn = :nomcomunn")
    , @NamedQuery(name = "Planta.findByComsubespn", query = "SELECT p FROM Planta p WHERE p.comsubespn = :comsubespn")
    , @NamedQuery(name = "Planta.findByTaxasimiln", query = "SELECT p FROM Planta p WHERE p.taxasimiln = :taxasimiln")
    , @NamedQuery(name = "Planta.findByComidentn", query = "SELECT p FROM Planta p WHERE p.comidentn = :comidentn")
    , @NamedQuery(name = "Planta.findByComtaxn", query = "SELECT p FROM Planta p WHERE p.comtaxn = :comtaxn")
    , @NamedQuery(name = "Planta.findByRangog", query = "SELECT p FROM Planta p WHERE p.rangog = :rangog")
    , @NamedQuery(name = "Planta.findByRangon", query = "SELECT p FROM Planta p WHERE p.rangon = :rangon")
    , @NamedQuery(name = "Planta.findByAepeu", query = "SELECT p FROM Planta p WHERE p.aepeu = :aepeu")
    , @NamedQuery(name = "Planta.findByCites", query = "SELECT p FROM Planta p WHERE p.cites = :cites")
    , @NamedQuery(name = "Planta.findByUicn", query = "SELECT p FROM Planta p WHERE p.uicn = :uicn")
    , @NamedQuery(name = "Planta.findByRastreolen", query = "SELECT p FROM Planta p WHERE p.rastreolen = :rastreolen")
    , @NamedQuery(name = "Planta.findByProtnacion", query = "SELECT p FROM Planta p WHERE p.protnacion = :protnacion")
    , @NamedQuery(name = "Planta.findByMalezan", query = "SELECT p FROM Planta p WHERE p.malezan = :malezan")
    , @NamedQuery(name = "Planta.findByClasifinstn", query = "SELECT p FROM Planta p WHERE p.clasifinstn = :clasifinstn")
    , @NamedQuery(name = "Planta.findByComstatn", query = "SELECT p FROM Planta p WHERE p.comstatn = :comstatn")
    , @NamedQuery(name = "Planta.findByPriinventn", query = "SELECT p FROM Planta p WHERE p.priinventn = :priinventn")
    , @NamedQuery(name = "Planta.findByNecinventn", query = "SELECT p FROM Planta p WHERE p.necinventn = :necinventn")
    , @NamedQuery(name = "Planta.findByCominventn", query = "SELECT p FROM Planta p WHERE p.cominventn = :cominventn")
    , @NamedQuery(name = "Planta.findByRespropn", query = "SELECT p FROM Planta p WHERE p.respropn = :respropn")
    , @NamedQuery(name = "Planta.findByElevminn", query = "SELECT p FROM Planta p WHERE p.elevminn = :elevminn")
    , @NamedQuery(name = "Planta.findByElevmaxn", query = "SELECT p FROM Planta p WHERE p.elevmaxn = :elevmaxn")
    , @NamedQuery(name = "Planta.findByDisyuntn", query = "SELECT p FROM Planta p WHERE p.disyuntn = :disyuntn")
    , @NamedQuery(name = "Planta.findByPeriferican", query = "SELECT p FROM Planta p WHERE p.periferican = :periferican")
    , @NamedQuery(name = "Planta.findByComdistn", query = "SELECT p FROM Planta p WHERE p.comdistn = :comdistn")
    , @NamedQuery(name = "Planta.findByMarinon", query = "SELECT p FROM Planta p WHERE p.marinon = :marinon")
    , @NamedQuery(name = "Planta.findByEstuarinon", query = "SELECT p FROM Planta p WHERE p.estuarinon = :estuarinon")
    , @NamedQuery(name = "Planta.findByFluvialn", query = "SELECT p FROM Planta p WHERE p.fluvialn = :fluvialn")
    , @NamedQuery(name = "Planta.findByLacustren", query = "SELECT p FROM Planta p WHERE p.lacustren = :lacustren")
    , @NamedQuery(name = "Planta.findByPalustren", query = "SELECT p FROM Planta p WHERE p.palustren = :palustren")
    , @NamedQuery(name = "Planta.findByTerrestren", query = "SELECT p FROM Planta p WHERE p.terrestren = :terrestren")
    , @NamedQuery(name = "Planta.findByComhabn", query = "SELECT p FROM Planta p WHERE p.comhabn = :comhabn")
    , @NamedQuery(name = "Planta.findByComecoln", query = "SELECT p FROM Planta p WHERE p.comecoln = :comecoln")
    , @NamedQuery(name = "Planta.findByComfenoln", query = "SELECT p FROM Planta p WHERE p.comfenoln = :comfenoln")
    , @NamedQuery(name = "Planta.findByComrepn", query = "SELECT p FROM Planta p WHERE p.comrepn = :comrepn")
    , @NamedQuery(name = "Planta.findByCommanejon", query = "SELECT p FROM Planta p WHERE p.commanejon = :commanejon")
    , @NamedQuery(name = "Planta.findByRcpnopc1", query = "SELECT p FROM Planta p WHERE p.rcpnopc1 = :rcpnopc1")
    , @NamedQuery(name = "Planta.findByRcpnopc2", query = "SELECT p FROM Planta p WHERE p.rcpnopc2 = :rcpnopc2")
    , @NamedQuery(name = "Planta.findByRcpnopc3", query = "SELECT p FROM Planta p WHERE p.rcpnopc3 = :rcpnopc3")
    , @NamedQuery(name = "Planta.findByRcpnopc4", query = "SELECT p FROM Planta p WHERE p.rcpnopc4 = :rcpnopc4")
    , @NamedQuery(name = "Planta.findByRcpnopc5", query = "SELECT p FROM Planta p WHERE p.rcpnopc5 = :rcpnopc5")
    , @NamedQuery(name = "Planta.findByCodfuente", query = "SELECT p FROM Planta p WHERE p.codfuente = :codfuente")
    , @NamedQuery(name = "Planta.findByCita", query = "SELECT p FROM Planta p WHERE p.cita = :cita")
    , @NamedQuery(name = "Planta.findByTransparen", query = "SELECT p FROM Planta p WHERE p.transparen = :transparen")
    , @NamedQuery(name = "Planta.findByRefg", query = "SELECT p FROM Planta p WHERE p.refg = :refg")
    , @NamedQuery(name = "Planta.findByRefn", query = "SELECT p FROM Planta p WHERE p.refn = :refn")
    , @NamedQuery(name = "Planta.findByEdicionn", query = "SELECT p FROM Planta p WHERE p.edicionn = :edicionn")
    , @NamedQuery(name = "Planta.findByAutoredn", query = "SELECT p FROM Planta p WHERE p.autoredn = :autoredn")
    , @NamedQuery(name = "Planta.findByActualizan", query = "SELECT p FROM Planta p WHERE p.actualizan = :actualizan")
    , @NamedQuery(name = "Planta.findByNenea1", query = "SELECT p FROM Planta p WHERE p.nenea1 = :nenea1")
    , @NamedQuery(name = "Planta.findByNenea2", query = "SELECT p FROM Planta p WHERE p.nenea2 = :nenea2")
    , @NamedQuery(name = "Planta.findByNenea3", query = "SELECT p FROM Planta p WHERE p.nenea3 = :nenea3")
    , @NamedQuery(name = "Planta.findByNenea4", query = "SELECT p FROM Planta p WHERE p.nenea4 = :nenea4")
    , @NamedQuery(name = "Planta.findByNmara1", query = "SELECT p FROM Planta p WHERE p.nmara1 = :nmara1")
    , @NamedQuery(name = "Planta.findByNmara2", query = "SELECT p FROM Planta p WHERE p.nmara2 = :nmara2")
    , @NamedQuery(name = "Planta.findByNmara3", query = "SELECT p FROM Planta p WHERE p.nmara3 = :nmara3")
    , @NamedQuery(name = "Planta.findByNmara4", query = "SELECT p FROM Planta p WHERE p.nmara4 = :nmara4")
    , @NamedQuery(name = "Planta.findByNmaya1", query = "SELECT p FROM Planta p WHERE p.nmaya1 = :nmaya1")
    , @NamedQuery(name = "Planta.findByNmaya2", query = "SELECT p FROM Planta p WHERE p.nmaya2 = :nmaya2")
    , @NamedQuery(name = "Planta.findByNmaya3", query = "SELECT p FROM Planta p WHERE p.nmaya3 = :nmaya3")
    , @NamedQuery(name = "Planta.findByNmaya4", query = "SELECT p FROM Planta p WHERE p.nmaya4 = :nmaya4")
    , @NamedQuery(name = "Planta.findByNjula1", query = "SELECT p FROM Planta p WHERE p.njula1 = :njula1")
    , @NamedQuery(name = "Planta.findByNjula2", query = "SELECT p FROM Planta p WHERE p.njula2 = :njula2")
    , @NamedQuery(name = "Planta.findByNjula3", query = "SELECT p FROM Planta p WHERE p.njula3 = :njula3")
    , @NamedQuery(name = "Planta.findByNjula4", query = "SELECT p FROM Planta p WHERE p.njula4 = :njula4")
    , @NamedQuery(name = "Planta.findByNseta1", query = "SELECT p FROM Planta p WHERE p.nseta1 = :nseta1")
    , @NamedQuery(name = "Planta.findByNseta2", query = "SELECT p FROM Planta p WHERE p.nseta2 = :nseta2")
    , @NamedQuery(name = "Planta.findByNseta3", query = "SELECT p FROM Planta p WHERE p.nseta3 = :nseta3")
    , @NamedQuery(name = "Planta.findByNseta4", query = "SELECT p FROM Planta p WHERE p.nseta4 = :nseta4")
    , @NamedQuery(name = "Planta.findByNnova1", query = "SELECT p FROM Planta p WHERE p.nnova1 = :nnova1")
    , @NamedQuery(name = "Planta.findByNnova2", query = "SELECT p FROM Planta p WHERE p.nnova2 = :nnova2")
    , @NamedQuery(name = "Planta.findByNnova3", query = "SELECT p FROM Planta p WHERE p.nnova3 = :nnova3")
    , @NamedQuery(name = "Planta.findByNnova4", query = "SELECT p FROM Planta p WHERE p.nnova4 = :nnova4")
    , @NamedQuery(name = "Planta.findByNeneb1", query = "SELECT p FROM Planta p WHERE p.neneb1 = :neneb1")
    , @NamedQuery(name = "Planta.findByNeneb2", query = "SELECT p FROM Planta p WHERE p.neneb2 = :neneb2")
    , @NamedQuery(name = "Planta.findByNeneb3", query = "SELECT p FROM Planta p WHERE p.neneb3 = :neneb3")
    , @NamedQuery(name = "Planta.findByNeneb4", query = "SELECT p FROM Planta p WHERE p.neneb4 = :neneb4")
    , @NamedQuery(name = "Planta.findByNmarb1", query = "SELECT p FROM Planta p WHERE p.nmarb1 = :nmarb1")
    , @NamedQuery(name = "Planta.findByNmarb2", query = "SELECT p FROM Planta p WHERE p.nmarb2 = :nmarb2")
    , @NamedQuery(name = "Planta.findByNmarb3", query = "SELECT p FROM Planta p WHERE p.nmarb3 = :nmarb3")
    , @NamedQuery(name = "Planta.findByNmarb4", query = "SELECT p FROM Planta p WHERE p.nmarb4 = :nmarb4")
    , @NamedQuery(name = "Planta.findByNmayb1", query = "SELECT p FROM Planta p WHERE p.nmayb1 = :nmayb1")
    , @NamedQuery(name = "Planta.findByNmayb2", query = "SELECT p FROM Planta p WHERE p.nmayb2 = :nmayb2")
    , @NamedQuery(name = "Planta.findByNmayb3", query = "SELECT p FROM Planta p WHERE p.nmayb3 = :nmayb3")
    , @NamedQuery(name = "Planta.findByNmayb4", query = "SELECT p FROM Planta p WHERE p.nmayb4 = :nmayb4")
    , @NamedQuery(name = "Planta.findByNjulb1", query = "SELECT p FROM Planta p WHERE p.njulb1 = :njulb1")
    , @NamedQuery(name = "Planta.findByNjulb2", query = "SELECT p FROM Planta p WHERE p.njulb2 = :njulb2")
    , @NamedQuery(name = "Planta.findByNjulb3", query = "SELECT p FROM Planta p WHERE p.njulb3 = :njulb3")
    , @NamedQuery(name = "Planta.findByNjulb4", query = "SELECT p FROM Planta p WHERE p.njulb4 = :njulb4")
    , @NamedQuery(name = "Planta.findByNsetb1", query = "SELECT p FROM Planta p WHERE p.nsetb1 = :nsetb1")
    , @NamedQuery(name = "Planta.findByNsetb2", query = "SELECT p FROM Planta p WHERE p.nsetb2 = :nsetb2")
    , @NamedQuery(name = "Planta.findByNsetb3", query = "SELECT p FROM Planta p WHERE p.nsetb3 = :nsetb3")
    , @NamedQuery(name = "Planta.findByNsetb4", query = "SELECT p FROM Planta p WHERE p.nsetb4 = :nsetb4")
    , @NamedQuery(name = "Planta.findByNnovb1", query = "SELECT p FROM Planta p WHERE p.nnovb1 = :nnovb1")
    , @NamedQuery(name = "Planta.findByNnovb2", query = "SELECT p FROM Planta p WHERE p.nnovb2 = :nnovb2")
    , @NamedQuery(name = "Planta.findByNnovb3", query = "SELECT p FROM Planta p WHERE p.nnovb3 = :nnovb3")
    , @NamedQuery(name = "Planta.findByNnovb4", query = "SELECT p FROM Planta p WHERE p.nnovb4 = :nnovb4")})
public class Planta implements Serializable {

    @Column(name = "nfebb1")
    private String nfebb1;
    @Column(name = "nfebb2")
    private String nfebb2;
    @Column(name = "nfebb3")
    private String nfebb3;
    @Column(name = "nfebb4")
    private String nfebb4;
    @Column(name = "nabrb1")
    private String nabrb1;
    @Column(name = "nabrb2")
    private String nabrb2;
    @Column(name = "nabrb3")
    private String nabrb3;
    @Column(name = "nabrb4")
    private String nabrb4;
    @Column(name = "njunb1")
    private String njunb1;
    @Column(name = "njunb2")
    private String njunb2;
    @Column(name = "njunb3")
    private String njunb3;
    @Column(name = "njunb4")
    private String njunb4;
    @Column(name = "nagob1")
    private String nagob1;
    @Column(name = "nagob2")
    private String nagob2;
    @Column(name = "nagob3")
    private String nagob3;
    @Column(name = "nagob4")
    private String nagob4;
    @Column(name = "noctb1")
    private String noctb1;
    @Column(name = "noctb2")
    private String noctb2;
    @Column(name = "noctb3")
    private String noctb3;
    @Column(name = "noctb4")
    private String noctb4;
    @Column(name = "ndicb1")
    private String ndicb1;
    @Column(name = "ndicb2")
    private String ndicb2;
    @Column(name = "ndicb3")
    private String ndicb3;
    @Column(name = "ndicb4")
    private String ndicb4;

    @Column(name = "nfeba1")
    private String nfeba1;
    @Column(name = "nfeba2")
    private String nfeba2;
    @Column(name = "nfeba3")
    private String nfeba3;
    @Column(name = "nfeba4")
    private String nfeba4;
    @Column(name = "nabra1")
    private String nabra1;
    @Column(name = "nabra2")
    private String nabra2;
    @Column(name = "nabra3")
    private String nabra3;
    @Column(name = "nabra4")
    private String nabra4;
    @Column(name = "njuna1")
    private String njuna1;
    @Column(name = "njuna2")
    private String njuna2;
    @Column(name = "njuna3")
    private String njuna3;
    @Column(name = "njuna4")
    private String njuna4;
    @Column(name = "nagoa1")
    private String nagoa1;
    @Column(name = "nagoa2")
    private String nagoa2;
    @Column(name = "nagoa3")
    private String nagoa3;
    @Column(name = "nagoa4")
    private String nagoa4;
    @Column(name = "nocta1")
    private String nocta1;
    @Column(name = "nocta2")
    private String nocta2;
    @Column(name = "nocta3")
    private String nocta3;
    @Column(name = "nocta4")
    private String nocta4;
    @Column(name = "ndica1")
    private String ndica1;
    @Column(name = "ndica2")
    private String ndica2;
    @Column(name = "ndica3")
    private String ndica3;
    @Column(name = "ndica4")
    private String ndica4;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "planta_id")
    private Integer plantaId;
    @Column(name = "codigoe")
    private String codigoe;
    @Column(name = "nacion")
    private String nacion;
    @Column(name = "nombren")
    private String nombren;
    @Column(name = "nomcomunn")
    private String nomcomunn;
    @Column(name = "comsubespn")
    private String comsubespn;
    @Column(name = "taxasimiln")
    private String taxasimiln;
    @Column(name = "comidentn")
    private String comidentn;
    @Column(name = "comtaxn")
    private String comtaxn;
    @Column(name = "rangog")
    private String rangog;
    @Column(name = "rangon")
    private String rangon;
    @Column(name = "aepeu")
    private String aepeu;
    @Column(name = "cites")
    private String cites;
    @Column(name = "uicn")
    private String uicn;
    @Column(name = "rastreolen")
    private String rastreolen;
    @Column(name = "protnacion")
    private String protnacion;
    @Column(name = "malezan")
    private String malezan;
    @Column(name = "clasifinstn")
    private String clasifinstn;
    @Column(name = "comstatn")
    private String comstatn;
    @Column(name = "priinventn")
    private String priinventn;
    @Column(name = "necinventn")
    private String necinventn;
    @Column(name = "cominventn")
    private String cominventn;
    @Column(name = "respropn")
    private String respropn;
    @Column(name = "elevminn")
    private Integer elevminn;
    @Column(name = "elevmaxn")
    private Integer elevmaxn;
    @Column(name = "disyuntn")
    private String disyuntn;
    @Column(name = "periferican")
    private String periferican;
    @Column(name = "comdistn")
    private String comdistn;
    @Column(name = "marinon")
    private String marinon;
    @Column(name = "estuarinon")
    private String estuarinon;
    @Column(name = "fluvialn")
    private String fluvialn;
    @Column(name = "lacustren")
    private String lacustren;
    @Column(name = "palustren")
    private String palustren;
    @Column(name = "terrestren")
    private String terrestren;
    @Column(name = "comhabn")
    private String comhabn;
    @Column(name = "comecoln")
    private String comecoln;
    @Column(name = "comfenoln")
    private String comfenoln;
    @Column(name = "comrepn")
    private String comrepn;
    @Column(name = "commanejon")
    private String commanejon;
    @Column(name = "rcpnopc1")
    private String rcpnopc1;
    @Column(name = "rcpnopc2")
    private String rcpnopc2;
    @Column(name = "rcpnopc3")
    private String rcpnopc3;
    @Column(name = "rcpnopc4")
    private String rcpnopc4;
    @Column(name = "rcpnopc5")
    private String rcpnopc5;
    @Column(name = "codfuente")
    private String codfuente;
    @Column(name = "cita")
    private String cita;
    @Column(name = "transparen")
    private String transparen;
    @Column(name = "refg")
    private String refg;
    @Column(name = "refn")
    private String refn;
    @Column(name = "edicionn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date edicionn;
    @Column(name = "autoredn")
    private String autoredn;
    @Column(name = "actualizan")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actualizan;
    @Column(name = "nenea1")
    private String nenea1;
    @Column(name = "nenea2")
    private String nenea2;
    @Column(name = "nenea3")
    private String nenea3;
    @Column(name = "nenea4")
    private String nenea4;
    @Column(name = "nmara1")
    private String nmara1;
    @Column(name = "nmara2")
    private String nmara2;
    @Column(name = "nmara3")
    private String nmara3;
    @Column(name = "nmara4")
    private String nmara4;
    @Column(name = "nmaya1")
    private String nmaya1;
    @Column(name = "nmaya2")
    private String nmaya2;
    @Column(name = "nmaya3")
    private String nmaya3;
    @Column(name = "nmaya4")
    private String nmaya4;
    @Column(name = "njula1")
    private String njula1;
    @Column(name = "njula2")
    private String njula2;
    @Column(name = "njula3")
    private String njula3;
    @Column(name = "njula4")
    private String njula4;
    @Column(name = "nseta1")
    private String nseta1;
    @Column(name = "nseta2")
    private String nseta2;
    @Column(name = "nseta3")
    private String nseta3;
    @Column(name = "nseta4")
    private String nseta4;
    @Column(name = "nnova1")
    private String nnova1;
    @Column(name = "nnova2")
    private String nnova2;
    @Column(name = "nnova3")
    private String nnova3;
    @Column(name = "nnova4")
    private String nnova4;
    @Column(name = "neneb1")
    private String neneb1;
    @Column(name = "neneb2")
    private String neneb2;
    @Column(name = "neneb3")
    private String neneb3;
    @Column(name = "neneb4")
    private String neneb4;
    @Column(name = "nmarb1")
    private String nmarb1;
    @Column(name = "nmarb2")
    private String nmarb2;
    @Column(name = "nmarb3")
    private String nmarb3;
    @Column(name = "nmarb4")
    private String nmarb4;
    @Column(name = "nmayb1")
    private String nmayb1;
    @Column(name = "nmayb2")
    private String nmayb2;
    @Column(name = "nmayb3")
    private String nmayb3;
    @Column(name = "nmayb4")
    private String nmayb4;
    @Column(name = "njulb1")
    private String njulb1;
    @Column(name = "njulb2")
    private String njulb2;
    @Column(name = "njulb3")
    private String njulb3;
    @Column(name = "njulb4")
    private String njulb4;
    @Column(name = "nsetb1")
    private String nsetb1;
    @Column(name = "nsetb2")
    private String nsetb2;
    @Column(name = "nsetb3")
    private String nsetb3;
    @Column(name = "nsetb4")
    private String nsetb4;
    @Column(name = "nnovb1")
    private String nnovb1;
    @Column(name = "nnovb2")
    private String nnovb2;
    @Column(name = "nnovb3")
    private String nnovb3;
    @Column(name = "nnovb4")
    private String nnovb4;
    @JoinColumn(name = "CARACTERIZACION_caracterizacion_id", referencedColumnName = "caracterizacion_id")
    @ManyToOne
    private Caracterizacion cARACTERIZACIONcaracterizacionid;
    @OneToMany(mappedBy = "pLANTAplantaid")
    private List<Foto> fotoList;
    @OneToMany(mappedBy = "pLANTAplantaid")
    private List<Distribucion> distribucionList;

    public Planta() {
    }

    public Planta(Integer plantaId) {
        this.plantaId = plantaId;
    }

    public Integer getPlantaId() {
        return plantaId;
    }

    public void setPlantaId(Integer plantaId) {
        this.plantaId = plantaId;
    }

    public String getCodigoe() {
        return codigoe;
    }

    public void setCodigoe(String codigoe) {
        this.codigoe = codigoe;
    }

    public String getNacion() {
        return nacion;
    }

    public void setNacion(String nacion) {
        this.nacion = nacion;
    }

    public String getNombren() {
        return nombren;
    }

    public void setNombren(String nombren) {
        this.nombren = nombren;
    }

    public String getNomcomunn() {
        return nomcomunn;
    }

    public void setNomcomunn(String nomcomunn) {
        this.nomcomunn = nomcomunn;
    }

    public String getComsubespn() {
        return comsubespn;
    }

    public void setComsubespn(String comsubespn) {
        this.comsubespn = comsubespn;
    }

    public String getTaxasimiln() {
        return taxasimiln;
    }

    public void setTaxasimiln(String taxasimiln) {
        this.taxasimiln = taxasimiln;
    }

    public String getComidentn() {
        return comidentn;
    }

    public void setComidentn(String comidentn) {
        this.comidentn = comidentn;
    }

    public String getComtaxn() {
        return comtaxn;
    }

    public void setComtaxn(String comtaxn) {
        this.comtaxn = comtaxn;
    }

    public String getRangog() {
        return rangog;
    }

    public void setRangog(String rangog) {
        this.rangog = rangog;
    }

    public String getRangon() {
        return rangon;
    }

    public void setRangon(String rangon) {
        this.rangon = rangon;
    }

    public String getAepeu() {
        return aepeu;
    }

    public void setAepeu(String aepeu) {
        this.aepeu = aepeu;
    }

    public String getCites() {
        return cites;
    }

    public void setCites(String cites) {
        this.cites = cites;
    }

    public String getUicn() {
        return uicn;
    }

    public void setUicn(String uicn) {
        this.uicn = uicn;
    }

    public String getRastreolen() {
        return rastreolen;
    }

    public void setRastreolen(String rastreolen) {
        this.rastreolen = rastreolen;
    }

    public String getProtnacion() {
        return protnacion;
    }

    public void setProtnacion(String protnacion) {
        this.protnacion = protnacion;
    }

    public String getMalezan() {
        return malezan;
    }

    public void setMalezan(String malezan) {
        this.malezan = malezan;
    }

    public String getClasifinstn() {
        return clasifinstn;
    }

    public void setClasifinstn(String clasifinstn) {
        this.clasifinstn = clasifinstn;
    }

    public String getComstatn() {
        return comstatn;
    }

    public void setComstatn(String comstatn) {
        this.comstatn = comstatn;
    }

    public String getPriinventn() {
        return priinventn;
    }

    public void setPriinventn(String priinventn) {
        this.priinventn = priinventn;
    }

    public String getNecinventn() {
        return necinventn;
    }

    public void setNecinventn(String necinventn) {
        this.necinventn = necinventn;
    }

    public String getCominventn() {
        return cominventn;
    }

    public void setCominventn(String cominventn) {
        this.cominventn = cominventn;
    }

    public String getRespropn() {
        return respropn;
    }

    public void setRespropn(String respropn) {
        this.respropn = respropn;
    }

    public Integer getElevminn() {
        return elevminn;
    }

    public void setElevminn(Integer elevminn) {
        this.elevminn = elevminn;
    }

    public Integer getElevmaxn() {
        return elevmaxn;
    }

    public void setElevmaxn(Integer elevmaxn) {
        this.elevmaxn = elevmaxn;
    }

    public String getDisyuntn() {
        return disyuntn;
    }

    public void setDisyuntn(String disyuntn) {
        this.disyuntn = disyuntn;
    }

    public String getPeriferican() {
        return periferican;
    }

    public void setPeriferican(String periferican) {
        this.periferican = periferican;
    }

    public String getComdistn() {
        return comdistn;
    }

    public void setComdistn(String comdistn) {
        this.comdistn = comdistn;
    }

    public String getMarinon() {
        return marinon;
    }

    public void setMarinon(String marinon) {
        this.marinon = marinon;
    }

    public String getEstuarinon() {
        return estuarinon;
    }

    public void setEstuarinon(String estuarinon) {
        this.estuarinon = estuarinon;
    }

    public String getFluvialn() {
        return fluvialn;
    }

    public void setFluvialn(String fluvialn) {
        this.fluvialn = fluvialn;
    }

    public String getLacustren() {
        return lacustren;
    }

    public void setLacustren(String lacustren) {
        this.lacustren = lacustren;
    }

    public String getPalustren() {
        return palustren;
    }

    public void setPalustren(String palustren) {
        this.palustren = palustren;
    }

    public String getTerrestren() {
        return terrestren;
    }

    public void setTerrestren(String terrestren) {
        this.terrestren = terrestren;
    }

    public String getComhabn() {
        return comhabn;
    }

    public void setComhabn(String comhabn) {
        this.comhabn = comhabn;
    }

    public String getComecoln() {
        return comecoln;
    }

    public void setComecoln(String comecoln) {
        this.comecoln = comecoln;
    }

    public String getComfenoln() {
        return comfenoln;
    }

    public void setComfenoln(String comfenoln) {
        this.comfenoln = comfenoln;
    }

    public String getComrepn() {
        return comrepn;
    }

    public void setComrepn(String comrepn) {
        this.comrepn = comrepn;
    }

    public String getCommanejon() {
        return commanejon;
    }

    public void setCommanejon(String commanejon) {
        this.commanejon = commanejon;
    }

    public String getRcpnopc1() {
        return rcpnopc1;
    }

    public void setRcpnopc1(String rcpnopc1) {
        this.rcpnopc1 = rcpnopc1;
    }

    public String getRcpnopc2() {
        return rcpnopc2;
    }

    public void setRcpnopc2(String rcpnopc2) {
        this.rcpnopc2 = rcpnopc2;
    }

    public String getRcpnopc3() {
        return rcpnopc3;
    }

    public void setRcpnopc3(String rcpnopc3) {
        this.rcpnopc3 = rcpnopc3;
    }

    public String getRcpnopc4() {
        return rcpnopc4;
    }

    public void setRcpnopc4(String rcpnopc4) {
        this.rcpnopc4 = rcpnopc4;
    }

    public String getRcpnopc5() {
        return rcpnopc5;
    }

    public void setRcpnopc5(String rcpnopc5) {
        this.rcpnopc5 = rcpnopc5;
    }

    public String getCodfuente() {
        return codfuente;
    }

    public void setCodfuente(String codfuente) {
        this.codfuente = codfuente;
    }

    public String getCita() {
        return cita;
    }

    public void setCita(String cita) {
        this.cita = cita;
    }

    public String getTransparen() {
        return transparen;
    }

    public void setTransparen(String transparen) {
        this.transparen = transparen;
    }

    public String getRefg() {
        return refg;
    }

    public void setRefg(String refg) {
        this.refg = refg;
    }

    public String getRefn() {
        return refn;
    }

    public void setRefn(String refn) {
        this.refn = refn;
    }

    public Date getEdicionn() {
        return edicionn;
    }

    public void setEdicionn(Date edicionn) {
        this.edicionn = edicionn;
    }

    public String getAutoredn() {
        return autoredn;
    }

    public void setAutoredn(String autoredn) {
        this.autoredn = autoredn;
    }

    public Date getActualizan() {
        return actualizan;
    }

    public void setActualizan(Date actualizan) {
        this.actualizan = actualizan;
    }

    public String getNenea1() {
        return nenea1;
    }

    public void setNenea1(String nenea1) {
        this.nenea1 = nenea1;
    }

    public String getNenea2() {
        return nenea2;
    }

    public void setNenea2(String nenea2) {
        this.nenea2 = nenea2;
    }

    public String getNenea3() {
        return nenea3;
    }

    public void setNenea3(String nenea3) {
        this.nenea3 = nenea3;
    }

    public String getNenea4() {
        return nenea4;
    }

    public void setNenea4(String nenea4) {
        this.nenea4 = nenea4;
    }

    public String getNmara1() {
        return nmara1;
    }

    public void setNmara1(String nmara1) {
        this.nmara1 = nmara1;
    }

    public String getNmara2() {
        return nmara2;
    }

    public void setNmara2(String nmara2) {
        this.nmara2 = nmara2;
    }

    public String getNmara3() {
        return nmara3;
    }

    public void setNmara3(String nmara3) {
        this.nmara3 = nmara3;
    }

    public String getNmara4() {
        return nmara4;
    }

    public void setNmara4(String nmara4) {
        this.nmara4 = nmara4;
    }

    public String getNmaya1() {
        return nmaya1;
    }

    public void setNmaya1(String nmaya1) {
        this.nmaya1 = nmaya1;
    }

    public String getNmaya2() {
        return nmaya2;
    }

    public void setNmaya2(String nmaya2) {
        this.nmaya2 = nmaya2;
    }

    public String getNmaya3() {
        return nmaya3;
    }

    public void setNmaya3(String nmaya3) {
        this.nmaya3 = nmaya3;
    }

    public String getNmaya4() {
        return nmaya4;
    }

    public void setNmaya4(String nmaya4) {
        this.nmaya4 = nmaya4;
    }

    public String getNjula1() {
        return njula1;
    }

    public void setNjula1(String njula1) {
        this.njula1 = njula1;
    }

    public String getNjula2() {
        return njula2;
    }

    public void setNjula2(String njula2) {
        this.njula2 = njula2;
    }

    public String getNjula3() {
        return njula3;
    }

    public void setNjula3(String njula3) {
        this.njula3 = njula3;
    }

    public String getNjula4() {
        return njula4;
    }

    public void setNjula4(String njula4) {
        this.njula4 = njula4;
    }

    public String getNseta1() {
        return nseta1;
    }

    public void setNseta1(String nseta1) {
        this.nseta1 = nseta1;
    }

    public String getNseta2() {
        return nseta2;
    }

    public void setNseta2(String nseta2) {
        this.nseta2 = nseta2;
    }

    public String getNseta3() {
        return nseta3;
    }

    public void setNseta3(String nseta3) {
        this.nseta3 = nseta3;
    }

    public String getNseta4() {
        return nseta4;
    }

    public void setNseta4(String nseta4) {
        this.nseta4 = nseta4;
    }

    public String getNnova1() {
        return nnova1;
    }

    public void setNnova1(String nnova1) {
        this.nnova1 = nnova1;
    }

    public String getNnova2() {
        return nnova2;
    }

    public void setNnova2(String nnova2) {
        this.nnova2 = nnova2;
    }

    public String getNnova3() {
        return nnova3;
    }

    public void setNnova3(String nnova3) {
        this.nnova3 = nnova3;
    }

    public String getNnova4() {
        return nnova4;
    }

    public void setNnova4(String nnova4) {
        this.nnova4 = nnova4;
    }

    public String getNeneb1() {
        return neneb1;
    }

    public void setNeneb1(String neneb1) {
        this.neneb1 = neneb1;
    }

    public String getNeneb2() {
        return neneb2;
    }

    public void setNeneb2(String neneb2) {
        this.neneb2 = neneb2;
    }

    public String getNeneb3() {
        return neneb3;
    }

    public void setNeneb3(String neneb3) {
        this.neneb3 = neneb3;
    }

    public String getNeneb4() {
        return neneb4;
    }

    public void setNeneb4(String neneb4) {
        this.neneb4 = neneb4;
    }

    public String getNmarb1() {
        return nmarb1;
    }

    public void setNmarb1(String nmarb1) {
        this.nmarb1 = nmarb1;
    }

    public String getNmarb2() {
        return nmarb2;
    }

    public void setNmarb2(String nmarb2) {
        this.nmarb2 = nmarb2;
    }

    public String getNmarb3() {
        return nmarb3;
    }

    public void setNmarb3(String nmarb3) {
        this.nmarb3 = nmarb3;
    }

    public String getNmarb4() {
        return nmarb4;
    }

    public void setNmarb4(String nmarb4) {
        this.nmarb4 = nmarb4;
    }

    public String getNmayb1() {
        return nmayb1;
    }

    public void setNmayb1(String nmayb1) {
        this.nmayb1 = nmayb1;
    }

    public String getNmayb2() {
        return nmayb2;
    }

    public void setNmayb2(String nmayb2) {
        this.nmayb2 = nmayb2;
    }

    public String getNmayb3() {
        return nmayb3;
    }

    public void setNmayb3(String nmayb3) {
        this.nmayb3 = nmayb3;
    }

    public String getNmayb4() {
        return nmayb4;
    }

    public void setNmayb4(String nmayb4) {
        this.nmayb4 = nmayb4;
    }

    public String getNjulb1() {
        return njulb1;
    }

    public void setNjulb1(String njulb1) {
        this.njulb1 = njulb1;
    }

    public String getNjulb2() {
        return njulb2;
    }

    public void setNjulb2(String njulb2) {
        this.njulb2 = njulb2;
    }

    public String getNjulb3() {
        return njulb3;
    }

    public void setNjulb3(String njulb3) {
        this.njulb3 = njulb3;
    }

    public String getNjulb4() {
        return njulb4;
    }

    public void setNjulb4(String njulb4) {
        this.njulb4 = njulb4;
    }

    public String getNsetb1() {
        return nsetb1;
    }

    public void setNsetb1(String nsetb1) {
        this.nsetb1 = nsetb1;
    }

    public String getNsetb2() {
        return nsetb2;
    }

    public void setNsetb2(String nsetb2) {
        this.nsetb2 = nsetb2;
    }

    public String getNsetb3() {
        return nsetb3;
    }

    public void setNsetb3(String nsetb3) {
        this.nsetb3 = nsetb3;
    }

    public String getNsetb4() {
        return nsetb4;
    }

    public void setNsetb4(String nsetb4) {
        this.nsetb4 = nsetb4;
    }

    public String getNnovb1() {
        return nnovb1;
    }

    public void setNnovb1(String nnovb1) {
        this.nnovb1 = nnovb1;
    }

    public String getNnovb2() {
        return nnovb2;
    }

    public void setNnovb2(String nnovb2) {
        this.nnovb2 = nnovb2;
    }

    public String getNnovb3() {
        return nnovb3;
    }

    public void setNnovb3(String nnovb3) {
        this.nnovb3 = nnovb3;
    }

    public String getNnovb4() {
        return nnovb4;
    }

    public void setNnovb4(String nnovb4) {
        this.nnovb4 = nnovb4;
    }

    public Caracterizacion getCARACTERIZACIONcaracterizacionid() {
        return cARACTERIZACIONcaracterizacionid;
    }

    public void setCARACTERIZACIONcaracterizacionid(Caracterizacion cARACTERIZACIONcaracterizacionid) {
        this.cARACTERIZACIONcaracterizacionid = cARACTERIZACIONcaracterizacionid;
    }

    @XmlTransient
    public List<Foto> getFotoList() {
        return fotoList;
    }

    public void setFotoList(List<Foto> fotoList) {
        this.fotoList = fotoList;
    }

    @XmlTransient
    public List<Distribucion> getDistribucionList() {
        return distribucionList;
    }

    public void setDistribucionList(List<Distribucion> distribucionList) {
        this.distribucionList = distribucionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (plantaId != null ? plantaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Planta)) {
            return false;
        }
        Planta other = (Planta) object;
        if ((this.plantaId == null && other.plantaId != null) || (this.plantaId != null && !this.plantaId.equals(other.plantaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdc.com.api.modelo.Planta[ plantaId=" + plantaId + " ]";
    }

    public String getNfeba1() {
        return nfeba1;
    }

    public void setNfeba1(String nfeba1) {
        this.nfeba1 = nfeba1;
    }

    public String getNfeba2() {
        return nfeba2;
    }

    public void setNfeba2(String nfeba2) {
        this.nfeba2 = nfeba2;
    }

    public String getNfeba3() {
        return nfeba3;
    }

    public void setNfeba3(String nfeba3) {
        this.nfeba3 = nfeba3;
    }

    public String getNfeba4() {
        return nfeba4;
    }

    public void setNfeba4(String nfeba4) {
        this.nfeba4 = nfeba4;
    }

    public String getNabra1() {
        return nabra1;
    }

    public void setNabra1(String nabra1) {
        this.nabra1 = nabra1;
    }

    public String getNabra2() {
        return nabra2;
    }

    public void setNabra2(String nabra2) {
        this.nabra2 = nabra2;
    }

    public String getNabra3() {
        return nabra3;
    }

    public void setNabra3(String nabra3) {
        this.nabra3 = nabra3;
    }

    public String getNabra4() {
        return nabra4;
    }

    public void setNabra4(String nabra4) {
        this.nabra4 = nabra4;
    }

    public String getNjuna1() {
        return njuna1;
    }

    public void setNjuna1(String njuna1) {
        this.njuna1 = njuna1;
    }

    public String getNjuna2() {
        return njuna2;
    }

    public void setNjuna2(String njuna2) {
        this.njuna2 = njuna2;
    }

    public String getNjuna3() {
        return njuna3;
    }

    public void setNjuna3(String njuna3) {
        this.njuna3 = njuna3;
    }

    public String getNjuna4() {
        return njuna4;
    }

    public void setNjuna4(String njuna4) {
        this.njuna4 = njuna4;
    }

    public String getNagoa1() {
        return nagoa1;
    }

    public void setNagoa1(String nagoa1) {
        this.nagoa1 = nagoa1;
    }

    public String getNagoa2() {
        return nagoa2;
    }

    public void setNagoa2(String nagoa2) {
        this.nagoa2 = nagoa2;
    }

    public String getNagoa3() {
        return nagoa3;
    }

    public void setNagoa3(String nagoa3) {
        this.nagoa3 = nagoa3;
    }

    public String getNagoa4() {
        return nagoa4;
    }

    public void setNagoa4(String nagoa4) {
        this.nagoa4 = nagoa4;
    }

    public String getNocta1() {
        return nocta1;
    }

    public void setNocta1(String nocta1) {
        this.nocta1 = nocta1;
    }

    public String getNocta2() {
        return nocta2;
    }

    public void setNocta2(String nocta2) {
        this.nocta2 = nocta2;
    }

    public String getNocta3() {
        return nocta3;
    }

    public void setNocta3(String nocta3) {
        this.nocta3 = nocta3;
    }

    public String getNocta4() {
        return nocta4;
    }

    public void setNocta4(String nocta4) {
        this.nocta4 = nocta4;
    }

    public String getNdica1() {
        return ndica1;
    }

    public void setNdica1(String ndica1) {
        this.ndica1 = ndica1;
    }

    public String getNdica2() {
        return ndica2;
    }

    public void setNdica2(String ndica2) {
        this.ndica2 = ndica2;
    }

    public String getNdica3() {
        return ndica3;
    }

    public void setNdica3(String ndica3) {
        this.ndica3 = ndica3;
    }

    public String getNdica4() {
        return ndica4;
    }

    public void setNdica4(String ndica4) {
        this.ndica4 = ndica4;
    }

    public String getNfebb1() {
        return nfebb1;
    }

    public void setNfebb1(String nfebb1) {
        this.nfebb1 = nfebb1;
    }

    public String getNfebb2() {
        return nfebb2;
    }

    public void setNfebb2(String nfebb2) {
        this.nfebb2 = nfebb2;
    }

    public String getNfebb3() {
        return nfebb3;
    }

    public void setNfebb3(String nfebb3) {
        this.nfebb3 = nfebb3;
    }

    public String getNfebb4() {
        return nfebb4;
    }

    public void setNfebb4(String nfebb4) {
        this.nfebb4 = nfebb4;
    }

    public String getNabrb1() {
        return nabrb1;
    }

    public void setNabrb1(String nabrb1) {
        this.nabrb1 = nabrb1;
    }

    public String getNabrb2() {
        return nabrb2;
    }

    public void setNabrb2(String nabrb2) {
        this.nabrb2 = nabrb2;
    }

    public String getNabrb3() {
        return nabrb3;
    }

    public void setNabrb3(String nabrb3) {
        this.nabrb3 = nabrb3;
    }

    public String getNabrb4() {
        return nabrb4;
    }

    public void setNabrb4(String nabrb4) {
        this.nabrb4 = nabrb4;
    }

    public String getNjunb1() {
        return njunb1;
    }

    public void setNjunb1(String njunb1) {
        this.njunb1 = njunb1;
    }

    public String getNjunb2() {
        return njunb2;
    }

    public void setNjunb2(String njunb2) {
        this.njunb2 = njunb2;
    }

    public String getNjunb3() {
        return njunb3;
    }

    public void setNjunb3(String njunb3) {
        this.njunb3 = njunb3;
    }

    public String getNjunb4() {
        return njunb4;
    }

    public void setNjunb4(String njunb4) {
        this.njunb4 = njunb4;
    }

    public String getNagob1() {
        return nagob1;
    }

    public void setNagob1(String nagob1) {
        this.nagob1 = nagob1;
    }

    public String getNagob2() {
        return nagob2;
    }

    public void setNagob2(String nagob2) {
        this.nagob2 = nagob2;
    }

    public String getNagob3() {
        return nagob3;
    }

    public void setNagob3(String nagob3) {
        this.nagob3 = nagob3;
    }

    public String getNagob4() {
        return nagob4;
    }

    public void setNagob4(String nagob4) {
        this.nagob4 = nagob4;
    }

    public String getNoctb1() {
        return noctb1;
    }

    public void setNoctb1(String noctb1) {
        this.noctb1 = noctb1;
    }

    public String getNoctb2() {
        return noctb2;
    }

    public void setNoctb2(String noctb2) {
        this.noctb2 = noctb2;
    }

    public String getNoctb3() {
        return noctb3;
    }

    public void setNoctb3(String noctb3) {
        this.noctb3 = noctb3;
    }

    public String getNoctb4() {
        return noctb4;
    }

    public void setNoctb4(String noctb4) {
        this.noctb4 = noctb4;
    }

    public String getNdicb1() {
        return ndicb1;
    }

    public void setNdicb1(String ndicb1) {
        this.ndicb1 = ndicb1;
    }

    public String getNdicb2() {
        return ndicb2;
    }

    public void setNdicb2(String ndicb2) {
        this.ndicb2 = ndicb2;
    }

    public String getNdicb3() {
        return ndicb3;
    }

    public void setNdicb3(String ndicb3) {
        this.ndicb3 = ndicb3;
    }

    public String getNdicb4() {
        return ndicb4;
    }

    public void setNdicb4(String ndicb4) {
        this.ndicb4 = ndicb4;
    }
    
}
