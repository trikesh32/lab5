package managers;

import models.Vehicle;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CollectionManager {
    private Stack<Vehicle> collection;
    private Integer currentId = 1;
    private LocalDateTime lastInitTime;
    private LocalDateTime lastSaveTime;
    private final DumpManager dumpManager;
    private Map<Integer, Vehicle> vehicleMap = new HashMap<>();

    public CollectionManager(DumpManager dumpManager){
        lastInitTime = null;
        lastSaveTime = null;
        this.dumpManager = dumpManager;
    }
    public void saveCollection(){
        dumpManager.writeCollection(collection);
        lastSaveTime = LocalDateTime.now();
    }
    public Vehicle getById(Integer id){
        return vehicleMap.get(id);
    }
    public boolean isContain(Vehicle o){
        return o == null || getById(o.getId()) != null;
    }
    public Integer getNewId(){
        while (getById(currentId) != null){
            currentId += 1;
            if (currentId < 0){
                currentId = 1;
            }
        }
        return currentId;
    }
    public boolean add(Vehicle o){
        if (isContain(o)){
            return false;
        }
        vehicleMap.put(o.getId(), o);
        collection.add(o);
        return true;
    }
    public boolean remove(Integer id){
        var o = getById(id);
        if (o == null) return false;
        vehicleMap.remove(id);
        collection.remove(o);
        return true;
    }
    public void sortCollection(){
        Collections.sort(collection);
    }
    public boolean init(){
        vehicleMap.clear();
        collection = dumpManager.readCollection();
        lastInitTime = LocalDateTime.now();
        for (var o : collection){
            if (getById(o.getId()) != null){
                collection.clear();
                return false;
            } else {
                if (o.getId() > currentId){
                    currentId = o.getId();
                }
                vehicleMap.put(o.getId(), o);
            }
        }
        return true;
    }
    public LocalDateTime getLastInitTime(){
        return lastInitTime;
    }
    public  LocalDateTime getLastSaveTime(){
        return lastSaveTime;
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (var o: collection){
            res.append(o).append("\n");
        }
        return res.toString().trim();
    }

    public Stack<Vehicle> getCollection() {
        return collection;
    }
    public boolean isEmpty(){
        return collection.isEmpty();
    }

    public void clear(){
        vehicleMap.clear();
        collection.clear();
    }
    public void removeLast(){
        var o = collection.lastElement();
        remove(o.getId());
    }
}
