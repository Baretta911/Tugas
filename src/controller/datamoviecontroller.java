/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.*;
import DAO.datamovieDAO;
import DAOImple.datamovieimplement;
import model.*;
import movie.MainView;
/**
 *
 * @author dhimas
 */
public class datamoviecontroller {
    MainView frame;
    datamovieimplement impdatamovie;
    List<datamovie> dm;
    
    public datamoviecontroller(MainView frame){
    this.frame = frame;
    impdatamovie = new datamovieDAO();
    dm = impdatamovie.getALL();
    }
    public void isitabel (){
        dm = impdatamovie.getALL();
        modeltabeldatamovie mm = new modeltabeldatamovie(dm);
        frame.getTabeldataMovie().setModel(mm);
    }
    public void insert(){
     datamovie dm = new datamovie();
     dm.setJudul(frame.getTxtjudul().getText());
        String alurCeritaText = frame.getTxtalur().getText();
        dm.setAlur(Double.parseDouble(alurCeritaText));
        String aktingText = frame.getTxtakting().getText();
        dm.setAkting(Double.parseDouble(aktingText));
        String penokohanText = frame.getTxtpenokohan().getText();
        dm.setPenokohan(Double.parseDouble(penokohanText));     
        impdatamovie.insert(dm);
     
    }
    public void update(){
     datamovie dm = new datamovie();
     dm.setJudul(frame.getTxtjudul().getText());
        String alurCeritaText = frame.getTxtalur().getText();
        dm.setAlur(Double.parseDouble(alurCeritaText));
        String aktingText = frame.getTxtakting().getText();
        dm.setAkting(Double.parseDouble(aktingText));
        String penokohanText = frame.getTxtpenokohan().getText();
        dm.setPenokohan(Double.parseDouble(penokohanText));     
        impdatamovie.update(dm);
    }
    public void delete(){
   String judul = frame.getTxtjudul().getText();
    impdatamovie.delete(judul);
    }

}
