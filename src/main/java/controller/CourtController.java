package controller;

import model.Court;
import model.Structure;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;

@ManagedBean
@SessionScoped
public class CourtController {

    private ArrayList<Court> courtList;

    @PostConstruct
    public void init(){
        courtList = new ArrayList<Court>();
        Court court1 = new Court();
        court1.setName("Tennisplatz 1");
        court1.setStructure(Structure.Asche);
        courtList.add(court1);

        Court court2 = new Court();
        court2.setName("Tennisplatz 2");
        court2.setStructure(Structure.Kunstrasen);
        courtList.add(court2);

        Court court3 = new Court();
        court3.setName("Tennisplatz 3");
        court3.setStructure(Structure.Rasen);
        courtList.add(court3);

        Court court4 = new Court();
        court4.setName("Tennisplatz 4");
        court4.setStructure(Structure.Asche);
        courtList.add(court4);

        Court court5 = new Court();
        court5.setName("Tennisplatz 5");
        court5.setStructure(Structure.Asche);
        courtList.add(court5);

        Court court6 = new Court();
        court6.setName("Tennisplatz 6");
        court6.setStructure(Structure.Kunstrasen);
        courtList.add(court6);

        Court court7 = new Court();
        court7.setName("Tennisplatz 7");
        court7.setStructure(Structure.Asche);
        courtList.add(court7);

        Court court8 = new Court();
        court8.setName("Tennisplatz 8");
        court8.setStructure(Structure.Rasen);
        courtList.add(court8);
    }

    public ArrayList<Court> getCourtList() {
        return courtList;
    }

    public void setCourtList(ArrayList<Court> courtList) {
        this.courtList = courtList;
    }
}
