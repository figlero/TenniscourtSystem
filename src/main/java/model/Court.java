package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;

public class Court implements Serializable {


    private String name;

    private Structure structure;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Structure getStructure() {
        return structure;
    }

    public void setStructure(Structure structure) {
        this.structure = structure;
    }
}
