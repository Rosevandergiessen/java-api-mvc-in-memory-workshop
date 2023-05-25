package com.booleanuk.api.requests;

import java.util.ArrayList;

public class PublisherRepository {
    private ArrayList<Publisher> publishers;

    public PublisherRepository(){
        this.publishers = new ArrayList<>();

    }

    public ArrayList<Publisher> getAll() { return this.publishers; }

    public Publisher getOne(int id){
        for (Publisher p : this.publishers){
            if (p.getId() == id){
                return p;
            }
        }
        return null;
    }

    public Publisher create(Publisher publisher){
        this.publishers.add(publisher);
        return publisher;
    }

    public Publisher update(int id, Publisher publisher){
        for (Publisher p : this.publishers){
            if (p.getId() == id){
                p.setName(publisher.getName());
                p.setCity(publisher.getCity());
                return p;
            }
        }
        return null;
    }

    public Publisher delete(int id){
        for (Publisher p : this.publishers){
            if (p.getId() == id){
                this.publishers.remove(p);
                return p;
            }
        }
        return null;
    }
}
