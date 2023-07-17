package astratech.dla_api.model;

import javax.persistence.*;

@Entity
public class detailatribut {
    @Id
    private String id_atribut;
    private String id_koleksi;
    private String deskripsi;
    private String nama;
}
