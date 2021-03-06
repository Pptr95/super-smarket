package test.model;

//CHECKSTYLE:OFF

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import controller.Controller;
import controller.ControllerImpl;
import model.Lot;
import model.LotBuilder;
import model.Model;
import model.MyCustomDateImpl;
import model.Warehouse;

public class SerializationTest {

    Lot l = null;
    Lot p = null;
    
    @Test
    public void completeSerializationDeserializationCase() throws ClassNotFoundException {
        buildMilk();
        buildPasta();
        
        Model m = new Warehouse();
        Controller c = new ControllerImpl(m);
        
        c.addLot(l);
        c.addLot(p);
        
        try {
            c.saveFile("file.txt");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        Model m2 = new Warehouse();
        Controller c2 = new ControllerImpl(m2);

        try {
            c2.initialize("file.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertEquals(m.getList(null).size(), m2.getList(null).size());

    }

    private void buildMilk() {
        l = new LotBuilder()
                .name("Milk - brand")
                .checkInDate(new MyCustomDateImpl(2017,2,3))
                .expirationDate(new MyCustomDateImpl(3017,2,13))
                .quantity(36)
                .pricePerSingleItem(50)
                .build();
    }

    private void buildPasta() {
        p = new LotBuilder()
                .name("Pasta - brand2")
                .checkInDate(new MyCustomDateImpl(2017,2,8))
                .expirationDate(new MyCustomDateImpl(3017,2,13))
                .quantity(72)
                .pricePerSingleItem(60)
                .build();
    }
    
}
