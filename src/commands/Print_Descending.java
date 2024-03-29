package commands;
import dto.Ticket;
import managers.*;
import utility.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.ListIterator;

public class Print_Descending implements Command{
    private Collection collection;
    private Console console;
    public Print_Descending(Console console,Collection collection){
        this.console =console;
        this.collection = collection;
    }
    @Override
    public void execute(String arg) {
        Object[] array =  collection.getHashMap().values().toArray();
        for(int i = array.length-1 ;i>=0;i--){
            console.print(array[i].toString());
        }

    }
}